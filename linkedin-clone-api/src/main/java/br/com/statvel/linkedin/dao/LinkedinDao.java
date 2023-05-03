package br.com.statvel.linkedin.dao;

import java.util.Arrays;
import java.util.List;

import br.com.statvel.linkedin.bean.ContactBean;
import br.com.statvel.linkedin.bean.ProfileBean;

public class LinkedinDao {
	
	public List<ContactBean> getAllContacts(){
		return Arrays.asList(new ContactBean("Joao", "da Silva", "joao@gmail.com"),
				new ContactBean("Ivan", "Ivanovich", "ivan@gmail.com"),
				new ContactBean("Jane", "Smith", "jane@gmail.com"));
	}
	public ContactBean getContact(String email){
		List<ContactBean> randomContacts = Arrays.asList(new ContactBean("Joao", "da Silva", "joao@gmail.com"),
				new ContactBean("Ivan", "Ivanovich", "ivan@gmail.com"),
				new ContactBean("Jane", "Smith", "jane@gmail.com"));
		ContactBean contact = null;
		for (ContactBean c : getAllContacts()) {
			if (email.equals(c.getEmail())) {
				contact = c;
				break;
			}
		}
		if (contact != null)
			contact.setContacts(randomContacts);
		return contact;
	}
	
	public List<ProfileBean> getAllProfiles(){
		return Arrays.asList(
				new ProfileBean("Joao", "da Silva", "joao@gmail.com", "Pedreiro", "Big Construjá", "Cocalzinho de Goias"),
				new ProfileBean("Ivan", "Ivanovich", "ivan@gmail.com", "Engenheiro Aeronautico", "Sukhoi", "Irkutsk"),
				new ProfileBean("Jane", "Smith", "jane@gmail.com", "Agente de inteligencia", "Abin", "Brasilia"));
		
	}
	public ProfileBean getProfile(String email){
		ProfileBean currentUser = null;
		for (ProfileBean c : getAllProfiles()) {
			if (email.equals(c.getEmail())) {
				currentUser = c;
				break;
			}
		}
		return currentUser;
	}
}
