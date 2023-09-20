package com.mikko.vaestotieto.entities;

import java.sql.Date;

public class Person {
	private Long id;
	private String firstname;
	private String lastname;
	private Date birth;
	private Date death;
	private String sex;
	private String nationality;
	private String language;
	private String marital;
	private String ssn;
	
	public Person (Long id, String firstname, String lastname, Date birth, Date death, String sex, String nationality, String language, String marital, String ssn) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birth = birth;
		this.death = death;
		this.sex = sex;
		this.nationality = nationality;
		this.language = language;
		this.marital = marital;
		this.ssn = ssn;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getDeath() {
		return death;
	}

	public void setDeath(Date death) {
		this.death = death;
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

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}
