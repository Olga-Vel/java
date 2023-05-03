package br.com.statvel.linkedin.controller;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.statvel.linkedin.bean.ContactBean;
import br.com.statvel.linkedin.bean.ProfileBean;
import br.com.statvel.linkedin.dao.LinkedinDao;

@RequestScoped
@Named
public class ProfileController {
    @Inject
    UsuarioSessionController session;
    private ProfileBean profile;
    private ContactBean contact;
    @PostConstruct
    public void init(){
        contact = session.getContact();
        LinkedinDao dao = new LinkedinDao();
		String email = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("email");
        profile = dao.getProfile(email);
    }
    public ProfileBean getProfile() {
        return profile;
    }
    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }
    public ContactBean getContact() {
        return contact;
    }
    public void setContact(ContactBean contact) {
        this.contact = contact;
    }

    
}
