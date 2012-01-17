package com.telcel.web.ingw.dto;

public class Prepago {

	private String telefono;
	private int region;
	
	public Prepago(){}

	public Prepago(String telefono, int region) {
		super();
		this.telefono = telefono;
		this.region = region;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

}
