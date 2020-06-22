package com.login.dao;
import java.sql.*;

public class Dao {
	String url;
	String uname;
	String password;
	public String uniqueCode;
	public String date;
	public String time;
	public boolean python;
	public boolean java;
	Connection con;
	public Dao() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		this.url="jdbc:mysql://localhost:3306/san";
		this.uname="root";
		this.password="1234";
		this.con=DriverManager.getConnection(url,uname,password);
		python=false;
		java=false;
		uniqueCode="";
		date="";
		time="";
	}
	public boolean check(String name,String pass) throws Exception{
		String query="select * from login where username=? and pass=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,name);
		st.setString(2, pass);
		ResultSet rs=st.executeQuery();
		if (rs.next())
			return true;
		return false;
	}
	public void studentRegister(String name,String pass) throws Exception{
		String query="insert into login values(?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,name);
		st.setString(2, pass);
		int i=st.executeUpdate();
	}
	public boolean checkTeacher(String name,String pass) throws Exception{
		String query="select * from teacher where username=? and pass=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,name);
		st.setString(2, pass);
		ResultSet rs=st.executeQuery();
		if (rs.next())
			return true;
		return false;
	}
	public void addStudentsPython(String uname) throws Exception{
		String query="insert into python values(?)";
		//Connection con=DriverManager.getConnection(url,uname,password);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,uname);
		int i=st.executeUpdate();
	}
	public void addStudentsJava(String uname) throws Exception{
		String query="insert into java values(?)";
		//Connection con=DriverManager.getConnection(url,uname,password);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,uname);
		int i=st.executeUpdate();
	}
	public void addSession(String subject,String date,String time,String uc) throws Exception{
		String query="insert into session values(?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,subject);
		st.setString(2, date);
		st.setString(3, time);
		st.setString(4, uc);
		int i=st.executeUpdate();
	}
	public void yourCourse(String uname) throws Exception{
		String res="";
		
		String query="select * from java where username=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,uname);
		ResultSet rs=st.executeQuery();
		if (rs.next()){
			java=true;
		}
		query="select * from python where username=?";
		st=con.prepareStatement(query);
		st.setString(1,uname);
		rs=st.executeQuery();
		if (rs.next()){
			python=true;
		}
	}
	public void session(String subject) throws Exception{
		String query="select * from session where subject=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,subject);
		ResultSet rs=st.executeQuery();
		if (rs.next()){
			date=rs.getString("date");
			time=rs.getString("time");
			uniqueCode=rs.getString("uniquecode");
		}
	}
}
