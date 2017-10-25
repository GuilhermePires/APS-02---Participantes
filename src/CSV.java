import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSV {

	public static void main(String[] args) {
		CSV objeto = new CSV();
		objeto.goahead();

	}

	public void goahead() {
		BufferedReader buff = null;
		String CSV = "C:/Users/Guilherme/Desktop/labtrab/participantes.csv";
		String linha = "";
		String CSVDiv = ",";
		
		try {
			buff = new BufferedReader(new FileReader(CSV));
			
			while ((linha = buff.readLine()) != null) {
				
				String[] contacts = linha.split(CSVDiv);
				
				Participantes participante = new Participantes(contacts[contacts.length - 2],contacts[contacts.length - 1]);
				System.out.println("Nome: "+participante.getNome() + " Email: "+participante.getEmail());
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if (buff != null) {
				try {
					buff.close();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				}
			}
		}
	}

}