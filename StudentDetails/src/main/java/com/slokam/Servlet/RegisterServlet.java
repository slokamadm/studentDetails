package com.slokam.Servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.slokam.StudentDAO.StudentDAO;
import com.slokam.stumgt.pojo.StudentPojo;

public class RegisterServlet extends GenericServlet
{
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String ID=req.getParameter("Id");
		String Name=req.getParameter("Name");
		String Qual=req.getParameter("Qualification");
		String Age=req.getParameter("Age");
		String Phonenumber=req.getParameter("Phonenumber");
		Integer intId;
		
		
		try
		{
			intId=Integer.parseInt(ID);
			
		}
		catch (NumberFormatException e) {
			intId=0;
		}
		StudentPojo student=new StudentPojo();
		student.setId(intId);
		student.setName(Name);
		student.setQual(Qual);
		student.setAge(Integer.parseInt(Age));
		student.setPhone(Double.parseDouble(Phonenumber));
		
		if(intId>0)
		{
			req.setAttribute("message", "Successfully Updated");
			StudentDAO.updateUser(student);
		}
		else
		{
			req.setAttribute("message", "Successfully Registered");
			StudentDAO.signupUser(student);
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("StudentSignup.jsp");
		rd.forward(req, res);
		
		
	}

}
