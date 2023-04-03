package br.com.statvel.linkedin.bean;

import java.util.ArrayList;
import java.util.List;

public class ContactBean {
	private String firstName;
	private String lastName;
	private String email;
	private List <ContactBean> contacts;
	

	public ContactBean(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contacts = new ArrayList <ContactBean>();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (!email.contains("@"))
			throw new IllegalArgumentException("Tem que ter arroba po!");
		this.email = email;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List <ContactBean> getContacts() {
		return contacts;
	}
	public void setContacts(List <ContactBean> contacts) {
		this.contacts = contacts;
	}

}
