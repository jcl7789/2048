package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JTextField;

import modelo.Tablero;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazUsuario {
	private Tablero tablero;
	
	private JFrame frame;
	private JTextArea txtrHola;
	private JTextArea txtrRecord;
	private JLabel lblTituloJuego;
	private JPanel panel_1;
	

	/**
	 * Create the application.
	 */
	
	
	public InterfazUsuario(Tablero tablero) {
		initialize();
		this.setTablero(tablero);
	}
	
	
	// Jpanel0x0 
	//habria que hardcodear cada pos de la matriz con un jpanel????
	//p.setBackground(tablero.getColor(tablero.getValor(0,0)))); 
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(10, 11, 564, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtrHola = new JTextArea();
		txtrHola.setFont(new Font("Century Gothic", Font.BOLD, 18));
		txtrHola.setForeground(new Color(255, 255, 255));
		txtrHola.setBackground(new Color(222, 184, 135));
		txtrHola.setText("PUNTAJE :");
		txtrHola.setBounds(378, 52, 176, 34);
		panel.add(txtrHola);
		
		txtrRecord = new JTextArea();
		txtrRecord.setText("RECORD:");
		txtrRecord.setForeground(Color.WHITE);
		txtrRecord.setFont(new Font("Century Gothic", Font.BOLD, 18));
		txtrRecord.setBackground(new Color(222, 184, 135));
		txtrRecord.setBounds(378, 11, 176, 34);
		panel.add(txtrRecord);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReiniciar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnReiniciar.setBounds(32, 56, 108, 26);
		panel.add(btnReiniciar);
		
		lblTituloJuego = new JLabel("2048 - UNGS\r\n");
		lblTituloJuego.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 24));
		lblTituloJuego.setBounds(32, 11, 157, 34);
		panel.add(lblTituloJuego);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(10, 135, 580, 580);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public void mostrarCartel() {
		System.out.println("Puto El Que Lee"+"Trava el que se ríe");
	}
}
