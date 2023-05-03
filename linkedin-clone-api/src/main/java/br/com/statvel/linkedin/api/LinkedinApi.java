package br.com.statvel.linkedin.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.statvel.linkedin.bean.ContactBean;
import br.com.statvel.linkedin.bean.ProfileBean;
import br.com.statvel.linkedin.dao.LinkedinDao;
import br.com.statvel.linkedin.dto.ContactDTO;
import br.com.statvel.linkedin.dto.ListContactDTO;
import br.com.statvel.linkedin.dto.ProfileDTO;

@Path("linkedin")
public class LinkedinApi {
    
    @POST
    @Path("authenticate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response autenticate(){
        System.out.println("Method authenticate called.");
        LinkedinDao dao = new LinkedinDao();
        //TODO:
        return Response.ok().build();
    }
    @GET
    @Path("contacts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listContacts(@QueryParam("email") String email){
        System.out.println("Method listContacts called.");
        LinkedinDao dao = new LinkedinDao();
        ContactBean c = dao.getContact(email);
        ContactDTO cd = null;
        ListContactDTO lista = new ListContactDTO();
        for (ContactBean subContact : c.getContacts()){
            cd = new ContactDTO();
            cd.setEmail(subContact.getEmail());
            cd.setFirstName(subContact.getFirstName());
            cd.setLastName(subContact.getLastName());
            lista.getLista().add(cd);
        }
        
        return Response.ok(lista).build();
    }
    @GET
    @Path("profile")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfile(@QueryParam("email") String email){
        System.out.println("Method getProfile called.");
        LinkedinDao dao = new LinkedinDao();
        ProfileBean p = dao.getProfile(email);
        ProfileDTO pd = new ProfileDTO();
        pd.setCity(p.getCity());
        pd.setEmail(p.getEmail());
        pd.setFirstName(p.getFirstName());
        pd.setJobTitle(p.getJobTitle());
        pd.setLastName(p.getLastName());
        pd.setOrganization(p.getOrganization());
        return Response.ok(pd).build();
    }

}
