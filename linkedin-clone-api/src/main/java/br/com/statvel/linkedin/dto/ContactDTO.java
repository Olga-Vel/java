package br.com.statvel.linkedin.dto;

import javax.xml.bind.annotation.XmlElement;


public class ContactDTO {
	private String firstName;
	private String lastName;
	private String email;
	

	public ContactDTO() {
	}
	@XmlElement(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if (!email.contains("@"))
			throw new IllegalArgumentException("Tem que ter arroba po!");
		this.email = email;
	}
	@XmlElement(name="lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@XmlElement(name="firstName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
