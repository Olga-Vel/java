package br.com.statvel.linkedin.controller;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.statvel.linkedin.bean.ContactBean;

//@ApplicationScoped
//@SessionScoped
//@ConversationScoped
//@RequestScoped
//@Named
@SessionScoped
public class UsuarioSessionController implements Serializable{
    private ContactBean contact;


    // "Equivalent" to doGet
    @PostConstruct
    public void init(){
        System.out.println("SessionScoped instantiated!");
    }
    
    // Getters and setters - doesn't matter

    public ContactBean getContact() {
        return contact;
    }

    public void setContact(ContactBean contact) {
        this.contact = contact;
    }
    
}