package com.unu.poo2.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.poo2.beans.autor;

//import java.util.ArrayList;

//import com.unu.poo2.beans.autor;

public class AutorModel extends Conexion{
	
	
	CallableStatement cs;
	ResultSet rs;
	
	public List<autor> listarAutores(){
	/*ArrayList<autor> autores = new ArrayList<>();
	
	autores.add(new autor(1, "Garcia Marquez","Colombiana"));
	autores.add(new autor(2, "Borges","Argentina"));
	autores.add(new autor(3, "Allende","Chilena"));
	
	return autores;*/
	try {
		
		List<autor> lista = new ArrayList<>();
		
		String sql = "CALL sp_listarAutores()";
		this.abrirConexion();
		cs = conexion.prepareCall(sql);
		rs = cs.executeQuery();
		
		while (rs.next()) {
			autor Autor = new autor();
			Autor.setIdAutor(rs.getInt("idautor"));
			Autor.setNombreAutor(rs.getString("nombreautor"));
			Autor.setNacionalidad(rs.getString("nacionalidadautor"));
			lista.add(Autor);
		}
		
		this.cerrarConexion();
		return lista;
		
	} catch (Exception e) {
		// TODO: handle exception
		this.cerrarConexion();
		return null;
	}
	}

}

