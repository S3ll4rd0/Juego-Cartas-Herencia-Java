package Practica93;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Juego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Carta> cartas = new ArrayList<>();
	private String rutaAbs = null;
	private String archivo = "";
	private int value = 0;
	private int contCartas = 0;
	private Carta cartita;
	private StringTokenizer tokenizer;
	private String pregunta = "", respuesta = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
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
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Juego");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItemJugar = new JMenuItem("Jugar");
		mnNewMenu.add(mntmNewMenuItemJugar);
		
		JMenuItem mntmNewMenuItemSalir = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItemSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Pregunta:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setBounds(10, 10, 80, 15);
		contentPane.add(lblTitle);
		
		JTextArea textAreaPregunta = new JTextArea();
		textAreaPregunta.setBounds(10, 30, 420, 100);
		contentPane.add(textAreaPregunta);
		
		JButton btnVerRespuesta = new JButton("Ver Respuesta");
		btnVerRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerRespuesta.setBounds(50, 165, 150, 30);
		contentPane.add(btnVerRespuesta);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSiguiente.setBounds(250, 165, 150, 30);
		contentPane.add(btnSiguiente);
		
		JTextArea textAreaRespuesta = new JTextArea();
		textAreaRespuesta.setBounds(10, 240, 420, 70);
		contentPane.add(textAreaRespuesta);
		
		JLabel lbltitle = new JLabel("Respuesta:");
		lbltitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltitle.setBounds(10, 210, 80, 15);
		contentPane.add(lbltitle);
		
		btnVerRespuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaRespuesta.setText(cartita.getRespuesta());
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contCartas < cartas.size()) {
					cartita = cartas.get(contCartas);
					textAreaPregunta.setText(cartita.getPregunta());
					contCartas++;
				} else {
					contCartas = 0;
					cartita = cartas.get(contCartas);
					textAreaPregunta.setText(cartita.getPregunta());
					contCartas++;
				}
			}
		});
		
		mntmNewMenuItemJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leerFichero();
				cartita = cartas.get(contCartas);
				textAreaPregunta.setText(cartita.getPregunta());
				contCartas++;
			}
		});
		
		mntmNewMenuItemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void leerFichero() {
		try {
			
			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(contentPane);
			
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File fichero = fileChooser.getSelectedFile();
				rutaAbs = fichero.getAbsolutePath();
			}
			
			FileReader reader = new FileReader(rutaAbs);
			while((value = reader.read()) != -1) {
				archivo += (char) value;
			}
			reader.close();
			
			System.out.println(archivo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tokenizer = new StringTokenizer(archivo, "#");
		value = tokenizer.countTokens();
		
		for (int i = 0; i < value; i++) {
			if (i%2 == 0) {
				pregunta = tokenizer.nextToken();
			} else {
				respuesta = tokenizer.nextToken();
				Carta carta = new Carta(pregunta, respuesta);
				cartas.add(carta);
			}
		}
	}
}
