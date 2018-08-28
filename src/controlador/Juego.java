package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Tablero;
import vista.InterfazUsuario;

public class Juego {
	
	private Tablero tablero;
	private InterfazUsuario interfaz;	
	
public Juego() {
	this.tablero = new Tablero();
	this.interfaz = new InterfazUsuario(tablero);
	
	}

public void jugar() {
		
		//// se fija las teclas que se presionaron
		//// e invoca a los metodos de tablero
		
		}

}
//clase privada para manejar las teclas presionadas en el teclado
 class ManejadorDeTeclado implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
 }


