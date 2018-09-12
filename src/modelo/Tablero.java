package modelo;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tablero {
	
	private Map<Integer,Color> colores;
	private int[][] tablero;
	private Random random;
	private int puntaje;
	private int dimension;
	private int[] valoresAleatorios = { 2, 4 };
 
	public Tablero() {
		this.tablero = new int[4][4];
		this.random = new Random();
		this.puntaje = 0;
		this.dimension = 4;
		fichaAleatoria();
		fichaAleatoria();
		this.colores = crearColores();
	}

	private Map<Integer,Color> crearColores(){
		Map<Integer,Color> mapaDeColores = new HashMap<>();
			//las key corresponden a las potencias de 2
			mapaDeColores.put(Integer.parseInt("0"),new Color (247, 249, 249));
			mapaDeColores.put(Integer.parseInt("2"),new Color (215, 219, 221));
			mapaDeColores.put(Integer.parseInt("4"),new Color (229, 152, 102));
			mapaDeColores.put(Integer.parseInt("8"),new Color (248, 196, 113));
			mapaDeColores.put(Integer.parseInt("16"),new Color (247, 220, 111));
			mapaDeColores.put(Integer.parseInt("32"),new Color (130, 224, 170));
			mapaDeColores.put(Integer.parseInt("64"),new Color (118, 215, 196));
			mapaDeColores.put(Integer.parseInt("128"),new Color (133, 193, 233));
			mapaDeColores.put(Integer.parseInt("256"),new Color (165, 105, 189));
			mapaDeColores.put(Integer.parseInt("512"),new Color (192, 57, 43));
			mapaDeColores.put(Integer.parseInt("1024"),new Color (242, 215, 213));
			mapaDeColores.put(Integer.parseInt("2048"),new Color (241, 196, 15));	
		
			return mapaDeColores;	
	}
	
	public Map<Integer, Color> getColores(){
		return this.colores;
	}
	
	public Color getColor(int numero) {
		return getColores().get(numero);
	}
	
	public int[][] getTablero() {
		return tablero;
	}

	public int getFicha(int fila, int columna) {
		return this.getTablero()[fila][columna];
	}

	public int getDimension() {
		return dimension;
	}
	
	public void setFicha(int valor, int fila, int columna) {
		this.tablero[fila][columna] = valor;
	}

	private void setPuntaje(int i) {
		this.puntaje = i;
	}

	private int getPuntaje() {
		return this.puntaje;
	}

	public void reiniciar() {
		this.limpiarTablero();
		this.setPuntaje(0);
	}
	
	public void limpiarTablero() {
		for (int fila = 0; fila < dimension; fila++) {
			for (int columna = 0; columna < dimension; columna++) {
				this.tablero[fila][columna] = 0;
			}
		}
	}

	public void fichaAleatoria() {
		boolean bandera = true;
		while (bandera) {
			int fila = random.nextInt(dimension);
			int columna = random.nextInt(dimension);
			int valor = valorAleatorio();
			if (estaVacia(fila, columna)) {
				setFicha(valor, fila, columna);
				bandera = false;
			}
		}
	}

	public boolean tableroVacio() {
		boolean ret = true;
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero.length; columna++) {
				ret = ret && (getFicha(fila, columna) == 0);
			}
		}
		return ret;
	}

	public boolean estaVacia(int fila, int columna) {
		return (getFicha(fila, columna) == 0);
	}

	public int valorAleatorio() {
		return valoresAleatorios[random.nextInt(2)];
	}

	// Si no quedan mas movimientos disponibles, fin de juego
	public boolean seTermino() {
		for (int[] fila : getTablero()) {
			for (int ficha : fila) {
				if (ficha != 0) {
					return false;
				}
			}
		}
		// el tablero esta lleno
		return true;
	}

	@Override
	public String toString() {
		String juego = "";
		for (int[] fila : tablero) {
			juego = juego + ("[" + fila[0] + "," + fila[1] + "," + fila[2] + "," + fila[3] + "]\n");
		}
		return juego;
	}
	
	public int[] getFila(int fila) {
		
		return this.getTablero()[fila];
		
	}
//		se pude resumir el metodo con el getTablero()
//		int [] filaSola = new int[dimension] ;
//		for (int posicion = 0; posicion < dimension; posicion++) {
//			filaSola[posicion] = tablero[fila][posicion]; 
//		}
//		return filaSola;
//	}	
	
	public int[] eliminarEspaciosIzquierda(int [] fila) {
		int origen = 0;
		int posicion = 1;
		
		while (posicion < dimension) {
			if (fila[origen] == 0) { 
				if (fila[origen] != fila[posicion]) { // Se actualiza el arreglo y los parametros. //
					fila[origen] += fila[posicion];
					fila[posicion] = 0;
					origen += 1;
					posicion += 1;
				}
				else if (fila[posicion] == 0) { // Origen se mantiene y posicion(siguiente) incrementa. // 
					posicion += 1;
				}
			}		
			else { // Origen distinto de cero: incrementa origen y posicion(siguiente)
				origen += 1;
				posicion += 1;
			}
		}
		return fila;
	}
	
	public int[] acomodarFilaIzquierda(int fila) {
		int [] filaOrdenada = getFila(fila);
		int origen = 0;
		int posicion = 1;
		
		while (posicion < dimension) {
			if (filaOrdenada[origen] != 0) {
				if (filaOrdenada[origen] == filaOrdenada[posicion]) { // Origen y posicion(siguiente) iguales: se setea las posiciones del arreglo y los parametros. // 
					filaOrdenada[origen] += filaOrdenada[posicion];
					filaOrdenada[posicion] = 0;
					origen += 1;
					posicion += 1;
				}
				else if ( filaOrdenada[posicion]!=0 ){ // Origen y posicion(siguiente) no nulos y distintos: se actualiza los parametros. //
					origen = posicion;
					posicion += 1;
				}
				else { // Posicion(siguiente) igual a cero: se mantiene origen y se actualiza posicion(siguiente). //
					posicion += 1;
				}
			}
			else { // Se actualiza los parametros. //
				origen += 1;
				posicion += 1;
			}
		}
		filaOrdenada = eliminarEspaciosIzquierda(filaOrdenada);
		return filaOrdenada;
	}
	
	public void setearFila(int[] filaOrdenada, int posicionDeFila) {
		for (int puntero = 0; puntero < dimension; puntero++) {
			tablero[posicionDeFila][puntero] = filaOrdenada[puntero];
		}
	}
	
	public void izquierda() {
		for (int fila = 0; fila < dimension; fila++) {
			setearFila(acomodarFilaIzquierda(fila),fila);
		}
	}
	
	public int[] eliminarEspaciosDerecha(int [] fila) {
		int origen = 3;
		int posicion = 2;
		
		while (posicion >= 0) {
			if (fila[origen] == 0) { 
				if (fila[origen] != fila[posicion]) { // Se actualiza el arreglo y los parametros. //
					fila[origen] += fila[posicion];
					fila[posicion] = 0;
					origen -= 1;
					posicion -= 1;
				}
				else if (fila[posicion] == 0) { // Origen se mantiene y posicion(siguiente) incrementa. // 
					posicion -= 1;
				}
			}		
			else { // Origen distinto de cero: incrementa origen y posicion(siguiente)
				origen -= 1;
				posicion -= 1;
			}
		}
		return fila;
	}
	
	public int[] acomodarFilaDerecha(int fila) {
		int [] filaOrdenada = getFila(fila);
		int origen = 3;  // ultima posicion //
		int posicion = 2;// penultima posicion //
		
		while (posicion >= 0) {
			if (filaOrdenada[origen] != 0) {
				if (filaOrdenada[origen] == filaOrdenada[posicion]) { // Origen y posicion(siguiente) iguales: se setea las posiciones del arreglo y los parametros. // 
					filaOrdenada[origen] += filaOrdenada[posicion];
					filaOrdenada[posicion] = 0;
					origen -= 1;
					posicion -= 1;
				}
				else if ( filaOrdenada[posicion]!=0 ){ // Origen y posicion(siguiente) no nulos y distintos: se actualiza los parametros. //
					origen = posicion;
					posicion -= 1;
				}
				else { // Posicion(siguiente) igual a cero: se mantiene origen y se actualiza posicion(siguiente). //
					posicion -= 1;
				}
			}
			else { // Se actualiza los parametros. //
				origen -= 1;
				posicion -= 1;
			}
		}
		filaOrdenada = eliminarEspaciosDerecha(filaOrdenada);
		return filaOrdenada;
	}
	
	public void derecha() {
		for (int fila = 0; fila < dimension ; fila++) {
			setearFila(acomodarFilaDerecha(fila), fila);
		}
	}
	
	public int[] getColumna(int columna) {
		int [] columnaSola = new int[dimension] ;
		for (int posicion = 0; posicion < dimension; posicion++) {
			columnaSola[posicion] = tablero[posicion][columna]; 
		}
		return columnaSola;
	}
	
	public int[] eliminarEspaciosArriba(int [] columna) {
		int origen = 0;
		int posicion = 1;
		
		while (posicion < dimension) {
			if (columna[origen] == 0) { 
				if (columna[origen] != columna[posicion]) { // Se actualiza el arreglo y los parametros. //
					columna[origen] += columna[posicion];
					columna[posicion] = 0;
					origen += 1;
					posicion += 1;
				}
				else if (columna[posicion] == 0) { // Origen se mantiene y posicion(siguiente) incrementa. // 
					posicion += 1;
				}
			}		
			else { // Origen distinto de cero: incrementa origen y posicion(siguiente)
				origen += 1;
				posicion += 1;
			}
		}
		return columna;
	}
	
	public int[] acomodarColumnaArriba(int columna) {
		int [] columnaOrdenada = getColumna(columna);
		int origen = 0;
		int posicion = 1;
		
		while (posicion < dimension) {
			if (columnaOrdenada[origen] != 0) {
				if (columnaOrdenada[origen] == columnaOrdenada[posicion]) { // Origen y posicion(siguiente) iguales: se setea las posiciones del arreglo y los parametros. // 
					columnaOrdenada[origen] += columnaOrdenada[posicion];
					columnaOrdenada[posicion] = 0;
					origen += 1;
					posicion += 1;
				}
				else if ( columnaOrdenada[posicion]!=0 ){ // Origen y posicion(siguiente) no nulos y distintos: se actualiza los parametros. //
					origen = posicion;
					posicion += 1;
				}
				else { // Posicion(siguiente) igual a cero: se mantiene origen y se actualiza posicion(siguiente). //
					posicion += 1;
				}
			}
			else { // Se actualiza los parametros. //
				origen += 1;
				posicion += 1;
			}
		}
		columnaOrdenada = eliminarEspaciosArriba(columnaOrdenada);
		return columnaOrdenada;
	}
	
	public void setearColumna(int[] columnaOrdenada, int posicionDeColumna) {
		for (int puntero = 0; puntero < dimension; puntero++) {
			tablero[puntero][posicionDeColumna] = columnaOrdenada[puntero];
		}
	}
	
	public void arriba() {
		for (int columna = 0; columna < dimension ; columna++) {
			setearColumna(acomodarColumnaArriba(columna), columna);
		}
	}
	
	public int[] eliminarEspaciosAbajo(int [] columna) {
		int origen = 3;
		int posicion = 2;
		
		while (posicion >= 0) {
			if (columna[origen] == 0) { 
				if (columna[origen] != columna[posicion]) { // Se actualiza el arreglo y los parametros. //
					columna[origen] += columna[posicion];
					columna[posicion] = 0;
					origen -= 1;
					posicion -= 1;
				}
				else if (columna[posicion] == 0) { // Origen se mantiene y posicion(siguiente) incrementa. // 
					posicion -= 1;
				}
			}		
			else { // Origen distinto de cero: incrementa origen y posicion(siguiente)
				origen -= 1;
				posicion -= 1;
			}
		}
		return columna;
	}
	
	public int[] acomodarColumnaAbajo(int columna) {
		int [] columnaOrdenada = getColumna(columna);
		int origen = 3;
		int posicion = 2;
		
		while (posicion >= 0) {
			if (columnaOrdenada[origen] != 0) {
				if (columnaOrdenada[origen] == columnaOrdenada[posicion]) { // Origen y posicion(siguiente) iguales: se setea las posiciones del arreglo y los parametros. // 
					columnaOrdenada[origen] += columnaOrdenada[posicion];
					columnaOrdenada[posicion] = 0;
					origen -= 1;
					posicion -= 1;
				}
				else if ( columnaOrdenada[posicion]!=0 ){ // Origen y posicion(siguiente) no nulos y distintos: se actualiza los parametros. //
					origen = posicion;
					posicion -= 1;
				}
				else { // Posicion(siguiente) igual a cero: se mantiene origen y se actualiza posicion(siguiente). //
					posicion -= 1;
				}
			}
			else { // Se actualiza los parametros. //
				origen -= 1;
				posicion -= 1;
			}
		}
		columnaOrdenada = eliminarEspaciosAbajo(columnaOrdenada);
		return columnaOrdenada;
	}

	public void abajo() {
		for (int columna = 0; columna < dimension ; columna++) {
			setearColumna(acomodarColumnaAbajo(columna), columna);
		}
	}
	
}
