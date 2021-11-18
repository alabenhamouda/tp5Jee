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
 * Servlet implementation class ServletModifier
 */
@WebServlet("/ServletModifier")
public class ServletModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModifier() {
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
		if (!Authentication.isAuthenticated(request)) {
			response.sendRedirect("Login.jsp");
			return;
		}
		request.getRequestDispatcher("Modifier.jsp").forward(request, response);
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
		String email = request.getParameter("email");
		String ville = request.getParameter("ville");
		String newLogin = request.getParameter("newLogin");
		String newPass = request.getParameter("newPassword");
		Utilisateur u = new Utilisateur();
		u.setEmail(email);
		u.setLogin(newLogin);
		u.setPass(newPass);
		u.setVille(ville);
		GestionUser gest = new GestionUser();
		try {
			gest.modifier(u, login, pass);
			response.sendRedirect("ServletListe");
		} catch (SQLException e) {
			response.sendRedirect("error.html");
		}
	}

}
