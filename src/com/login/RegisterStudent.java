package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.Dao;

/**
 * Servlet implementation class RegisterStudent
 */
@WebServlet("/RegisterStudent")
public class RegisterStudent extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dao d;
		try {
			d = new Dao();
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			d.studentRegister(name, pass);
			request.setAttribute("message","You have registered go back and login");
			request.getRequestDispatcher("registerStudent.jsp").forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			request.setAttribute("message","Oops username already used..");
			request.getRequestDispatcher("registerStudent.jsp").forward(request, response);
			e1.printStackTrace();
		}
	}

}
