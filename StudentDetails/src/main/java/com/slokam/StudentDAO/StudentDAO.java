package com.slokam.StudentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.slokam.stumgt.pojo.StudentPojo;

public class StudentDAO 
{
	static Connection con=null;

		static
		{
			
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/F15","root","root");
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void signupUser(StudentPojo s)
		{
			try {
				
				PreparedStatement ps=con.prepareStatement("insert into student(Name,Age,Number,Qualification) values(?,?,?,?)");
				ps.setString(1, s.getName());
				ps.setInt(2, s.getAge());
				ps.setDouble(3, s.getPhone());
				ps.setString(4, s.getQual());
				ps.executeUpdate();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static StudentPojo getData(int id)
		{
			
			StudentPojo student=null;
			try {
				PreparedStatement ps=con.prepareStatement("select * from student where Id=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				student=new StudentPojo();
				
				if(rs.next())
				{
					
					student.setId(rs.getInt("Id"));
					student.setName(rs.getString("Name"));
					student.setAge(rs.getInt("Age"));
					student.setQual(rs.getString("Qualification"));
					student.setPhone(rs.getDouble("Number"));
					
				}
				
			}  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return student;
			
		}
		
		public static List<StudentPojo> getAll()
		{
			
			StudentPojo student=null;
			List<StudentPojo> students=new ArrayList<StudentPojo>();
			
			try {
				
				PreparedStatement ps=con.prepareStatement("select * from student");
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					student=new StudentPojo();
					student.setId(rs.getInt("Id"));
					student.setName(rs.getString("Name"));
					student.setAge(rs.getInt("Age"));
					student.setQual(rs.getString("Qualification"));
					student.setPhone(rs.getDouble("Number"));
					
					students.add(student);
					
				}
				
			}  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return students;
			
		}
		public static void updateUser(StudentPojo s) 
		{
			try {
				
				PreparedStatement ps=con.prepareStatement("update student s set s.Name=?,s.Age=?,s.Number=?,s.Qualification=? where s.Id=?");
				ps.setString(1, s.getName());
				ps.setInt(2, s.getAge());
				ps.setDouble(3, s.getPhone());
				ps.setString(4, s.getQual());
				ps.setInt(5, s.getId());
				ps.executeUpdate();
			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public static void deleteStudent(StudentPojo s) 
		{
			StudentPojo student=null;
			try {
				
				PreparedStatement ps=con.prepareStatement("delete from student where Id=?");
				ps.setInt(1, s.getId());
				ps.executeUpdate();
				
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	/* ***********************LOGIN**************************** */

		public static boolean validateUser(String username, String password) 
		{
			
			boolean result=false;
			 
			try {
				
				PreparedStatement ps=con.prepareStatement("select * from login where Username=? and Password=?");
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					result=true;
				}
				 
				
				
			}  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
}


