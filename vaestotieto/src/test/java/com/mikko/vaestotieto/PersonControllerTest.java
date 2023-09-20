package com.mikko.vaestotieto;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalTime;
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
import com.mikko.vaestotieto.entities.Person;

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
	        person.setFirstname("Juuso");
	        person.setLastname("Testinen");
	        person.setBirth(new Date(80, 0, 1)); 
			person.setDeath(new Date(100, 0, 1));

	        mockMvc.perform(MockMvcRequestBuilders.post("/persons/")
	                .content(objectMapper.writeValueAsString(person))
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isCreated());
	    }
	  

		@Test
		public void testCalculateAge() {
			Person person = new Person();
			person.setBirth(new Date(93, 4, 25)); //1980   -    1900 + year (2000 = 100) , month 0-11, day 1-31 

			int age = person.calculateAge();

			
			assertEquals(30, age);
		}
		
		 @Test
		    public void testCreatePersonInvalidData() throws Exception {
		        Person person = new Person();
		        person.setBirth(new Date(110, 0, 1)); //1980   -    1900 + year (2000 = 100) , month 0-11, day 1-31 
				person.setDeath(new Date(100, 0, 1));

				mockMvc.perform(MockMvcRequestBuilders.post("/persons/")
		            .contentType(MediaType.APPLICATION_JSON)
		            .content(objectMapper.writeValueAsString(person)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		    }
	  
	  
}
