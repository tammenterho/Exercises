package com.mikko.vaestotieto.entities;




public class Person {
	private Long id;
	private String firstnames;
	private String lastname;
	private String ssn; 
	private String nationality; 

	private Address address;
	private Parents parents;
	private PersonMore personMore;
	private Permits permits;

	
	public Person (Long id, String firstnames, String lastname, String ssn, String nationality, Address address, Parents parents, PersonMore personMore, Permits permits) {
		this.id = id; //1
		this.firstnames = firstnames; //2
		this.lastname = lastname; //3
		this.ssn = ssn; //4
		this.nationality = nationality; //5

		this.address = address; //6
		this.parents = parents; //8
		this.personMore = personMore; //9
		this.permits = permits;
		
		
		
	}
	public Person () {
	} 
	

	public void setPersonMore(PersonMore personMore) {
		this.personMore = personMore;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstnames() {
		return firstnames;
	}
	public void setFirstnames(String firstnames) {
		this.firstnames = firstnames;
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
	
	public Permits getPermits() {
		return permits;
	}
	public void setPermits(Permits permits) {
		this.permits = permits;
	}
	

}
