package br.com.statvel.linkedin.controller;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.statvel.linkedin.bean.ContactBean;

//@ApplicationScoped
//@SessionScoped
//@ConversationScoped
//@RequestScoped
@Named
@RequestScoped
public class ContactsController implements Serializable{
    private ContactBean contact;
    @Inject
    UsuarioSessionController session;
    // "Equivalent" to doGet
    @PostConstruct
    public void init(){
        contact = session.getContact();
    }
    // Getters and setters - doesn't matter
    public void setContact(ContactBean contact) {
        this.contact = contact;
    }
    public ContactBean getContact() {
        return contact;
    }
    
}