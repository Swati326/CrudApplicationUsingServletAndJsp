package org.techhub.controller;
import java.io.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.service.StudentService;
import org.techhub.service.StudentServiceImp;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String id=request.getParameter("id");
		StudentService studService=new StudentServiceImp();
		boolean b=studService.isUpdateRecord(name,email,contact,(Integer.parseInt(id)));
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("administer.html");
			r.include(request, response);
		}
		else
		{
			out.println("some problem is there");
		}
		
		
		out.println("<form name='frm' action='' mathod='GET'>");
		out.println("<div class='container mt-5'>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='text' name='name' value='"+name+"' placeholder='Enter name' class='form-control'/>");
		out.println("</div>");
		
		
		out.println("<div class='form-group'>");
		out.println("<input type='text'name='email' value='"+email+"' placeholder='Enter email' class='form-control'/>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<input type='text'name='contact' value='"+contact+"'placeholder='Enter contact' class='form-control'/>");	
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='hidden' name='id' value='"+id+"' Placeholder='Enter your id' class='form-control'/>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='submit' name='s' value='Update Student Record' class='form-control'/>");			
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
