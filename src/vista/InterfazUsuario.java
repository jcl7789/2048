package vista;

import javax.swing.JFrame;


import modelo.Tablero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class InterfazUsuario {
	
	private JLabel[][] jfichas = new JLabel[4][4];
	private Tablero tablero;
	private JFrame frame;
//	private JTable table;
	

	/**
	 * Create the application.
	 */
	
	public static void main(String[] args) {
		//Lo genera automaticamente el Windows Builder
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfazUsuario interfazUsuario = new InterfazUsuario(new Tablero());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	public InterfazUsuario(Tablero tablero) {
		this.tablero = tablero;
		initialize();
		
		
	}
	///Se actualiza solo el valor de los paneles? o queda ahi fijo???
	//revisar que clase me conviene usar, is panel boton o lo que sea	
	

	
    ///voy a hacer una matriz de panles o botones o lo que sea
	//el panel 0,0 se corresponde con la pos 0,0 del tablero y asi sucesivamente
	// en el campo de texto van a tener el valor (0,2,4,8...) que tenga su correspondiente pos del tablero
	//cada panel vas a sacar el color tambien a traves del tablero.
	//por lo que entendi no hace falta un keylistener en esta clase sino que con la de
	//controladorJuego alcanza (la interfaz no debe tener logica)
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(460, 650));
		frame.getContentPane().setLayout(null);
		
		int posY = 100;
		int ancho = 100;
		int alto = 100;
		int espacio = 2;
		//se crea una matriz de fichas
		for(int i = 0; i < jfichas.length; i++){
			int posX = 20;
			posY+=alto+espacio;
			for (int j = 0; j<jfichas.length;j++) {
				int valorFicha = this.tablero.getFicha(i,j);
	        	JLabel aux = new JLabel();
	        	aux.setBackground(this.tablero.getColor(valorFicha));
	        	aux.setText(Integer.toString(valorFicha));
	        	aux.setBounds(posX, posY, ancho, alto);
	        	aux.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	        	jfichas[i][j] = aux;
	        	posX+=ancho+espacio;
	        	
	        	frame.getContentPane().add(aux);
			}
		}		
		
		
		
		
		frame.setVisible(true);
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public void mostrarCartel() {
		System.out.println("Soy Un Cartel (Porque es un cartel)");
	}
}
