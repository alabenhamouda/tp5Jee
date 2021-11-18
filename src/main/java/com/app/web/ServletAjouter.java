package com.app.web;

import java.io.IOException;
import java.sql.*;
import com.app.metier.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAjouter
 */
@WebServlet("/ServletAjouter")
public class ServletAjouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjouter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Ajouter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Authentication.isAuthenticated(request)) {
			response.sendRedirect("Login.jsp");
			return;
		}
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		String ville = request.getParameter("ville");
		String email = request.getParameter("email");
		GestionUser gest = new GestionUser();
		Utilisateur user = new Utilisateur();
		user.setEmail(email);
		user.setLogin(login);
		user.setPass(pass);
		user.setVille(ville);
		try {
			gest.ajouter(user);
			request.getRequestDispatcher("ServletListe").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("error.html");
		}
	}

}
