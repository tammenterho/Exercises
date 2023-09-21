package com.mikko.vaestotieto;



import java.util.Date;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

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


@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
	

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	

	
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
	      mockMvc.perform(MockMvcRequestBuilders.delete("/persons/{id}", 11)
	              .contentType(MediaType.APPLICATION_JSON))
	              .andExpect(MockMvcResultMatchers.status().isOk());
	  }

	  
	
	  
}
