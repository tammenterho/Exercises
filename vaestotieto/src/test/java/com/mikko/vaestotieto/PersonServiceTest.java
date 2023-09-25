package com.mikko.vaestotieto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mikko.vaestotieto.entities.Person;
import com.mikko.vaestotieto.services.PersonService;

public class PersonServiceTest {

    @Mock
    private PersonService personService;

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


  
    
 


}

