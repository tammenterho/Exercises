package com.mikko.vaestotieto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikko.vaestotieto.entities.Address;
import com.mikko.vaestotieto.entities.Parents;
import com.mikko.vaestotieto.entities.Permits;
import com.mikko.vaestotieto.entities.Person;
import com.mikko.vaestotieto.entities.PersonMore;
import com.mikko.vaestotieto.services.AddressService;
import com.mikko.vaestotieto.services.PersonService;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private PersonService personService;
	@MockBean
	private AddressService addressService;

	@Test
	public void testGetAllPersons() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/persons/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	//@BeforeAll for setting up user
	
	
	// TESTING GET PERSON BY ID "/persons/{id}"
	@Test
	public void testGetByIdPerson() throws Exception {
		Person person = new Person();
		person.setId(11L);
		person.setFirstnames("Liisa Maija");
		person.setLastNames("Kokkeli");

		when(personService.getPersonById(person.getId())).thenReturn(person);

		mockMvc.perform(MockMvcRequestBuilders.get("/persons/{id}", 11L).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(person.getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstnames").value(person.getFirstnames()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastNames").value(person.getLastNames()));
	}

	// TESTING POST /persons - FILLING FIELDS
	@Test
	public void testCreatePerson() throws Exception {
		Person person = new Person();
		person.setFirstnames("Juuso Olavi");
		person.setLastNames("Testinen");
		person.setSsn("222222-123R");
		person.setNationality("Finland");
		person.setNationality("Finnish");

		PersonMore personMore = new PersonMore("Finland", "Helsinki", "Finnish", "Male", "Single", "Engineer");
		person.setPersonMore(personMore);

		@SuppressWarnings("deprecation")
		Date date = new Date(120, 0, 11);
		Address address = new Address("Tuureporinkatu 15 b", "20100 Turku", date, 2, "Turku", date, "Turku",
				"juuso.testi@esimerkki.com", "+358 4001234"); // will fail if email doesn't have @
		person.setAddress(address);

		Parents parent1 = new Parents("Jussi", "Testinen", date);
		Parents parent2 = new Parents("Liisa", "Testinen", date);
		person.setParent1(parent1);
		person.setParent2(parent2);

		Permits permits = new Permits(false, true, false, false, true);
		person.setPermits(permits);

		mockMvc.perform(MockMvcRequestBuilders.post("/persons/").content(objectMapper.writeValueAsString(person))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	// TESTING UPDATE PERSON. 1. CREATING PERSON 2. MODIFYING FIELDS
	@Test
	public void testUpdatePerson() throws Exception {
		// CREATE A PERSON
		Person person = new Person();
		person.setId(11L);
		person.setFirstnames("Juuso Olavi");
		person.setLastNames("Testinen");
		person.setSsn("222222-123R");
		person.setNationality("Finland");
		person.setNationality("Finnish");

		PersonMore personMore = new PersonMore("Finland", "Helsinki", "Finnish", "Male", "Single", "Engineer");
		person.setPersonMore(personMore);

		@SuppressWarnings("deprecation")
		Date date = new Date(120, 0, 11);
		Address address = new Address("Tuureporinkatu 15 b", "20100 Turku", date, 2, "Turku", date, "Turku",
				"juuso.testi@esimerkki.com", "+358 4001234");
		person.setAddress(address);

		Parents parent1 = new Parents("Jussi", "Testinen", date);
		Parents parent2 = new Parents("Liisa", "Testinen", date);

		person.setParent1(parent1);
		person.setParent2(parent2);

		Permits permits = new Permits(false, true, false, false, true);
		person.setPermits(permits);

		mockMvc.perform(MockMvcRequestBuilders.post("/persons/").content(objectMapper.writeValueAsString(person))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());

		// System.out.println("after post: " + objectMapper.writeValueAsString(person));

		// UPDATE PERSON
		Person updatedPerson = new Person();
		updatedPerson.setId(11L);
		updatedPerson.setFirstnames("Juuso Matti");
		updatedPerson.setLastNames("Testinen");
		updatedPerson.setSsn("222222-123R");
		updatedPerson.setNationality("Poland");
		updatedPerson.setNationality("Finnish");

		PersonMore personMore2 = new PersonMore("Finland", "Helsinki", "Finnish", "Male", "Single", "Engineer");
		updatedPerson.setPersonMore(personMore2);

		@SuppressWarnings("deprecation")
		Date date2 = new Date(120, 0, 11);
		Address address2 = new Address("Tuureporinkatu 15 b", "20100 Turku", date2, 2, "Turku", date2, "Turku",
				"juuso.testi@esimerkki.com", "+358 4001234");
		updatedPerson.setAddress(address2);

		Parents parent3 = new Parents("Jussi", "Testinen", date);
		Parents parent4 = new Parents("Liisa", "Testinen", date);

		person.setParent1(parent3);
		person.setParent2(parent4);

		Permits permits2 = new Permits(false, true, false, false, true);
		updatedPerson.setPermits(permits2);

		// https://stackoverflow.com/questions/72241095/spring-mvc-controller-testing-put
		when(personService.updatePerson(eq(updatedPerson.getId()), any())).thenReturn(updatedPerson); // PERSONSERVICE

		// System.out.println("Before put: " +
		// objectMapper.writeValueAsString(updatedPerson));

		mockMvc.perform(MockMvcRequestBuilders.put("/persons/{id}", 11L, updatedPerson)
				.content(objectMapper.writeValueAsString(updatedPerson)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

		// System.out.println("After put: " +
		// objectMapper.writeValueAsString(updatedPerson));
	}

	// TESTING DELETING PERSON "/persons/{id}"
	@Test
	public void testDeletePerson() throws Exception {
		Person person = new Person();
		person.setId(11L);

		when(personService.deletePerson(11L)).thenReturn(true);

		mockMvc.perform(MockMvcRequestBuilders.delete("/persons/{id}", 11L)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	// TESTING GET BY FIRSTNAME - TESTING SERVICE AND CONTROLLER
	// /persons/firstname/{firstNames}
	@Test
	public void testGetByFirstName() throws Exception {
		Person person = new Person();
		Person person2 = new Person();
		person.setFirstnames("Matti");
		person.setLastNames("Mattilainen");
		person2.setFirstnames("Liisa");
		person2.setLastNames("Liisalainen");

		List<Person> persons = new ArrayList<>();
		persons.add(person);
		persons.add(person2);

		when(personService.getPersonsByFirstName(person.getFirstnames())).thenReturn(persons);

		mockMvc.perform(MockMvcRequestBuilders.get("/persons/firstname/{firstNames}", "Matti")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	// TESTING GET BY LASTNAME - TESTING SERVICE AND CONTROLLER
	// /persons/lastname/{lastName}
	@Test
	public void testGetByLastName() throws Exception {
		Person person = new Person();
		Person person2 = new Person();
		person.setFirstnames("Matti");
		person.setLastNames("Mattilainen");
		person2.setFirstnames("Liisa");
		person2.setLastNames("Liisalainen");

		List<Person> persons = new ArrayList<>();
		persons.add(person);
		persons.add(person2);

		// System.out.println("tässä henkilöt" + objectMapper.writeValueAsString(persons));

		when(personService.getPersonsByLastName(person2.getLastNames())).thenReturn(persons);

		mockMvc.perform(MockMvcRequestBuilders.get("/persons/lastname/{lastName}", "Liisalainen")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	// TESTING UPDATING EMAIL - VALIDATION INCLUDED IN CONTROLLER - SERVICE CLASS
	// TESTING AND CONTROLLER TESTING /persons/{id}/email
	@Test
	public void testUpdateEmail() throws Exception {
		@SuppressWarnings("deprecation")
		Date date = new Date(120, 0, 11);
		Person person = new Person();
		Address address = new Address("Tuureporinkatu 15 b", "20100 Turku", date, 2, "Turku", date, "Turku",
				"juuso.testi@esimerkki.com", "+358 4001234");
		person.setId(11L);
		person.setAddress(address);

		String newEmail = "juusojuusonen@gmail.com";
		person.getAddress().setEmail(newEmail);

		when(addressService.updateEmail(eq(person.getId()), any())).thenReturn(person); // ADDRESSSERVICE SIMULATION

		// System.out.println("After when: " + objectMapper.writeValueAsString(person));

		mockMvc.perform(MockMvcRequestBuilders.put("/persons/{id}/email", 11L, newEmail)
				.content(objectMapper.writeValueAsString(newEmail)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

		// System.out.println("After put email: " + objectMapper.writeValueAsString(person));

		assertEquals(newEmail, person.getAddress().getEmail());
	}

	// TEST DELETE EMAIL - TESTS CONTROLLER AND ADDRESSSERVICE
	@Test
	public void testDeleteEmail() throws Exception {
		Person person = new Person();
		@SuppressWarnings("deprecation")
		Date date = new Date(120, 0, 11);
		Address address = new Address("Tuureporinkatu 15 b", "20100 Turku", date, 2, "Turku", date, "Turku",
				"juuso.testi@esimerkki.com", "+358 4001234");
		person.setId(11L);
		person.setAddress(address);

		when(addressService.deleteEmail(eq(person.getId()))).thenReturn(null); // should return null if deleted - doesnt actully delete email

		mockMvc.perform(
				MockMvcRequestBuilders.delete("/persons/{id}/email", 11L)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound()); // waiting for 404 because no email after delete
																			
		
		// System.out.println("After deleting email: " + objectMapper.writeValueAsString(person));
	}

}
