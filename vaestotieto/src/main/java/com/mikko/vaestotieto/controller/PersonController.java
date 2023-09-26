package com.mikko.vaestotieto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikko.vaestotieto.entities.Address;
import com.mikko.vaestotieto.entities.Person;
import com.mikko.vaestotieto.services.AddressService;
import com.mikko.vaestotieto.services.PersonService;
import com.mikko.vaestotieto.validators.EmailValidator;


@RestController
@RequestMapping("persons")
public class PersonController {

	private final PersonService personService;
	private final AddressService addressService;
	
	@Autowired
	public PersonController (PersonService personService, AddressService addressService) {
		this.personService = personService;
		this.addressService = addressService;
	}
	
	// GET ALL
	@GetMapping("/")
	public ResponseEntity<List<Person>>getAllPersons() {
		List<Person> persons = personService.getAllPersons();
		return new ResponseEntity<> (persons, HttpStatus.OK);
	}
	
	// GET BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
		Person person = personService.getPersonById(id);
		if (person != null) {
			return new ResponseEntity<>(person, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/firstname/{firstNames}")
	public ResponseEntity<List<Person>> getPersonByFirstname(@PathVariable("firstNames") String firstnames) {
	    List<Person> persons = personService.getPersonsByFirstName(firstnames);
	    if (!persons.isEmpty()) {
	        return new ResponseEntity<>(persons, HttpStatus.OK);
	    }	
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/lastname/{lastNames}")
	public ResponseEntity<List<Person>>getPersonByLastname(@PathVariable("lastNames") String lastNames) {
		List<Person> persons = personService.getPersonsByLastName(lastNames);
		if (!persons.isEmpty()) {
			return new ResponseEntity<>(persons, HttpStatus.OK);
		}	
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	} 
	
	// POST - CREATE PERSON
	@PostMapping("/")
	public ResponseEntity<Person>createPerson( @RequestBody Person person) {
		if (EmailValidator.patternMatches(person.getAddress().getEmail(), "^(.+)@(\\S+)$")) {
		Person newPerson = personService.createPerson(person);
		return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// PUT - UPDATE PERSON
	@PutMapping("/{id}")
	public ResponseEntity<Person>updatePerson(@PathVariable Long id, @RequestBody Person person) {
		Person updatedPerson = personService.updatePerson(id, person);
		if (updatedPerson != null) {
			return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	// PUT - UPDATE EMAIL - DEPENDS ON FORM - POSSIBLY LANGUAGE AND NUMBER ASWELL
	@PutMapping("/{id}/email")
	public ResponseEntity<Person> updateEmail(@PathVariable Long id, @RequestBody  String newEmail) {
		if (EmailValidator.patternMatches(newEmail, "^(.+)@(\\S+)$")) {
			Person updatedPerson = addressService.updateEmail(id, newEmail);
			if (updatedPerson != null) {
	        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
			} else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// DELETE - PERSON
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deletePerson(@PathVariable Long id) {
		boolean deleted = personService.deletePerson(id);
		 if (deleted) {
			 return new ResponseEntity<>(HttpStatus.OK);
	     } else {
	    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	}
	
	// DELETE - EMAIL
	@DeleteMapping("/{id}/email")
	public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
	    Person existingPerson = personService.getPersonById(id);
	    
	    if (existingPerson != null) {
	        Address personAddress = existingPerson.getAddress(); 
	        if (personAddress != null) {
	            addressService.deleteEmail(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
