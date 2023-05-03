package br.com.statvel.linkedin.bean;

public class ProfileBean extends ContactBean {
	private String jobTitle;
	private String organization;
	private String city;
	
	public ProfileBean(String firstName, String lastName, String email, String jobTitle, String organization, String city) {
		super(firstName, lastName, email);
		// TODO Auto-generated constructor stub
		this.jobTitle = jobTitle;
		this.organization = organization;
		this.city = city;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
