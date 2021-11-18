package com.app.metier;

import com.app.dao.*;
import java.sql.*;
import java.util.*;

public class GestionUser {
	GestUsersDAO dao;

	public GestionUser() {
		dao = new GestUsersDAO();
	}

	public Utilisateur Chercher(String login, String pass) throws SQLException {
		return dao.loadUser(login, pass);
	}

	public void ajouter(Utilisateur u) throws SQLException {
		dao.addUser(u.getLogin(), u.getPass(), u.getEmail(), u.getVille());
	}

	public Vector lister() throws SQLException {
		return dao.selectAll();
	}

	public void supprimer(String login, String pass) throws SQLException {
		dao.deleteUser(login, pass);
	}
	
	public void modifier(Utilisateur u, String login, String pass) throws SQLException {
		dao.modifyUser(login, pass, u.getEmail(), u.getVille(), u.getLogin(), u.getPass());
	}
}
