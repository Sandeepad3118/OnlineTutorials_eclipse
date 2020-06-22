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
 * Servlet implementation class Unique
 */
@WebServlet("/Unique")
public class Unique extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String code=request.getParameter("unique");
		if(session.getAttribute("uniqueCode").equals(code)){
			session.setAttribute("unique","yes");
			response.sendRedirect("viewSession.jsp");
		}
		else
		{
			request.setAttribute("message","Invalid unique code");
			request.getRequestDispatcher("viewSession.jsp").forward(request, response);
		}
	}

}
