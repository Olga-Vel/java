package br.com.statvel.linkedin.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.statvel.linkedin.bean.ContactBean;


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
		
		//session.setAttribute("pass",request.getParameter("pass")); 
		List<ContactBean> contactList = Arrays.asList(new ContactBean("Joao", "da Silva", "joao@gmail.com"),
				new ContactBean("Ivan", "Ivanovich", "ivan@gmail.com"),
				new ContactBean("Jane", "Smith", "jane@gmail.com"));
		List<ContactBean> currentUserContacts = Arrays.asList(new ContactBean("Joao", "da Silva", "joao@gmail.com"),
				new ContactBean("Ivan", "Ivanovich", "ivan@gmail.com"),
				new ContactBean("Jane", "Smith", "jane@gmail.com"));
		ContactBean currentUser = null;
		for (ContactBean c : contactList) {
			if (email.equals(c.getEmail())) {
				currentUser = c;
				break;
			}
		}
		if (currentUser == null) {
			response.sendRedirect(request.getContextPath() + "/error");
		}
		currentUser.setContacts(currentUserContacts);
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
