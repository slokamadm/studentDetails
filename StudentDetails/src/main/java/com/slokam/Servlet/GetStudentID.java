package com.slokam.Servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.slokam.StudentDAO.StudentDAO;
import com.slokam.stumgt.pojo.StudentPojo;

public class GetStudentID extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String id=req.getParameter("id");
		StudentPojo student=StudentDAO.getData(Integer.parseInt(id));
		req.setAttribute("StudentAtt", student);
		req.getRequestDispatcher("StudentSignup.jsp").forward(req, res);
		
		
	}
	
}
