package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.Iterator;

import com.unu.poo2.beans.autor;
import com.unu.poo2.model.AutorModel;

/**
 * Servlet implementation class AutoresControllers
 */
public class AutoresControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AutorModel modelo = new AutorModel();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoresControllers() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	if (request.getParameter("op")==null) {
    		listar(request, response);
    		return;
    	}
    	
    	String operacion = request.getParameter("op");
    	switch (operacion) {
		case "listar": 
			listar(request,response);
			break;
		case "nuevo":
			request.getRequestDispatcher("/autores/nuevoAutor.jsp").forward(request, response);
			break;
		case "insertar":
			insertar (request,response);
			break;
		case "obtener":
			obtener(request, response);
		default:
			throw new IllegalArgumentException("Unexpected value: " + operacion);
		}
    	
    	
    	
    }
    
    private void listar (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
    	
    	request.setAttribute("listaAutores", modelo.listarAutores());
    	/*
    	Iterator<autor> it = modelo.listarAutores().iterator();
    	
    	while (it.hasNext())
    	{
    		autor a = it.next();
    		System.out.println(a.getIdAutor()+" - "+a.getNombreAutor()+" - "+a.getNacionalidad());
    	}*/
    	
    	request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
    }
    
    private void insertar (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
    	try {
			autor miAutor = new autor();
			miAutor.setNombreAutor(request.getParameter("nombre"));
			miAutor.setNacionalidad(request.getParameter("nacionalidad"));
			
			if (modelo.insertarAutor(miAutor)>0) {
				request.getSession().setAttribute("exito", "autor registrado exitadamente");
				
							
			}
			
			else {
				request.getSession().setAttribute("Fracaso", "esfuerzate pendex");
				
			}
			
			
			response.sendRedirect(request.getContextPath()+"/AutoresControllers?op=listar");
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.getStackTrace();
		}
    }
    
    /*private void guardar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	try {
    		
    		
    		
    	}catch (Exception e) {
			// TODO: handle exception
    		e.getStackTrace();
		}
    	
    }*/
    	
    private void obtener (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	try {
			
    		String id = request.getParameter("id");
    		autor miautor = modelo.obtenerAutor(Integer.parseInt(id));
    		
    		if (miautor!=null) {
    			request.setAttribute("autor", miautor);
    			request.getRequestDispatcher("/autores/editarAutor.jsp").forward(request, response);
    			
    		}
    		else {
    			response.sendRedirect(request.getContextPath()+"/error 404.jsp");
    		}
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
            
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());//envia datos por la url: ejmplo busqueda, parametros
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}
	
	

	
	
}
