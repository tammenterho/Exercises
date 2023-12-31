package com.mikko.vaestotieto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mikko.vaestotieto.entities.Person;

// INCLUDES UPDATE AND DELETE EMAIL - THOSE WERE ATTRIBUTES THAT USER COULD DO IN VÄESTÖREKISTERI
@Service
public class AddressService {

	private final List<Person> persons;

	public AddressService(List<Person> persons) {
		this.persons = persons;

	}

	public Person updateEmail(Long id, String newEmail) {
		for (Person person : persons) {
			if (person.getId().equals(id)) {
				person.getAddress().setEmail(newEmail);
				return person;
			}
		}
		return null;
	}

	public Person deleteEmail(Long id) {
		for (Person person : persons) {
			if (person.getId().equals(id) && person.getAddress() != null) {
				person.getAddress().setEmail(null);
				return person;
			}
		}
		return null;
	}
}
