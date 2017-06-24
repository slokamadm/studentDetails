package com.slokam.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String name=(String)req.getSession().getAttribute("nameAttr");
		req.getSession().invalidate();
		
		List<String> userList=(List<String>) getServletContext().getAttribute("userList");
		userList.remove(name);
		getServletContext().setAttribute("userList", userList);
		Integer count=(Integer)getServletContext().getAttribute("count");
		count--;
		getServletContext().setAttribute("count", count);
		
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}
}
