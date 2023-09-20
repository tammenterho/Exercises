package com.mikko.vaestotieto.entities;

import java.sql.Date;

public class Person {
	private Long id;
	private String firstname;
	private String lastname;
	private Date birth;
	private Date death;
	private int age;
	private String sex;
	private String nationality;
	private String language;
	private String ssn;
	
	public Person (Long id, String firstname, String lastname, Date birth, Date death, int age, String sex, String nationality, String language, String marital, String ssn) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birth = birth;
		this.death = death;
		this.age = age;
		this.sex = sex;
		this.nationality = nationality;
		this.language = language;
		this.ssn = ssn;
		
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
	

}
