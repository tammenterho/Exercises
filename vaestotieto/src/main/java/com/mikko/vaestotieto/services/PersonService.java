package com.mikko.vaestotieto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mikko.vaestotieto.entities.Person;

@Service
public class PersonService {

	private final List<Person> persons;
	
	public PersonService(List<Person>persons) {
		this.persons = persons;
	}
	
	public Person getPersonById(Long id) {
		for (Person person : persons) {
			if (person.getId().equals(id)) {
				return person;
			}
		}
		return null;
	}
}
