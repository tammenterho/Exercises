package com.mikko.vaestotieto.entities;

public class PersonMore {
	private String countryBorn;
	private String municipalityBorn;
	private String language;
	private String gender;
	private String maritalStatus;
	private String occupation;

	public PersonMore(String countryBorn, String municipalityBorn, String language, String gender, String maritalStatus,
			String occupation) {

		this.countryBorn = countryBorn;
		this.municipalityBorn = municipalityBorn;
		this.language = language;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
	}

	public String getCountryBorn() {
		return countryBorn;
	}

	public void setCountryBorn(String countryBorn) {
		this.countryBorn = countryBorn;
	}

	public String getMunicipalityBorn() {
		return municipalityBorn;
	}

	public void setMunicipalityBorn(String municipalityBorn) {
		this.municipalityBorn = municipalityBorn;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
}
