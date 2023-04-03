package br.com.statvel.linkedin.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.statvel.linkedin.bean.ContactBean;
import br.com.statvel.linkedin.dao.LinkedinDao;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter res = response.getWriter();
		String text = readUsingScanner("myservlet");
		res.append(text);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		
		LinkedinDao dao = new LinkedinDao();
		ContactBean currentUser = dao.getContact(email);
		if (currentUser == null) {
			response.sendRedirect(request.getContextPath() + "/error");
		}
		session.setAttribute("currentUser", currentUser);  
		response.sendRedirect(request.getContextPath() + "/contacts");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter res = response.getWriter();
		res.append("Served at: ").append(request.getContextPath());
		res.append("\nYou called the PUT method.");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter res = response.getWriter();
		res.append("Served at: ").append(request.getContextPath());
		res.append("\nYou called the DELETE method.");
	}


	private String readUsingScanner(String fileName) throws IOException {
		InputStream fis = MyServlet.class.getClassLoader().getResourceAsStream(fileName);
		byte[] buffer = new byte[10];
		StringBuilder sb = new StringBuilder();
		while (fis.read(buffer) != -1) {
			sb.append(new String(buffer));
			buffer = new byte[10];
		}
		fis.close();

		String content = sb.toString();
		return content;
	}
}
