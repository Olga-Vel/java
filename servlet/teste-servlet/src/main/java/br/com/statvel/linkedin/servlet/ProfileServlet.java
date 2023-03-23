package br.com.statvel.linkedin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.statvel.linkedin.bean.ContactBean;
import br.com.statvel.linkedin.bean.ProfileBean;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter res = response.getWriter();
		res.append("<html>");
		res.append("<head>");
		res.append("</head>");
		res.append("<body>").append("<br/>");
		res.append("Served at: ").append(request.getContextPath()).append("<br/>");
		res.append("Welcome: ").append("<br/>");
		HttpSession session=request.getSession(false); 
		ContactBean currentUser = (ContactBean)session.getAttribute("currentUser");
		res.append("You are: ")
		.append(currentUser.getFirstName()).append(" ")
		.append(currentUser.getLastName()).append("<br/>");
		List <ProfileBean> profileList = Arrays.asList(
				new ProfileBean("Joao", "da Silva", "joao@gmail.com", "Pedreiro", "Big Construjá", "Cocalzinho de Goias"),
				new ProfileBean("Ivan", "Ivanovich", "ivan@gmail.com", "Engenheiro Aeronautico", "Sukhoi", "Irkutsk"),
				new ProfileBean("Jane", "Smith", "jane@gmail.com", "Agente de inteligencia", "Abin", "Brasilia"));
		String email = request.getParameter("email");
		ProfileBean currentProfile = null;
		for (ProfileBean p : profileList) {
			if (email.equals(p.getEmail())) {
				currentProfile = p;
				break;
			}
		}
		if (currentProfile == null) {
			response.sendRedirect(request.getContextPath() + "/error");
		}
		res.append(currentProfile.getFirstName()).append(" ");
		res.append(currentProfile.getLastName()).append("<br/>");
		res.append(currentProfile.getJobTitle()).append("<br/>"); 
		res.append(currentProfile.getOrganization()).append("<br/>");
		res.append(currentProfile.getCity()).append("<br/>");
		res.append("</body>");
		res.append("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
