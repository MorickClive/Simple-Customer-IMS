package com.qa.ims;

public class CustomerDTO {
	private Integer id;
	private String forename;
	private String surname;

	public CustomerDTO(String forename, String surname) {
		super();
		this.forename = forename;
		this.surname = surname;
	}

	public CustomerDTO(Integer id, String forename, String surname) {
		super();
		this.id = id;
		this.forename = forename;
		this.surname = surname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + (id != null ? id : 0) + ", forename=" + forename + ", surname=" + surname + "]";
	}
	
}
