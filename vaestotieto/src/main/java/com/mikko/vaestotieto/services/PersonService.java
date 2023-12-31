package com.mikko.vaestotieto.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mikko.vaestotieto.entities.Person;

//INCLUDES GET ALL, GET BY ID, GET BY FIRSTNAME, GET BY LASTNAME, CREATE A PERSON, UPDATE A PERSON, SAVE PERSON AND GENERATE ID
@Service
public class PersonService {

	private final List<Person> persons;

	public PersonService(List<Person> persons) {
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

	public List<Person> getPersonsByFirstName(String firstname) {
		List<Person> matchingFirstNames = persons.stream()
				.filter(person -> person.getFirstnames().equalsIgnoreCase(firstname)).collect(Collectors.toList());

		//int firstNameCount = matchingFirstNames.size(); // SIZE OF THE LIST
		// System.out.println("firstnames in list" + firstNameCount);

		return matchingFirstNames;
	}

	public List<Person> getPersonsByLastName(String lastname) {
		List<Person> matchingLastNames = persons.stream()
				.filter(person -> person.getLastNames().equalsIgnoreCase(lastname)).collect(Collectors.toList());

		// int lastNameCount = matchingLastNames.size(); // SIZE OF THE LIST

		return matchingLastNames;
	}
	
	
	// THESE METHODS DEPENDS ON DATABASE
	
	public Person savePerson(Person person) {
	   
	    if (person.getId() == null) {
	        long newId = generateNewId();
	        person.setId(newId);
	        persons.add(person);
	    } else {
	        for (int i = 0; i < persons.size(); i++) {
	            if (persons.get(i).getId().equals(person.getId())) {
	                persons.set(i, person); 
	                break;
	            }
	        }
	    }
	    return person;
	}

	
	private long generateNewId() {
	    return Math.round(Math.random() * 100000);
	}

}
