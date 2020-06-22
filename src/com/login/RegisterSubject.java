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
 * Servlet implementation class RegisterSubject
 */
@WebServlet("/RegisterSubject")
public class RegisterSubject extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Dao d = new Dao();
			HttpSession session=request.getSession();
			String uname=(String)session.getAttribute("username");
			if(request.getParameter("python")!=null){
				d.addStudentsPython(uname);
			}
			else if(request.getParameter("java")!=null){
				d.addStudentsJava(uname);
			}
			request.setAttribute("message","You have successfully registered!!");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			request.setAttribute("message","You have already registered");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
