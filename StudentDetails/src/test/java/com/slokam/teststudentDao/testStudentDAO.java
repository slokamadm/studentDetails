package com.slokam.teststudentDao;

import org.junit.Assert;
import org.junit.Test;

import com.slokam.StudentDAO.StudentDAO;

public class testStudentDAO 
{
	
	@Test
	public void testLogin()
	{
		String name="syam";
		String pwd="123";
		
		boolean actual=StudentDAO.validateUser(name, pwd);
		
		Assert.assertTrue(actual);
	}
	
	
}
