package br.com.statvel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter res = response.getWriter();
		res.append("Served at: ").append(request.getContextPath());
		res.append("\nYou called the GET method.");
		res.append(request.getHeader("Connection"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter res = response.getWriter();
		res.append("Served at: ").append(request.getContextPath());
		res.append("\nYou called the POST method.");
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter res = response.getWriter();
		res.append("Served at: ").append(request.getContextPath());
		res.append("\nYou called the PUT method.");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter res = response.getWriter();
		res.append("Served at: ").append(request.getContextPath());
		res.append("\nYou called the DELETE method.");
	}

}
