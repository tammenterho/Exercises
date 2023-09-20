package com.mikko.vaestotieto.entities;

public class PersonInfo {
	private String sex;
	private String nationality; 
	private String language; 
	private String ssn; 

	public PersonInfo (String sex, String nationality, String language, String marital, String ssn) {
		this.sex = sex;
		this.nationality = nationality;
		this.language = language;
		this.ssn = ssn;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}
