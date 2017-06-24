package com.slokam.studentmgt.listener;

import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LogoutListener implements HttpSessionListener
{

	public void sessionCreated(HttpSessionEvent arg0) 
	{
		System.out.println("Session Start");
	}

	public void sessionDestroyed(HttpSessionEvent req) 
	{
		
		String name=(String)req.getSession().getAttribute("nameAttr");
		req.getSession().invalidate();
		
		List<String> userList=(List<String>) req.getSession().getServletContext().getAttribute("userList");
		boolean result=userList.remove(name);
		req.getSession().getServletContext().setAttribute("userList", userList);
		System.out.println(result);
		if(result)
		{
		Integer count=(Integer)req.getSession().getServletContext().getAttribute("count");
		count--;
		req.getSession().getServletContext().setAttribute("count", count);
		}
		
		System.out.println("Session end");
	}

}
