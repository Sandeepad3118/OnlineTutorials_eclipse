package com.login;
import com.login.dao.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dao d;
		try {
			d = new Dao();
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
				if(d.check(name, pass)){
					HttpSession session=request.getSession();
					session.setAttribute("username",name);
					response.sendRedirect("home.jsp");
				}
				else{
					response.sendRedirect("login.jsp");
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
