package com.slokam.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.slokam.StudentDAO.StudentDAO;


public class LoginServlet extends HttpServlet
{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		 
		boolean result=StudentDAO.validateUser(username, password);
		
		if(result)
		{
			HttpSession session= req.getSession();
			session.setAttribute("nameAttr", username);
			
			
			
			List<String> userList=(List<String>)getServletContext().getAttribute("userList");
			
			if(userList==null)
			{
				userList=new ArrayList<String>();
			}
			
			
			
				if(userList.contains(username))
				{
					req.setAttribute("message", "User already logged in other location");
					req.getRequestDispatcher("login.jsp").forward(req, res);
				}
				else
				{
					Integer count=(Integer)getServletContext().getAttribute("count");
					if(count==null)
					{
						count=0;
					}
					count++;
					getServletContext().setAttribute("count", count);
					
					userList.add(username);
					getServletContext().setAttribute("userList",userList);
					req.getRequestDispatcher("StudentSignup.jsp").forward(req, res);
				}
				
				
			
		}
		else
		{
			req.setAttribute("message", "Please provide correct Username/Password");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
	}
}
