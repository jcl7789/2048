package vista;

import javax.swing.JFrame;


import modelo.Tablero;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;


public class InterfazUsuario extends JFrame implements KeyListener {
	 
	private Tablero tablero;
	private JFrame frame;
	/**
	 * Create the application.
	 */
//	
//	public static void main(String[] args) {
//		//Lo genera automaticamente el Windows Builder
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					InterfazUsuario interfazUsuario = new InterfazUsuario(new Tablero());
//				} catch (Exception e) {
//					e.printStackTrace();
//				} 
//			}
//		});
//	}
//		
	public InterfazUsuario() {
		this.tablero = new Tablero();
		initialize();				
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(UIManager.getFont("Panel.font"));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		
		JLabel margen = new JLabel("margen");
		frame.getContentPane().add(margen, BorderLayout.NORTH);
		
		JLabel margen_1 = new JLabel("margen");
		frame.getContentPane().add(margen_1, BorderLayout.WEST);
		
		JLabel margen_2 = new JLabel("margen");
		frame.getContentPane().add(margen_2, BorderLayout.SOUTH);
		
		JLabel margen_3 = new JLabel("margen");
		frame.getContentPane().add(margen_3, BorderLayout.EAST);
		
		JPanel panelExterior = new JPanel();
		frame.getContentPane().add(panelExterior, BorderLayout.CENTER);
		
		panelExterior.setLayout(new GridLayout(4, 1, 0, 0));
		
		for (int i = 0; i<16;i++) {
				//simulo una matriz con el resto.		
				//creo el label que ira dentro del panel
			//LO PUEDO DESCOMPONER EN METODOS SEPARADOS
				String valorFichaString = this.tablero.getFichaString(Math.floorDiv(i,4),i%4);
				int valorFicha = this.tablero.getFicha(Math.floorDiv(i,4),i%4);
				JLabel labelFicha = new JLabel();
				labelFicha.setText(valorFichaString);
				labelFicha.setFont(new Font("Dialog", Font.BOLD, 34));
				labelFicha.setHorizontalAlignment(SwingConstants.CENTER);
				labelFicha.setVerticalAlignment(SwingConstants.CENTER);
				
				//creo le panel
				
				
				//LO PUEDO DESCOMPONER EN METODOS SEPARADOS
				JPanel panelInterior = new JPanel ();
				panelInterior.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
				panelInterior.setBackground(this.tablero.getColor(valorFicha));
				panelInterior.add(labelFicha);
				panelExterior.add(panelInterior);
			
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
		System.out.println("Soy Un Cartel");
	}

	@Override 
	public void keyTyped(KeyEvent e) {
		  if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
	            tablero.derecha();
	    } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
	    		tablero.izquierda();
	    } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
	            tablero.arriba();
	    } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
	            tablero.abajo();
	    }
		frame.repaint();
		
		//	detectarFinal(); // Detectar cuando no quedan movimientos disponibles
		//DETECTARFINAL() VA EN LA CLASE TABLERO DESPUES DE CADA MOVIMIENTO;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		 System.out.println("Presionó Enter!");
		System.out.println("Se presiono una tecla");
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		 System.out.println("Presionó Enter!");
		System.out.println("se solto una tecla");
		
	}


}