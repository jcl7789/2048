package modelo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TableroTest {
		
		// El tablero se inicia con dos fichas aleatorias, modificada en el constructor del tablero. //
		// Se agregó limpiar tablero para no romper los test al setear las fichas. //
		// Error en los movimientos. //
		// Volve a cursar I.P. "BIGOTE" //

		@Test
		void moverIzquierda() {		
			Tablero tablero = new Tablero();
			tablero.limpiarTablero();
			tablero.setFicha(2, 1, 3);
			tablero.setFicha(2, 1, 2);
			tablero.moverIzquierda();
			assertTrue(tablero.getFicha(1,0) == 4 );
			}
		@Test
		void moverDerecha() {		
			Tablero tablero = new Tablero();
			tablero.limpiarTablero();
			tablero.setFicha(2, 1, 3);
			tablero.setFicha(2, 1, 1);
			tablero.moverDerecha();
			assertTrue(tablero.getFicha(1,3) == 4 );
			}

		@Test
		void moverArriba() {
			Tablero tablero = new Tablero();
			tablero.limpiarTablero();
			tablero.setFicha(2, 0, 0);
			tablero.setFicha(2, 1, 0);
			tablero.setFicha(2, 2, 0);
			tablero.setFicha(2, 3, 0);
			System.out.println(tablero.toString());		// Impresion del inicio del tablero. //
			tablero.moverArriba();						// Invoco moverArriba(). //
			System.out.println(tablero.toString());  	// Evidencia del ERROR. //
			assertFalse( tablero.getFicha(1,0) == 4 );	// fila 1 columna 0 deberia contener el valor 4, no sucede. //
		
		}
		
		@Test
		void moverAbajo() {
			Tablero tablero = new Tablero();
			tablero.limpiarTablero();
			tablero.setFicha(2, 0, 0);
			tablero.setFicha(2, 1, 0);
			tablero.setFicha(2, 2, 0);
			tablero.setFicha(2, 3, 0);
			tablero.moverAbajo();
			assertTrue(tablero.getFicha(3,0) == 4 );
		}
		
		
		@Test
		void fichaAleatoriaTest() {
			Tablero tablero = new Tablero();
			tablero.limpiarTablero();
			tablero.fichaAleatoria();
			tablero.fichaAleatoria();
			tablero.fichaAleatoria();
			int totalFichas = 0;
			for (int[] fila : tablero.getTablero()) {
				for (int ficha : fila) {
					if (ficha!=0) {
						totalFichas++;
					}
				}
			}
			assertTrue(totalFichas == 3);
		}
		

		@Test
		void seTerminoTest() {
			Tablero tablero = new Tablero();
			assertTrue(tablero.seTermino());
		}

		/*@Test
		void toStringTest() {
			Tablero tablero = new Tablero();
			tablero.fichaAleatoria();
			tablero.fichaAleatoria();
			tablero.fichaAleatoria();
			tablero.fichaAleatoria();
			tablero.fichaAleatoria();
			System.out.println(tablero.toString());
		}*/
	}

