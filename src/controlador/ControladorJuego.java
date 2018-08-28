package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Tablero;
import vista.InterfazUsuario;

public class ControladorJuego {
	
	private Tablero tablero;
	private InterfazUsuario interfaz;	
	private ManejadorDeTeclado manejadorDeTeclado;
	
public ControladorJuego() {
	this.tablero = new Tablero();
	this.interfaz = new InterfazUsuario(tablero);
	this.manejadorDeTeclado = new ManejadorDeTeclado();
	}

public void jugar() {
		while (!tablero.seTermino()) {
			manejadorDeTeclado.keyTyped();
		}
	
		}
//clase privada que implementa una interfaz keylistener
//se fija que tecla se presiono y decide que hacer.
class ManejadorDeTeclado implements KeyListener {
	
	public ManejadorDeTeclado() {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
	  
	if (e.getKeyCode()== 37) {
		//izquierda
		tablero.moverIzquierda();
	
    } else if (e.getKeyChar()== 38) {
		//arriba
    	tablero.moverArriba();
    	
	} else if (e.getKeyChar()== 39) {
//		//derecha	
		tablero.moverDerecha();
		
	} else if (e.getKeyChar()== 40) {
//		//abajo	
		tablero.moverAbajo();
		}
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

}


