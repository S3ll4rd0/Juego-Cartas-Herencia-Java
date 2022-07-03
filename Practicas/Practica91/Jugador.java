package Practica91;

import java.io.Serializable;

public class Jugador implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int poder;
	private String tipos;
	private String armas;
	
	public Jugador(int poder, String tipos, String armas) {
		this.poder = poder;
		this.tipos = tipos;
		this.armas = armas;
	}

	public int getPoder() {
		return poder;
	}

	public void setPoder(int poder) {
		this.poder = poder;
	}

	public String getTipos() {
		return tipos;
	}

	public void setTipos(String tipos) {
		this.tipos = tipos;
	}

	public String getArmas() {
		return armas;
	}

	public void setArmas(String armas) {
		this.armas = armas;
	}

	@Override
	public String toString() {
		return "Jugador [poder= " + poder + ", tipo= " + tipos + ", armas= " + armas + "]";
	}
}
