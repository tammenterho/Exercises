package com.mikko.vaestotieto.entities;

public class Person {
	private Long id;
	private String firstnames;
	private String lastNames;
	private String ssn;
	private String nationality;

	private Address address;
	private Parents parent1;
	private Parents parent2;
	private PersonMore personMore;
	private Permits permits;

	public Person(Long id, String firstnames, String lastNames, String ssn, String nationality, Address address,
			Parents parent1, Parents parent2, PersonMore personMore, Permits permits) {
		this.id = id; // 1
		this.firstnames = firstnames; // 2
		this.lastNames = lastNames; // 3
		this.ssn = ssn; // 4
		this.nationality = nationality; // 5

		this.address = address; // 6
		this.parent1 = parent1;
		this.parent2 = parent2;// 7
		this.personMore = personMore; // 8
		this.permits = permits; // 9

	}

	public Person() {
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

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
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

	public void setParents(Parents parent1, Parents parent2) {
		this.parent1 = parent1;
		this.parent2 = parent2;
	}

	public Parents getParent1() {
		return parent1;
	}
	
	public Parents getParent2() {
		return parent2;
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
}
