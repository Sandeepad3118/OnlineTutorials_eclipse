package com.login;
import com.login.dao.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WatchCourse
 */
@WebServlet("/WatchCourse")
public class WatchCourse extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session=request.getSession();
			String subject="";
			Dao d=new Dao();
			if(request.getParameter("watch").equals("Java")){
				subject="java";
				d.session("java");
			}
			else if(request.getParameter("watch").equals("Python")){
				subject="python";
				d.session("python");
			}
			if(d.date.equals("")&&d.time.equals("")){
				request.setAttribute("message","No uppcoming sessions..");
				request.getRequestDispatcher("yourcourse.jsp").forward(request,response);
			}
			else
			{
				SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd"); 
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String formattedDate = myDateObj.format(myFormatObj);
				Date d1 = sdfo.parse(d.date); 
				Date d2 = sdfo.parse(formattedDate); 
	        // Compare the dates 
				if (d1.before(d2)||d1.equals(d2)) { 
					// When Date d1 < Date d2 
					if(d1.equals(d2)){
						LocalTime myObj = LocalTime.now();
					    myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
					    LocalTime time1 = LocalTime.parse(d.time); 
					    LocalTime time2= LocalTime.parse(myObj.format(myFormatObj)); 
					    int value = time1.compareTo(time2);			        
				        if (!(value < 0 || value == 0)) {
				        	request.setAttribute("message","Session opens at "+d.date+" "+d.time);
							request.getRequestDispatcher("yourcourse.jsp").forward(request,response);
				        }				     
					}
					session.setAttribute("subject",subject);
					session.setAttribute("unique", "no");
					session.setAttribute("uniqueCode",d.uniqueCode);
					//request.setAttribute("subject",subject);
					//request.getRequestDispatcher("viewSession.jsp").forward(request,response);
					response.sendRedirect("viewSession.jsp");
				}
				else
				{
					request.setAttribute("message","Session opens at "+d.date+" "+d.time);
					request.getRequestDispatcher("yourcourse.jsp").forward(request,response);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
