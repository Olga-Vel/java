package br.com.statvel.linkedin.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.statvel.linkedin.bean.ContactBean;
import br.com.statvel.linkedin.dao.LinkedinDao;

//@ApplicationScoped
//@SessionScoped
//@ConversationScoped
//@RequestScoped
@Named
@RequestScoped
public class IndexController implements Serializable {
    private String message;
    private String email;
    private String password;
    @Inject
    UsuarioSessionController session;

    // "Equivalent" to doGet
    @PostConstruct
    public void init() {
        //beginConversation();
        message = "Hello World from JSF Controller!";
        System.out.println("RequestScoped instantiated!");
    }

    // "Equivalent" to doPost
    public String submit() {
        System.out.println("Submit called!");
        System.out.println(email);
        //session.setEmail(email);
        LinkedinDao dao = new LinkedinDao();
        ContactBean contact = dao.getContact(email);
        if (contact == null){
            return "error.xhtml?faces-redirect=true";
        }
        session.setContact(contact);
        //endConversation();
        return "contacts.xhtml?faces-redirect=true";
    }

    // Getters and setters - doesn't matter
    /*
    public void beginConversation() {
        if (conversation.isTransient()) {
            conversation.setTimeout(1800000L);
            conversation.begin();
        }
    }

    public void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }
    */
    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}