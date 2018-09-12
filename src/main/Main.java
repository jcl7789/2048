package main;

import java.awt.EventQueue;

import controlador.ControladorJuego;

public class Main { 

	public static void main(String[] args) {
		//Lo genera automaticamente el Windows Builder
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ControladorJuego nuevoJuego = new ControladorJuego();	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
