package br.edu.insper.mvc.controller;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import br.edu.insper.mvc.model.Atividades;
import br.edu.insper.mvc.model.DAO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lista")

public class Lista extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		DAO dao=new DAO();
		List<Atividades> atividades = dao.getLista();
		request.setAttribute("atividades",atividades);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/cabecalho.jsp");
		dispatcher.forward(request, response);
		dao.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}			
}
