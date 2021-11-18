package com.app.dao;

import java.sql.*;
import java.util.Vector;
import com.app.metier.*;

public class GestUsersDAO {
	public Utilisateur loadUser(String login, String pass) throws SQLException {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		PreparedStatement ps = conn.prepareStatement("select * from Utilisateurs where login=? and pass=?");
		ps.setString(1, login);
		ps.setString(2, pass);
		ResultSet rsUser = ps.executeQuery();
		if (rsUser.next()) {
			u = new Utilisateur();
			u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
			u.setLogin(rsUser.getString("LOGIN"));
			u.setPass(rsUser.getString("PASS"));
			u.setEmail(rsUser.getString("EMAIL"));
			u.setVille(rsUser.getString("VILLE"));
		}
		return u;
	}

	public void addUser(String l, String p, String e, String v) throws SQLException {
		Connection conn = Utilitaire.getConnection();
		Utilisateur u = null;
		PreparedStatement ps = conn
				.prepareStatement("insert into Utilisateurs(LOGIN,PASS,EMAIL,VILLE) values(?,?,?,?)");
		ps.setString(1, l);
		ps.setString(2, p);
		ps.setString(3, e);
		ps.setString(4, v);
		ps.executeUpdate();
	}

	public Vector selectAll() throws SQLException {
		Connection conn = Utilitaire.getConnection();
		Vector users = new Vector();
		Utilisateur u = null;
		PreparedStatement ps = conn.prepareStatement("select * from Utilisateurs");
		ResultSet rsUser = ps.executeQuery();
		while (rsUser.next()) {
			u = new Utilisateur();
			u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
			u.setLogin(rsUser.getString("LOGIN"));
			u.setPass(rsUser.getString("PASS"));
			u.setEmail(rsUser.getString("EMAIL"));
			u.setVille(rsUser.getString("VILLE"));
			users.add(u);
		}
		return users;
	}
	public void deleteUser(String login, String pass) throws SQLException {
		Connection conn = Utilitaire.getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM Utilisateurs WHERE LOGIN = ? AND PASS = ?");
		ps.setString(1, login);
		ps.setString(2, pass);
		ps.execute();
	}
	public void modifyUser(String login, String pass, String email, String ville, String newLogin, String newPass) throws SQLException {
		Connection conn = Utilitaire.getConnection();
		PreparedStatement ps = conn.prepareStatement("UPDATE Utilisateurs SET EMAIL = ?, VILLE = ?, LOGIN = ?, PASS = ? WHERE LOGIN = ? AND PASS = ?");
		ps.setString(1, email);
		ps.setString(2, ville);
		ps.setString(3, newLogin);
		ps.setString(4, newPass);
		ps.setString(5, login);
		ps.setString(6, pass);
		ps.execute();
	}
}