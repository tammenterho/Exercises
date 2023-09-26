package com.mikko.vaestotieto.entities;

import java.util.Date;



public class Address {
	private String localAddress; //streetname and number
	private String postal; // postal code and city
	private Date movingIn; // a date when moved in to current
	private int residents; // number of residents
	private String municipality;
	private Date movingInMunicipality; // a date when moved in to current municipality. tax related
	private String turnYearMunicipality; // turn of the year municipality decides tax municipality
	private String email;
	private String phone;
	


	public Address(String localAddress, String postal, Date movingIn, int residents, String municipality,
			Date movingInMunicipality, String turnYearMunicipality, String email, String phone) {
		
		
		this.localAddress = localAddress;
		this.postal = postal;
		this.movingIn = movingIn;
		this.residents = residents;
		this.municipality = municipality;
		this.movingInMunicipality = movingInMunicipality;
		this.turnYearMunicipality = turnYearMunicipality;
		this.email = email;
		this.phone = phone;
	}



	public String getLocalAddress() {
		return localAddress;
	}



	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}



	public String getPostal() {
		return postal;
	}



	public void setPostal(String postal) {
		this.postal = postal;
	}



	public Date getMovingIn() {
		return movingIn;
	}



	public void setMovingIn(Date movingIn) {
		this.movingIn = movingIn;
	}



	public int getResidents() {
		return residents;
	}



	public void setResidents(int residents) {
		this.residents = residents;
	}



	public String getMunicipality() {
		return municipality;
	}



	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}



	public Date getMovingInMunicipality() {
		return movingInMunicipality;
	}



	public void setMovingInMunicipality(Date movingInMunicipality) {
		this.movingInMunicipality = movingInMunicipality;
	}



	public String getTurnYearMunicipality() {
		return turnYearMunicipality;
	}



	public void setTurnYearMunicipality(String turnYearMunicipality) {
		this.turnYearMunicipality = turnYearMunicipality;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}


}
