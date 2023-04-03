package br.com.statvel.linkedin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.statvel.linkedin.bean.ContactBean;

/**
 * Servlet implementation class TableServlet
 */
public class ContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		

		PrintWriter res = response.getWriter();
		res.append("<html>");
		res.append("<head>");
		res.append("</head>");
		res.append("<body>").append("<br/>");
		res.append("Served at: ").append(request.getContextPath()).append("<br/>");
		res.append("Welcome: ").append("<br/>");
		HttpSession session = request.getSession(false);
		res.append("You are: ");
		ContactBean currentUser = (ContactBean) session.getAttribute("currentUser");
		
		res.append(currentUser.getFirstName()+ " " + currentUser.getLastName());
		session.setAttribute("currentUser", currentUser);
		res.append("<br/>");
		res.append("<a href=\"profile?email="+currentUser.getEmail()+"\">Go to My Profile</a>");
		res.append("<ul>");
		for (ContactBean c : currentUser.getContacts()) {
			res.append("<li><a href =\"profile?email="+c.getEmail()+"\">"+c.getFirstName()+" "+c.getLastName()+"</a></li>");
		}
		res.append("</ul>").append("<br/>");
		res.append("Served from VS Code.").append("<br/>");
		res.append("Served automatically.").append("<br/>");
		res.append("</body>");
		res.append("</html>");

	}

}
