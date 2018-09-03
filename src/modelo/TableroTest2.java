package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableroTest2 {
	
	// Testing OK. //
	// Se recomienda probar los test's de movimientos de a uno, para no imprimir demas. //
	
	
	private Tablero tableroNulo() {
		Tablero tablero = new Tablero();
		tablero.limpiarTablero();
		return tablero;
	}
	
	private Tablero tableroAzar() {
		Tablero tablero = new Tablero();	// 2 fichas. //
		for (int i = 1; i <= 8; i++) {		// 8 fichas. //
			tablero.fichaAleatoria();
		}
		return tablero;						// Tablero con 10 fichas aleatorias. //
	}
	
	@Test
	void TableroVacio() {
		Tablero tablero = tableroNulo();
		tablero.fichaAleatoria();
		tablero.fichaAleatoria();
		tablero.limpiarTablero();
		assertTrue(tablero.tableroVacio());
	}
	
	/*@Test
	void moverFilaIzquierda() {
		Tablero tablero = tableroAzar();
		System.out.println(tablero.toString());
		tablero.izquierda();
		System.out.println(tablero.toString());
	}*/
	
	/*@Test
	void moverFilaDerecha() {
		Tablero tablero = tableroAzar();
		System.out.println(tablero.toString());
		tablero.derecha();
		System.out.println(tablero.toString());
	}*/
	
	/*@Test
	void moverColumnaArriba() {
		Tablero tablero = tableroAzar();
		System.out.println(tablero.toString());
		tablero.arriba();
		System.out.println(tablero.toString());
	}*/
	
	/*@Test
	void moverColumnaAbajo() {
		Tablero tablero = tableroAzar();
		System.out.println(tablero.toString());
		tablero.abajo();
		System.out.println(tablero.toString());
	}*/
	
	@Test
	void dosMovimientos() {
		Tablero tablero = tableroAzar();
		System.out.println(tablero.toString());
		tablero.izquierda();
		System.out.println(tablero.toString());
		tablero.abajo();
		System.out.println(tablero.toString());
	}

	

}
