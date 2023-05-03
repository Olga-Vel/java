<html>

<head>

</head>

<body>
    <%@ page import="br.com.statvel.linkedin.bean.ContactBean" %>
        <%@ page import="java.io.PrintWriter" %>
            <% 
            PrintWriter res=response.getWriter(); 
            res.append("Welcome: ").append(" <br />");
            res.append("You are: ");
            ContactBean currentUser = (ContactBean) session.getAttribute("currentUser");

            res.append(currentUser.getFirstName()+ " " + currentUser.getLastName());
            res.append("<br />");
            res.append("<a href=\"profile?email="+currentUser.getEmail()+" \">Go to My Profile</a>");
            res.append("<ul>");
            for (ContactBean c : currentUser.getContacts()) {
                res.append("<li><a href=\"profile?email="+c.getEmail()+" \">"+c.getFirstName()+" "+c.getLastName()+"</a></li>");
            }
            res.append("</ul>").append("<br />");
            res.append("Served from VS Code.").append("<br />");
            res.append("Served automatically.").append("<br />");
            %>


</body>

</html>