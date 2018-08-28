package modelo;
import java.util.Arrays;
import java.util.Random;

public class Tablero {

	private int [][] tablero;
	private Random random;
	private int puntaje;
	private int[] valoresAleatorios = {2,4};
	
	public Tablero() {
		this.tablero = new int[4][4];
		this.random = new Random();
		this.puntaje=0;
//		fichaAleatoria();  // SI INICIALIZO EL TABLERO CON LAS 2 FICHAS
//		fichaAleatoria();	//SE ROMPEN LOS TEST
	}

	public int[][] getTablero(){
		return tablero;
	}
	
	public int getFicha(int fila, int columna) {
		return this.getTablero()[fila][columna];
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
	
	
	
	public void moverDerecha() {
		for (int fila = 0; fila < tablero.length; fila++) {
			///Variables auxiliares
			int pos = 3;
			int comp = pos--;
			int puntero = 3;
		
			while (pos >=0 && comp >=0) {
				//verifica que la actual y la siguiente sean iguales y distinto de 0
				if( pos >0 && getFicha(fila,pos) == getFicha(fila,comp) && getFicha(fila,pos)!=0) {
					//seteo el nuevo valor
					int valor = getFicha(fila,pos)*2;
					setFicha(0,fila,pos);	
					//reseteo el comparado
					setFicha(0,fila,comp);
					setFicha(valor,fila,puntero);
					//paso a la sig columna salteandome el nuevo "0";
					puntero--;
					pos = pos - 2;
					comp = comp -2;
					setPuntaje(getPuntaje()+valor);
				
				} else if (getFicha(fila,pos) == 0) {
					//estoy parado en un 0
					comp --;
					pos--;
				} else if(getFicha(fila,comp) == 0) {
					// el comparador esta parado en un 0
					comp --;
				} else {
					//son dos numeros distintos y distintos de 0
					int aux = getFicha(fila,pos);
					setFicha(0,fila,pos);
					setFicha(aux,fila,puntero);
					puntero--;
					pos= comp;
					comp--;
				}
			}
				if (pos >= 0) {
					//estoy parado en la ultima pos
					int aux = getFicha(fila,pos);
					setFicha(0,fila,pos);
					setFicha(aux,fila,puntero);
				}
			}	
		fichaAleatoria();
		fichaAleatoria();
	}

	public void moverIzquierda() {
		for (int fila = 0; fila < tablero.length; fila++) {
			///Variables auxiliares
			int pos = 0;
			int comp = pos++;
			int puntero = 0;
		
			while (pos<=3 && comp <=3) {
				//verifica que la actual y la siguiente sean iguales y distinto de 0
				if( pos <3 && getFicha(fila,pos) == getFicha(fila,comp) && getFicha(fila,pos)!=0) {
					//seteo el nuevo valor
					int valor = getFicha(fila,pos)*2;

					setFicha(0,fila,pos);
					//reseteo el comparado
					setFicha(0,fila,comp);
					
					setFicha(valor,fila,puntero);
					//paso a la sig columna salteandome el nuevo "0";
					puntero++;
					pos = pos + 2;
					comp = comp + 2;
					setPuntaje(getPuntaje()+valor);
				
				} else if (getFicha(fila,pos) == 0) {
					//estoy parado en un 0
					comp ++;
					pos++;
				} else if(getFicha(fila,comp) == 0) {
					// el comparador esta parado en un 0
					comp ++;
				} else {
					//son dos numeros distintos y distintos de 0
					int aux = getFicha(fila,pos);
					setFicha(0,fila,pos);
					setFicha(aux,fila,puntero);
					puntero++;
					pos= comp;
					comp++;
				}
			}
				if (pos <= 3) {
					//estoy parado en la ultima pos
					int aux = getFicha(fila,pos);
					setFicha(0,fila,pos);
					setFicha(aux,fila,puntero);
				}
				
			}
		fichaAleatoria();
		fichaAleatoria();
			
			
		}

	
	public void moverArriba() {
		for (int fila = 0; fila < tablero.length; fila++) {
			///Variables auxiliares
			int pos = 0;
			int comp = pos++;
			int puntero = 0;
		
			while (pos<=3 && comp <=3) {
				//verifica que la actual y la siguiente sean iguales y distinto de 0
				if( pos <3 && getFicha(pos,fila) == getFicha(comp,fila) && getFicha(pos,fila)!=0) {
					//seteo el nuevo valor
					int valor = getFicha(pos,fila)*2;
					//reseteo el comparado
					setFicha(0,comp,fila);
					setFicha(0,pos,fila);
					setFicha(valor,puntero,fila);
					
					//paso a la sig fila salteandome el nuevo "0";
					puntero++;
					pos = pos + 2;
					comp = comp + 2;
					setPuntaje(getPuntaje()+valor);
				
				} else if (getFicha(pos,fila) == 0) {
					//estoy parado en un 0
					comp ++;
					pos++;
				} else if(getFicha(comp,fila) == 0) {
					// el comparador esta parado en un 0
					comp ++;
				} else {
					//son dos numeros distintos y distintos de 0
					int aux = getFicha(pos,fila);
					setFicha(0,pos,fila);
					setFicha(aux,puntero,fila);
					puntero++;
					pos= comp;
					comp++;
				}
			}
				if (pos <= 3) {
					//estoy parado en la ultima pos
					int aux = getFicha(pos,fila);
					setFicha(0,pos,fila);
					setFicha(aux,puntero,fila);
				}
				
			}	
			fichaAleatoria();
			fichaAleatoria();	
		}
	
	public void moverAbajo() {
		
		for (int fila = 0; fila < tablero.length; fila++) {
			///Variables auxiliares
			int pos = 3;
			int comp = pos--;
			int puntero = 3;
		
			while (pos>=0 && comp >=0) {
				//verifica que la actual y la siguiente sean iguales y distinto de 0
				if( pos >0 && getFicha(pos,fila) == getFicha(comp,fila) && getFicha(pos,fila)!=0) {
					//seteo el nuevo valor
					int valor = getFicha(pos,fila)*2;
					//reseteo el comparado
					setFicha(0,comp,fila);
					setFicha(0,pos,fila);
					setFicha(valor,puntero,fila);
					
					//paso a la sig fila salteandome el nuevo "0";
					puntero--;
					pos = pos - 2;
					comp = comp - 2;
					setPuntaje(getPuntaje()+valor);
				
				} else if (getFicha(pos,fila) == 0) {
					//estoy parado en un 0
					comp --;
					pos--;
				} else if(getFicha(comp,fila) == 0) {
					// el comparador esta parado en un 0
					comp --;
				} else {
					//son dos numeros distintos y distintos de 0
					int aux = getFicha(pos,fila);
					setFicha(0,pos,fila);
					setFicha(aux,puntero,fila);
					puntero--;
					pos= comp;
					comp--;
				}
			}
				if (pos >= 0) {
					//estoy parado en la ultima pos
					int aux = getFicha(pos,fila);
					setFicha(0,pos,fila);
					setFicha(aux,puntero,fila);
				}
			}
			//creo dos fichas en el tablero	
			fichaAleatoria();
			fichaAleatoria();
		}
	
	
	
	public void fichaAleatoria() {
		int fila = random.nextInt(getTablero().length); //Hardcodeado , deberi poner tabero.length
		int columna = random.nextInt(getTablero().length);	
		while (!estaVacia(fila,columna)) {
			fila = random.nextInt(getTablero().length);
			columna = random.nextInt(getTablero().length);
		}				
		
		this.setFicha(valorAleatorio(),fila,columna);				
		
	}
	
	public boolean estaVacia(int fila, int columna) {
		return (getFicha(fila,columna) == 0);
	}

	public int valorAleatorio() {
		return valoresAleatorios[random.nextInt(2)];
	}

	public boolean seTermino() {
		for (int[] fila : getTablero()) {
			for (int ficha : fila) {
				if (ficha!=0) {
					return false;
					}
				}
			}
		//el tablero esta lleno		
		return true;
	}

	@Override
	public String toString() {
		String juego="";
		for (int[] fila : tablero) {
			juego = juego + ("["+fila[0]+","+fila[1]+","+fila[2]+","+fila[3]+"]\n");
		}
		return juego;
	}

}

