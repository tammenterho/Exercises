package com.mikko.vaestotieto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mikko.vaestotieto.entities.Address;
import com.mikko.vaestotieto.entities.Person;
import com.mikko.vaestotieto.services.AddressService;
import com.mikko.vaestotieto.services.PersonService;
import com.mikko.vaestotieto.validators.EmailValidator;

// TESTING SERVICE CLASSES PERSONSERVICE, ADDRESSERVICE AND EMAIL VALIDATION
public class PersonServiceTest {

	@Mock
	private PersonService personService;
	@Mock
	private AddressService addressService;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	// GET ALL PERSONS TEST
	@Test
	public void testGetAllPersons() {

		Person mockPerson1 = new Person();
		Person mockPerson2 = new Person();
		Person mockPerson3 = new Person();
		mockPerson1.setId(1L);
		mockPerson2.setId(2L);
		mockPerson3.setId(3L);
		mockPerson1.setFirstnames("John");
		mockPerson2.setFirstnames("Lars");
		mockPerson3.setFirstnames("Samantha");

		List<Person> mockPersons = new ArrayList<>();
		mockPersons.add(mockPerson1);
		mockPersons.add(mockPerson2);
		mockPersons.add(mockPerson3);

		when(personService.getAllPersons()).thenReturn(mockPersons);

		List<Person> result = personService.getAllPersons();
		assertEquals(mockPersons, result);
	}

	// FIND PERSONS NAME BY ID TEST
	@Test
	public void testGetPersonById() {

		Person mockPerson = new Person();
		mockPerson.setId(1L);
		mockPerson.setFirstnames("John");
		// mockPerson.setFirstnames("Lisa"); // test with different values

		when(personService.getPersonById(1L)).thenReturn(mockPerson);

		Person result = personService.getPersonById(1L);

		assertEquals(1L, result.getId());
		assertEquals("John", result.getFirstnames());
	}

	// FIND PERSON BY NAME
	@Test
	public void testGetPersonsByFirstName() {

		Person person1 = new Person();
		person1.setId(1L);
		person1.setFirstnames("John");

		Person person2 = new Person();
		person2.setId(2L);
		person2.setFirstnames("Jane");

		List<Person> mockPersons = new ArrayList<>();
		mockPersons.add(person1);
		mockPersons.add(person2);

		when(personService.getPersonsByFirstName("John")).thenReturn(mockPersons);

		List<Person> result = personService.getPersonsByFirstName("John");

		assertEquals(2, result.size());
		assertEquals("John", result.get(0).getFirstnames());
		assertEquals("Jane", result.get(1).getFirstnames());
	}

	// FIND PERSON BY LASTNAME
	@Test
	public void testGetPersonsByLastName() {

		Person person1 = new Person();
		person1.setId(1L);
		person1.setLastNames("Doe");

		Person person2 = new Person();
		person2.setId(2L);
		person2.setLastNames("Smith");

		List<Person> mockPersons = new ArrayList<>();
		mockPersons.add(person1);
		mockPersons.add(person2);

		when(personService.getPersonsByLastName("Doe")).thenReturn(mockPersons);

		List<Person> result = personService.getPersonsByLastName("Doe");

		assertEquals(2, result.size());
		assertEquals("Doe", result.get(0).getLastNames());
		assertEquals("Smith", result.get(1).getLastNames());
	}

	// TEST CREATE PERSON
	@Test
	public void testCreatePerson() {

		Person person1 = new Person();
		person1.setId(1L);
		person1.setFirstnames("Joni");
		person1.setLastNames("Joninen");

		when(personService.createPerson(person1)).thenReturn(person1);

		Person createdPerson = personService.createPerson(person1);

		assertEquals(person1, createdPerson);

	}

	// TEST UPDATE PERSON
	@Test
	public void testUpdatePerson() {
		Person originalPerson = new Person();
		originalPerson.setId(1L);
		originalPerson.setFirstnames("Joni");
		originalPerson.setLastNames("Joninen");

		// then answer lets me define what to return instead of returning originalPerson
		// always
		when(personService.updatePerson(eq(originalPerson.getId()), any())).thenAnswer(invocation -> {
			Person updatedPerson = invocation.getArgument(1); // second argument is updated person
			updatedPerson.setId(originalPerson.getId());
			return updatedPerson;
		});

		Person updatedPerson = new Person();
		updatedPerson.setFirstnames("Kerttu");
		updatedPerson.setLastNames("Karttunen");

		Person returnedPerson = personService.updatePerson(originalPerson.getId(), updatedPerson);

		assertEquals(originalPerson.getId(), returnedPerson.getId());
		assertEquals("Kerttu", returnedPerson.getFirstnames());
		assertEquals("Karttunen", returnedPerson.getLastNames());
	}

	// TEST DELETE PERSON
	@Test
	public void testDeletePerson() {

		Person originalPerson = new Person();
		originalPerson.setId(1L);
		originalPerson.setFirstnames("Joni");
		originalPerson.setLastNames("Joninen");

		when(personService.deletePerson(originalPerson.getId())).thenReturn(true);

		boolean isDeleted = personService.deletePerson(originalPerson.getId());

		verify(personService).deletePerson(originalPerson.getId());

		assertTrue(isDeleted);
	}

	// TEST DELETE EMAIL
	@Test
	public void testDeleteEmail() {

		Person person = new Person();
		person.setId(1L);
		Address address = new Address();
		address.setEmail("joni@example.com");
		person.setAddress(address);

		List<Person> persons = new ArrayList<>();
		persons.add(person);

		when(addressService.deleteEmail(eq(1L))).thenAnswer(invocation -> {

			Person deletedPerson = persons.get(0);
			deletedPerson.getAddress().setEmail(null);
			return deletedPerson;
		});

		Person deletedPerson = addressService.deleteEmail(1L);
		assertNull(deletedPerson.getAddress().getEmail());
	}

	// TEST UPDATE EMAIL
	@Test
	public void testUpdateEmail() {

		Person originalPerson = new Person();
		originalPerson.setId(1L);
		Address address = new Address();
		address.setEmail("joni@example.com");
		originalPerson.setAddress(address);

		when(addressService.updateEmail(eq(originalPerson.getId()), anyString())).thenAnswer(invocation -> {
			String newEmail = invocation.getArgument(1); // second argument is the new email
			Person updatedPerson = new Person();
			updatedPerson.setId(originalPerson.getId());
			address.setEmail(newEmail);
			updatedPerson.setAddress(address);
			return updatedPerson;
		});

		String newEmail = "new.email@example.com";
		Person returnedPerson = addressService.updateEmail(1L, newEmail);

		System.out.println("Returned Person: " + returnedPerson.toString());

		assertEquals(1L, returnedPerson.getId());
		assertEquals(newEmail, returnedPerson.getAddress().getEmail());
	}

	// TEST EMAIL VALIDATION
	@Test
	public void testUsingSimpleRegex() {
		String emailAddress = "username@domain.com"; // example email
		String regexPattern = "^(.+)@(\\S+)$"; // rule
		assertTrue(EmailValidator.patternMatches(emailAddress, regexPattern));
	}
}
