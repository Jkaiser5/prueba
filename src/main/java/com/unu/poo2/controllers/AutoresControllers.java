package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
    	
    	request.setAttribute("listaAutores", modelo.listarAutores());
    	request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
    	
    	
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
