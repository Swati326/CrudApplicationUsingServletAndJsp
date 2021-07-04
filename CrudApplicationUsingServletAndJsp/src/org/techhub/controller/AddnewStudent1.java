package org.techhub.controller;

import java.io.IOException;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.model.Student;
import org.techhub.service.StudentServiceImp;

/**
 * Servlet implementation class AddnewStudent1
 */
@WebServlet("/addnewstudent")
public class AddnewStudent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddnewStudent1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("administer.html");
		r.include(request,response);
		
		out.println("<br>");
		out.println("<form name='frm' action='' mathod='GET'>");
		out.println("<div class='container mt-5'>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='text' name='name' value='' placeholder='Enter name' class='form-control'/>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='text'name='email' value='' placeholder='Enter email' class='form-control'/>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<input type='text'name='contact' value='' placeholder='Enter contact' class='form-control'/>");	
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='submit' name='s' value='Add New Student' class='form-control'/>");			
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			Student student=new Student();
			student.setName(name);
			student.setEmail(email);
			student.setContact(contact);
			StudentServiceImp studservice=new StudentServiceImp();
			boolean b=studservice.isAddnewStudent(student);
			if(b)
			{
				out.println("<center><span class='btn btn-success'>Record save Successfully</span></center>");
			}
			else
			{
				out.println("<center><span class='btn btn-success'>Record Failed</span></center>");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
