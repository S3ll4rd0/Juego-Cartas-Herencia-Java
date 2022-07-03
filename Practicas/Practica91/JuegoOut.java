package Practica91;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class JuegoOut {

	public static void main (String [] args) {
		
		// Jugadores
		Jugador elfo = new Jugador(50, "Elfo", "Arco, Espada y polvo");
		Jugador troll = new Jugador(200, "Troll", "Garras, Brazos Gigantes");
		Jugador mago = new Jugador(120, "Mago", "Hechizos, Invisibilidad");
		
		try {
			
			System.out.println(elfo.toString());
			System.out.println(troll.toString());
			System.out.println(mago.toString());
			
			// Output
			FileOutputStream fileOutStream = new FileOutputStream("MyGame.ser");
			ObjectOutputStream oOs = new ObjectOutputStream(fileOutStream);
			
			oOs.writeObject(elfo);
			oOs.writeObject(troll);
			oOs.writeObject(mago);
			
			oOs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
}
