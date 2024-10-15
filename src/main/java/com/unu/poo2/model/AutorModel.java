package com.unu.poo2.model;

import java.util.ArrayList;

import com.unu.poo2.beans.autor;

public class AutorModel {
	public ArrayList<autor> listarAutores(){
		ArrayList<autor> autores = new ArrayList<>();
		
		autores.add(new autor(1, "Garcia Marquez","Colombiana"));
		autores.add(new autor(2, "Borges","Argentina"));
		autores.add(new autor(3, "Allende","Chilena"));
		
		return autores;
	}
}
