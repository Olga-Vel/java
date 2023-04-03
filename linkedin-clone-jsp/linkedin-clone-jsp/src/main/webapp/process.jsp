<%@ page import="br.com.statvel.linkedin.dao.LinkedinDao" %>
<%@ page import="br.com.statvel.linkedin.bean.ContactBean" %>
<%

		//HttpSession session = request.getSession();
		String email = request.getParameter("email");
		
		LinkedinDao dao = new LinkedinDao();
		ContactBean currentUser = dao.getContact(email);
		if (currentUser == null) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
		session.setAttribute("currentUser", currentUser);  
		response.sendRedirect(request.getContextPath() + "/contacts.jsp");
%>
