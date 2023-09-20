package com.mikko.vaestotieto.entities;

import java.sql.Date;

public class Person {
	private Long id;
	private String firstname;
	private String lastname;
	private Date birth;
	private Date death;
	private int age;
	private Address address;
	private Contact contact;
	private Relatives relatives;
	private PersonInfo personInfo;

	
	public Person (Long id, String firstname, String lastname, Date birth, Date death, int age, Address address, Contact contact, Relatives relatives, PersonInfo personInfo) {
		this.id = id; //1
		this.firstname = firstname; //2
		this.lastname = lastname; //3
		this.birth = birth; //4
		this.death = death; //5
		this.age = age; //6
		this.address = address; //7
		this.contact = contact; //8
		this.relatives = relatives; //9
		this.personInfo = personInfo; //10
		
		
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
	
	  public boolean isValid() {
	        if (birth != null && death != null) {
	            return birth.before(death);
	        }
	        return false; 
	    }

	
	public int calculateAge() {
		if (birth == null || death == null) {
            return 0;
		
	} 
		long birthTime = birth.getTime();
		long deathTime = death.getTime();
		long ageInMillis = deathTime - birthTime;
		
		 double ageInYears = ageInMillis / (365.25 * 24 * 60 * 60 * 1000);

	        int age = (int) Math.floor(ageInYears);
	        
	        return age;
	}
	
	public int getAge() {
        return calculateAge();
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
	public Relatives getRelatives() {
		return relatives;
	}
	public void setRelatives(Relatives relatives) {
		this.relatives = relatives;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
