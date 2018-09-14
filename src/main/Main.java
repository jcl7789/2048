package main;

import java.awt.EventQueue;

import modelo.Tablero;
import vista.InterfazUsuario;

public class Main { 

	public static void main(String[] args) {
		//Lo genera automaticamente el Windows Builder
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					InterfazUsuario juego = new InterfazUsuario();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

}
