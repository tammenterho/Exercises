package com.mikko.vaestotieto.entities;



public class Person {
	private Long id;
	private String firstnames;
	private String lastNames;
	private String ssn; 
	private String nationality; 

	private Address address;
	private Parents parents;
	private PersonMore personMore;
	private Permits permits;

	
	public Person (Long id, String firstnames, String lastNames, String ssn, String nationality, Address address, Parents parents, PersonMore personMore, Permits permits) {
		this.id = id; //1
		this.firstnames = firstnames; //2
		this.lastNames = lastNames; //3
		this.ssn = ssn; //4
		this.nationality = nationality; //5

		this.address = address; //6
		this.parents = parents; //7
		this.personMore = personMore; //8
		this.permits = permits; //9
		
		
		
	}
	
	
	public Person () {
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


	public String getLastnames() {
		return lastNames;
	}

	public void setLastnames(String lastname) {
		this.lastNames = lastname;
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
	public void setPersonMore(PersonMore personMore) {
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
	public void setParents(Parents parent2, Parents parent1) {
		
		
	}
	

}
