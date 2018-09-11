package vista;

import javax.swing.JFrame;


import modelo.Tablero;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class InterfazUsuario {
	
	private JLabel[][] jfichas = new JLabel[4][4];
	private Tablero tablero;
	private JFrame frame;
	private JTable table;
	

	/**
	 * Create the application.
	 */
	
	
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
		frame.getContentPane().setLayout(null);
		
		//se crea una matriz de fichas
		for(int i = 0; i < jfichas.length; i++){
	        for (int j =0; j<jfichas.length;j++) {
				int valorFicha = this.tablero.getFicha(i,j);
	        	JLabel aux = new JLabel();
	        	aux.setBackground(this.tablero.getColor(valorFicha));
	        	aux.setText(Integer.toString(valorFicha));
	        	jfichas[i][j] = aux;
	        }
		}		
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{jfichas[0][0],jfichas[0][1],jfichas[0][2],jfichas[0][3]},
				{jfichas[1][0],jfichas[1][1],jfichas[1][2],jfichas[1][3]},
				{jfichas[2][0],jfichas[2][1],jfichas[2][2],jfichas[2][3]},
				{jfichas[3][0],jfichas[3][1],jfichas[3][2],jfichas[3][3]},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			/**
			 * 
			 */
//			private static final long serialVersionUID = 1L; //que significa esto?
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(0).setMinWidth(70);
		table.getColumnModel().getColumn(0).setMaxWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setMinWidth(70);
		table.getColumnModel().getColumn(1).setMaxWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setMinWidth(70);
		table.getColumnModel().getColumn(2).setMaxWidth(70);
		
		table.setColumnSelectionAllowed(true);
		table.setBounds(10, 192, 420, 420);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(table);
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
