package com.unu.poo2.beans;

public class autor {
	private int idAutor;
	private String nacionalidad;
	private String NombreAutor;

	public autor() {
		super();
	}

	public autor(int idAutor, String nacionalidad, String nombreAutor) {
		super();
		this.idAutor = idAutor;
		this.nacionalidad = nacionalidad;
		NombreAutor = nombreAutor;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombreAutor() {
		return NombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		NombreAutor = nombreAutor;
	}

}
