package com.mikko.vaestotieto.entities;

public class Address {
	private String street;
	private String numberStair;
	private String city;
	private String postal;
	
	
	
	public Address(String street, String numberStair, String city, String postal) {
		this.street = street;
		this.numberStair = numberStair;
		this.city = city;
		this.postal = postal;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getNumberStair() {
		return numberStair;
	}



	public void setNumberStair(String numberStair) {
		this.numberStair = numberStair;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPostal() {
		return postal;
	}



	public void setPostal(String postal) {
		this.postal = postal;
	}

	
}
