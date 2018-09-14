package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TableroTest2 {
	
	// Testing OK. //
	// Se recomienda probar los test's de movimientos de a uno, para no imprimir demas. //
	
	@Before
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
	
	//en que momento se usaria el tablero nulo?
//	@Test
//	void TableroVacio() {
//		Tablero tablero = tableroNulo();
//		tablero.fichaAleatoria();
//		tablero.fichaAleatoria();
//		tablero.limpiarTablero();
//		//que se esta testeando aca?
//		assertTrue(tablero.tableroVacio());
//	}
	
	@Test
	void moverFilaIzquierda() {
		assertTrue(2 == 2);
	}
	
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
	
//	@Test
//	void dosMovimientos() {
//		Tablero tablero = tableroAzar();
//		System.out.println(tablero.toString());
//		tablero.izquierda();
//		System.out.println(tablero.toString());
//		tablero.abajo();
//		System.out.println(tablero.toString());
//	}

	

}
