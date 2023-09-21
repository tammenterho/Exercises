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

import com.mikko.vaestotieto.entities.Person;
import com.mikko.vaestotieto.services.PersonService;

@RestController
@RequestMapping("persons")
public class PersonController {

	private final PersonService personService;
	
	@Autowired
	public PersonController (PersonService personService) {
		this.personService = personService;
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
	
	// POST - CREATE PERSON
	@PostMapping("/")
	public ResponseEntity<Person>createPerson(@RequestBody Person person) {
		Person newPerson = personService.createPerson(person);
		return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
		
			
		
		
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
	
	// DELETE PERSON
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deletePerson(@PathVariable Long id) {
		boolean deleted = personService.deletePerson(id);
		 if (deleted) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}
}
