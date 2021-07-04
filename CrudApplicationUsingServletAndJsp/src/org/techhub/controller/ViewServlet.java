package org.techhub.controller;

import java.io.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.techhub.model.Student;
import org.techhub.service.StudentService;
import org.techhub.service.StudentServiceImp;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/View")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("administer.html");
		r.include(request, response);
		StudentService studService = new StudentServiceImp();
		List<Student> studList = studService.getAllStudentRecords();
		out.println("<div class='container'><table class='table mt-5'>");
		out.println(
				"<tr><th scope='col'>NAME</th><th scope='col'>EMAIL</th><th scope='col'>CONTACT</th><th scope='col'>UPDATE</th><th scope='col'>DELETE</th></tr>");
		for (Student student : studList) {
			int id = student.getId();
			String name = student.getName();
			String email = student.getEmail();
			String contact = student.getContact();
			
			out.println("<tr scope='col'>");
			out.println("<td>" + name + "</td>");
			out.println("<td>" + email + "</td>");
			out.println("<td>" + contact + "</td>");
			
			out.println("<td><a href='update?id="+id+"&name="+name+"&email="+email+"&contact="+contact+"'>UPDATE</a></td>");
			out.println("<td><a href='del?Studentid="+id+"'>DELETE</a></td>");
			out.println("</tr>");
		}
		out.println("</table></div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
