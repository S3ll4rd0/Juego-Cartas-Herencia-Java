package Practica92;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LeerCarta {
	public static void main (String [] args) {
		
		ArrayList<Carta> cartas = new ArrayList<>();
		
		try {
			
			File file = new File("C:\\Users\\tonet\\Desktop\\fichero.txt");
			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);
			
			String line = null;
			String question = null;
			String answer = null;
			int counter = 1;
			
			while ((line = buffer.readLine()) != null) {
				String [] questions = line.split("/");
				for (String token : questions) {
					if (counter == 1) {
						question = token;
						counter = 2;
					} else {
						answer = token;
						counter = 1;
						Carta carta = new Carta(question, answer);
						cartas.add(carta);
					}
				}
			}
			
			buffer.close();
			
			for (Carta carta : cartas) {
				System.out.println(carta.toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
