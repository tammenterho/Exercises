package com.mikko.vaestotieto.entities;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {
	private Long id;
	private String firstnames;
	private String lastname;
	private String ssn; 
	private String nationality; 

	private Address address;
	private Contact contact;
	private Parents parents;
	private PersonMore personMore;

	
	public Person (Long id, String firstnames, String lastname, String ssn, String nationality, Address address, Contact contact, Parents parents, PersonMore personMore) {
		this.id = id; //1
		this.firstnames = firstnames; //2
		this.lastname = lastname; //3
		this.ssn = ssn; //4
		this.nationality = nationality; //5

		this.address = address; //6
		this.contact = contact; //7
		this.parents = parents; //8
		this.personMore = personMore; //9
		
		
	}
	public Person () {
	} 
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstnames;
	}

	public void setFirstname(String firstname) {
		this.firstnames = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getNationality() {
		return nationality;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Parents getParents() {
		return parents;
	}
	public void setParents(Parents parents) {
		this.parents = parents;
	}
	public PersonMore getPersonMore() {
		return personMore;
	}
	public void setPersonInfo(PersonMore personMore) {
		this.personMore = personMore;
	}
	
	

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}
