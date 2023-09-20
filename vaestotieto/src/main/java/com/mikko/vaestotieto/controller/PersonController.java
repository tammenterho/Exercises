package com.mikko.vaestotieto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	public ResponseEntity<List<Person>>getAllPersons() {
		List<Person> persons = personService.getAllPersons();
		return new ResponseEntity<> (persons, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
		Person person = personService.getPersonById(id);
		if (person != null) {
			return new ResponseEntity<>(person, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
