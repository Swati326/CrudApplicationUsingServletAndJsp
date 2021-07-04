package org.techhub.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.techhub.model.Student;

public class StudentRepositoryImpl implements StudentRepository {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private List<Student> studList;

	public StudentRepositoryImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "swati");
		} catch (Exception ex) {
			System.out.println("error is" + ex);
		}
	}

	@Override
	public boolean isAddnewStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			stmt = conn.prepareStatement("insert into student values('0',?,?,?)");
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getEmail());
			stmt.setString(3, student.getContact());
			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("error is +ex");
			return false;
		}

	}

	@Override
	public List<Student> getAllStudentRecords() {
		// TODO Auto-generated method stub
		try {
			studList=new ArrayList<Student>();
			stmt = conn.prepareStatement("select *from student");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Student student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setContact(rs.getString(4));
				studList.add(student);
			}

		} catch (Exception ex) {
			System.out.println("error is" + ex);
		}
		return studList;
	}

	@Override
	public boolean isDeletedRecord(int id) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("delete from student where id=?");
			stmt.setInt(1,id);
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("error is" +ex);
			return false;
		}
		
	}

	public boolean isUpdateRecord(String name,String email,String contact,int id) {
		// TODO Auto-generated method stub
		try {
		stmt=conn.prepareStatement("update student set name=?,email=?,contact=? where id=?");
		stmt.setString(1,name);
		stmt.setString(2,email);
		stmt.setString(3,contact);
		stmt.setInt(4, id);
		int value=stmt.executeUpdate();
		if(value>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	catch(Exception ex)
	{
		System.out.println("error is" +ex);
		return false;
	}
	
	}


}
