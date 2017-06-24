package com.slokam.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.slokam.StudentDAO.StudentDAO;
import com.slokam.stumgt.pojo.StudentPojo;

public class GetAllServlet extends GenericServlet
{
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		List<StudentPojo> student=StudentDAO.getAll();
		req.setAttribute("students", student);
		req.getRequestDispatcher("OutputGetAll.jsp").forward(req, res);
		
		
	}

}
