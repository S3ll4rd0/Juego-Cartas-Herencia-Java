package Practica93;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreadorDeCartas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Carta> cartas = new ArrayList<>();
	private String ruta;
	private File fichero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreadorDeCartas frame = new CreadorDeCartas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreadorDeCartas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenuJuego = new JMenu("Juego");
		menuBar.add(mnNewMenuJuego);
		
		JMenuItem mntmNewMenuItemGuardar = new JMenuItem("Guardar");
		mnNewMenuJuego.add(mntmNewMenuItemGuardar);
		
		JMenuItem mntmNewMenuItemSalir = new JMenuItem("Salir");
		mnNewMenuJuego.add(mntmNewMenuItemSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textAreaPregunta = new JTextArea();
		textAreaPregunta.setBounds(50, 40, 300, 250);
		contentPane.add(textAreaPregunta);
		
		JTextArea textAreaRespuesta = new JTextArea();
		textAreaRespuesta.setBounds(50, 335, 300, 250);
		contentPane.add(textAreaRespuesta);
		
		JLabel lblPregunta = new JLabel("Pregunta");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPregunta.setBounds(10, 15, 80, 13);
		contentPane.add(lblPregunta);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		lblRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRespuesta.setBounds(10, 310, 80, 13);
		contentPane.add(lblRespuesta);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSiguiente.setBounds(125, 610, 150, 25);
		contentPane.add(btnSiguiente);
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generaNuevaCarta(textAreaPregunta.getText(), textAreaRespuesta.getText());
				textAreaPregunta.setText("");
				textAreaRespuesta.setText("");
			}
		});
		
		mntmNewMenuItemGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarCartas();
			}
		});
		
		mntmNewMenuItemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void generaNuevaCarta(String pregunta, String respuesta) {
		Carta carta = new Carta(pregunta, respuesta);
		cartas.add(carta);
	}
	
	public void guardarCartas() {
		try {
			
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(contentPane);
			
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				fichero = fileChooser.getSelectedFile();
				ruta = fichero.getAbsolutePath();
				ruta += ".txt";
			}
			
			FileWriter writer = new FileWriter(ruta);
			for (Carta carta : cartas) {
				writer.write(carta.toString());
			}
			writer.close();
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
