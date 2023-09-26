package com.mikko.vaestotieto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mikko.vaestotieto.entities.Person;
import com.mikko.vaestotieto.services.PersonService;

public class PersonServiceTest {

    @Mock
    private PersonService personService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPersonById() {
       
        Person mockPerson = new Person();
        mockPerson.setId(1L);
        mockPerson.setFirstnames("John");

   
        when(personService.getPersonById(1L)).thenReturn(mockPerson);

       
        Person result = personService.getPersonById(1L);

        
        assertEquals(1L, result.getId());
        assertEquals("John", result.getFirstnames());
    }

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
    
    @Test
    public void testGetPersonsByLastName() {
      
        Person person1 = new Person();
        person1.setId(1L);
        person1.setLastnames("Doe");

        Person person2 = new Person();
        person2.setId(2L);
        person2.setLastnames("Smith");

        List<Person> mockPersons = new ArrayList<>();
        mockPersons.add(person1);
        mockPersons.add(person2);

    
        when(personService.getPersonsByLastName("Doe")).thenReturn(mockPersons);

        
        List<Person> result = personService.getPersonsByLastName("Doe");

       
        assertEquals(2, result.size());
        assertEquals("Doe", result.get(0).getLastnames());
        assertEquals("Smith", result.get(1).getLastnames());
    }
    
    
}

