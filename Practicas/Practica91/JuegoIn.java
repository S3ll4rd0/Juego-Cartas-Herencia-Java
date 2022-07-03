package Practica91;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class JuegoIn {

	public static void main (String [] args) {
		
		// Input
		Jugador jug1 = null;
		Jugador jug2 = null;
		Jugador jug3 = null;
		
		try {
			
			FileInputStream fileInStream = new FileInputStream("MyGame.ser");
			ObjectInputStream oIs = new ObjectInputStream(fileInStream);
			
			jug1 = (Jugador) oIs.readObject();
			jug2  = (Jugador) oIs.readObject();
			jug3  = (Jugador) oIs.readObject();
			
			oIs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(jug1.toString());
		System.out.println(jug2.toString());
		System.out.println(jug3.toString());
	}
}
