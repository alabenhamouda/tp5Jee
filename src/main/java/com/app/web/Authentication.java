package com.app.web;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Authentication {
	public static boolean isAuthenticated(HttpServletRequest request) {
		HttpSession s = request.getSession(false);
		return s != null && s.getAttribute("user") != null;
	}
}
