package com.mikko.vaestotieto.entities;

public class Relatives {
	private String iCAContactName;
	private String iCAContactNumber;
	private String iCAContactEmail;
	
	public Relatives (String iCAContactName, String iCAContactNumber, String iCAContactEmail) {
		this.iCAContactName = iCAContactName;
		this.iCAContactNumber = iCAContactNumber;
		this.iCAContactEmail = iCAContactEmail;
	}

	public String getiCAContactName() {
		return iCAContactName;
	}

	public void setiCAContactName(String iCAContactName) {
		this.iCAContactName = iCAContactName;
	}

	public String getiCAContactNumber() {
		return iCAContactNumber;
	}

	public void setiCAContactNumber(String iCAContactNumber) {
		this.iCAContactNumber = iCAContactNumber;
	}

	public String getiCAContactEmail() {
		return iCAContactEmail;
	}

	public void setiCAContactEmail(String iCAContactEmail) {
		this.iCAContactEmail = iCAContactEmail;
	}
	
}
