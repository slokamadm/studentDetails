package com.slokam.Servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.slokam.StudentDAO.StudentDAO;
import com.slokam.stumgt.pojo.StudentPojo;

public class DeleteServlet extends GenericServlet
{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String id=req.getParameter("Id");
		StudentPojo s=new StudentPojo();
		s.setId(Integer.parseInt(id));
		StudentDAO.deleteStudent(s);
		
		req.setAttribute("message", "Successfully Deleted");
		req.getRequestDispatcher("StudentSignup.jsp").forward(req, res);
		
	}
}
