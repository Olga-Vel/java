package br.com.statvel.linkedin.dto;

import javax.xml.bind.annotation.XmlElement;

public class ProfileDTO extends ContactDTO {
	private String jobTitle;
	private String organization;
	private String city;
	
	public ProfileDTO() {
	}
	@XmlElement(name="jobTitle")
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@XmlElement(name="organization")
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@XmlElement(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
