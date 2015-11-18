package com;

public class Colectivo {
/*
 * Empresa: Semtur, Mixta, Rosario Bus. Linea: 101 a 153, K, ronda centro, etc...
Numero de interno: un numero entero

 */
	private String empresa,linea;
	private int interno;
	public Colectivo(String empresa, int interno,String linea) {
		
		this.linea = linea;
		this.empresa = empresa;
		this.interno = interno;
	}
	
	public String getLinea() {
		return linea;
	}
	
	

	@Override
	public String toString() {
		return "Colectivo [empresa=" + empresa+ ", linea=" + linea + ", interno=" + interno + "]";
	}
	
	
	
	
}
