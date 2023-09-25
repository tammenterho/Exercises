package com.mikko.vaestotieto;



import static org.mockito.Mockito.when;


import java.util.Date;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikko.vaestotieto.controller.PersonController;
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
		mockMvc.perform(MockMvcRequestBuilders.get("/persons/")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	  @Test
	    public void testCreatePerson() throws Exception {
	        Person person = new Person();
	        person.setFirstnames("Juuso Olavi");
	        person.setLastname("Testinen");
	        person.setSsn("222222-123R");
	        person.setNationality("Finland");
	        person.setNationality("Finnish");
	        
	        PersonMore personMore = new PersonMore("Finland", "Helsinki", "Finnish", "Male", "Single", "Engineer");
	        person.setPersonMore(personMore);
	        
	        Date date = new Date(120, 0, 11);
	        Address address = new Address ("Tuureporinkatu 15 b", "20100 Turku", date, 2, "Turku", date, "Turku", "juuso.testi@esimerkki.com", "+358 4001234" );
	        person.setAddress(address);
	        
	        Parents parent1 = new Parents("Jussi", "Testinen", date);
	        Parents parent2 = new Parents("Liisa", "Testinen", date);
	        
	        person.setParents(parent2, parent1);
	        
	        Permits permits = new Permits(false, true, false, false, true);
	        person.setPermits(permits);
	       

	        mockMvc.perform(MockMvcRequestBuilders.post("/persons/")
	                .content(objectMapper.writeValueAsString(person))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isCreated());
	    }
	  
	  @Test
	  public void testDeletePerson() throws Exception {
		  Person person = new Person();
	        person.setId(11L);
	        
	      when(personService.deletePerson(11L)).thenReturn(true);
		  
	      mockMvc.perform(MockMvcRequestBuilders.delete("/persons/{id}", 11L)
	              .contentType(MediaType.APPLICATION_JSON))
	              .andExpect(MockMvcResultMatchers.status().isOk());
	  }
	  
	  /*
	  
	  @Test
	  public void testUpdatePerson() throws Exception {
		  // CREATE A PERSON
		  Person person = new Person();
		  	person.setId(11L);
	        person.setFirstnames("Juuso Olavi");
	        person.setLastname("Testinen");
	        person.setSsn("222222-123R");
	        person.setNationality("Finland");
	        person.setNationality("Finnish");
	        
	        PersonMore personMore = new PersonMore("Finland", "Helsinki", "Finnish", "Male", "Single", "Engineer");
	        person.setPersonMore(personMore);
	        
	        Date date = new Date(120, 0, 11);
	        Address address = new Address ("Tuureporinkatu 15 b", "20100 Turku", date, 2, "Turku", date, "Turku", "juuso.testi@esimerkki.com", "+358 4001234" );
	        person.setAddress(address);
	        
	        Parents parent1 = new Parents("Jussi", "Testinen", date);
	        Parents parent2 = new Parents("Liisa", "Testinen", date);
	        
	        person.setParents(parent2, parent1);
	        
	        Permits permits = new Permits(false, true, false, false, true);
	        person.setPermits(permits);
	       
	        
	        
	        mockMvc.perform(MockMvcRequestBuilders.post("/persons/")
	                .content(objectMapper.writeValueAsString(person))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isCreated());
	        
	        System.out.println("after post: " + objectMapper.writeValueAsString(person));
	        
	        // UPDATE PERSON
	        
	        Person updatedPerson = new Person();
	        updatedPerson.setId(11L);
	        updatedPerson.setFirstnames("Juuso Matti");
	        updatedPerson.setLastname("Testinen");
	        updatedPerson.setSsn("222222-123R");
	        updatedPerson.setNationality("Poland");
	        updatedPerson.setNationality("Finnish");
	        
	        PersonMore personMore2 = new PersonMore("Finland", "Helsinki", "Finnish", "Male", "Single", "Engineer");
	        updatedPerson.setPersonMore(personMore2);
	        
	        Date date2 = new Date(120, 0, 11);
	        Address address2 = new Address ("Tuureporinkatu 15 b", "20100 Turku", date2, 2, "Turku", date2, "Turku", "juuso.testi@esimerkki.com", "+358 4001234" );
	        updatedPerson.setAddress(address2);
	        
	        Parents parent3 = new Parents("Jussi", "Testinen", date);
	        Parents parent4 = new Parents("Liisa", "Testinen", date);
	        
	        updatedPerson.setParents(parent4, parent3);
	        
	        Permits permits2 = new Permits(false, true, false, false, true);
	        updatedPerson.setPermits(permits2);
	        
	        
	        when(personService.updatePerson(11L, updatedPerson)).thenReturn(updatedPerson);
	        System.out.println("Before put: " + objectMapper.writeValueAsString(updatedPerson));
	        
	        mockMvc.perform(MockMvcRequestBuilders.put("/persons/{id}", 11L)
	                .content(objectMapper.writeValueAsString(updatedPerson))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk());
	        
	        System.out.println("After put: " + objectMapper.writeValueAsString(updatedPerson));
	        
	        
	  }
	  
	  @Test
	  public void testUpdateEmail() throws Exception {
	      Date date = new Date(120, 0, 11);
	      Person person = new Person();
	      Address address = new Address("Tuureporinkatu 15 b", "20100 Turku", date, 2, "Turku", date, "Turku", "juuso.testi@esimerkki.com", "+358 4001234");
	      person.setId(11L);
	      person.setAddress(address);

	      when(addressService.updateEmail(11L, "matti.mattinen@gmail.com")).thenReturn(person);

	      mockMvc.perform(MockMvcRequestBuilders.put("/persons/{id}/email", 11L)
	              .param("newEmail", "matti.mattinen@gmail.com")
	              .contentType(MediaType.APPLICATION_JSON))
	              .andExpect(MockMvcResultMatchers.status().isOk());
	  }
*/
}
