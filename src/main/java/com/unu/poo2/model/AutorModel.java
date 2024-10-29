package com.unu.poo2.model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		e.printStackTrace();
		// TODO: handle exception
		this.cerrarConexion();
		return null;
		}
	}
	
	public int insertarAutor(autor autor) throws SQLException, IOException{
		{
			try {
				int filasAfectadas=0;
				String sql = "CAll sp_insertarAutor (?,?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setString(1, autor.getNombreAutor());
				cs.setString(2, autor.getNacionalidad());
				filasAfectadas = cs.executeUpdate();
				this.cerrarConexion();
				return filasAfectadas;
				
			}catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
				this.cerrarConexion();
				return 0;
			}
		}		
	}
	
	
	public autor obtenerAutor (int idautor) {
		
		autor autor = new autor();
		
		try {
			
			String sql = "CALL sp_obtenerAutor(?)";
			this.abrirConexion();
			cs=conexion.prepareCall(sql);
			cs.setInt(1, idautor);
			rs=cs.executeQuery();
			if (rs.next()) {
				
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setNombreAutor(rs.getString("nombre"));
				autor.setNacionalidad(rs.getString("nacionaidad"));
				this.cerrarConexion();				

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			this.cerrarConexion();
			return null;
		}
		return autor;
	}
	
	
	public int modificarAutor(autor autor) throws SQLException, IOException{
		{
			try {
				int filasAfectadas=0;
				String sql = "CAll sp_modificarAutor (?,?,?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setInt(1, autor.getIdAutor());
				cs.setString(2, autor.getNombreAutor());
				cs.setString(3, autor.getNacionalidad());
				filasAfectadas = cs.executeUpdate();
				this.cerrarConexion();
				return filasAfectadas;
				
			}catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
				this.cerrarConexion();
				return 0;
			}
		}		
	}
	
	
	public int eliminarAutor(int autor) throws SQLException, IOException{
		{
			try {
				int filasAfectadas=0;
				String sql = "CAll sp_eliminarAutor (?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setInt(1, autor);
				filasAfectadas = cs.executeUpdate();
				this.cerrarConexion();
				return filasAfectadas;
				
			}catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
				this.cerrarConexion();
				return 0;
			}
		}		
	}
	
}

