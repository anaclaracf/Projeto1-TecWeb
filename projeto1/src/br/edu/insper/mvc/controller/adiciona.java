package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.Atividades;
import br.edu.insper.mvc.model.DAO;

/**
 * Servlet implementation class adiciona
 */
@WebServlet("/adiciona")
public class adiciona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adiciona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		DAO dao =new DAO();		
		Atividades atividade = new Atividades();
		atividade.setTarefa(request.getParameter("tarefa"));
		atividade.setTipo(request.getParameter("tipo"));
		
		String tempo = request.getParameter("tempo");
		Date data = new SimpleDateFormat("dd-MM-yyyy").parse(tempo);
		Calendar dataTempo = Calendar.getInstance();      
		dataTempo.setTime(data);      
		atividade.setTempo(dataTempo);
		
		atividade.setDificuldade(Double.valueOf(request.getParameter("dificuldade")));
		dao.adiciona(atividade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("lista");
		dispatcher.forward(request, response);
		dao.close();
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
