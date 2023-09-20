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
	
	public List<Person> getAllPersons() {
		return persons;
	}
	
	public Person getPersonById(Long id) {
		for (Person person : persons) {
			if (person.getId().equals(id)) {
				return person;
			}
		}
		return null;
	}

	public Person createPerson(Person person) {
		persons.add(person);
		return person;
	}

	public Person updatePerson(Long id, Person updatedPerson) {
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getId().equals(id)) {
				persons.set(i, updatedPerson);
				return updatedPerson;
			}
		}
		
		return null;
	}
	
	public boolean deletePerson(Long id) {
		for (Person person : persons) {
			if (person.getId().equals(id)) {
				persons.remove(person);
				return true;
			}
		}
		return false;
	
	}

}
