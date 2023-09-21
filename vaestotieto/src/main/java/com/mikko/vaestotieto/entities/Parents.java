package com.mikko.vaestotieto.entities;

import java.util.Date;

public class Parents {
	private String parentsFirstName;
	private String parentsLastName;
	private Date parentsBirth;
	
	
	public Parents(String parentsFirstName, String parentsLastName, Date parentsBirth) {
		
		this.parentsFirstName = parentsFirstName;
		this.parentsLastName = parentsLastName;
		this.parentsBirth = parentsBirth;
	}


	public String getParentsFirstName() {
		return parentsFirstName;
	}


	public void setParentsFirstName(String parentsFirstName) {
		this.parentsFirstName = parentsFirstName;
	}


	public String getParentsLastName() {
		return parentsLastName;
	}


	public void setParentsLastName(String parentsLastName) {
		this.parentsLastName = parentsLastName;
	}


	public Date getParentsBirth() {
		return parentsBirth;
	}


	public void setParentsBirth(Date parentsBirth) {
		this.parentsBirth = parentsBirth;
	}
	
}
