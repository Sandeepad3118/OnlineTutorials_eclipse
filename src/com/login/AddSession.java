package com.login;

import com.login.dao.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddSession
 */
@WebServlet("/AddSession")
public class AddSession extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String subject = request.getParameter("subject");
		  String date = request.getParameter("date");
		  String time = request.getParameter("time");
		  String uc=request.getParameter("uniqueCode");
		  try {
			Dao d=new Dao();
			d.addSession(subject, date, time,uc);
			request.setAttribute("message","Session Added Successfully!");
			request.getRequestDispatcher("addSession.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message","There is an on going session..");
			request.getRequestDispatcher("addSession.jsp").forward(request, response);
			e.printStackTrace();
		}
		  
	}

}
