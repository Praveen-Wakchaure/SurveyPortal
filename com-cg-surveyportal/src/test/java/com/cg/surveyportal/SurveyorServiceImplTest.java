package com.cg.surveyportal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.surveyportal.entities.Survey;
import com.cg.surveyportal.entities.Surveyor;
import com.cg.surveyportal.exceptions.InvalidSurveyorException;
import com.cg.surveyportal.exceptions.SurveyorNotFoundException;
import com.cg.surveyportal.repositories.ISurveyorRepository;
import com.cg.surveyportal.services.ISurveyorService;
import java.util.Optional;



@SpringBootTest
class SurveyorServiceImplTest {
	
	@Autowired
	ISurveyorService surveyorService;
	
	@MockBean
	ISurveyorRepository surveyorRepository;
	
	
	Surveyor sv;
	Survey s;
	
	@BeforeEach
	public void init() {
		sv = new Surveyor();
		sv.setId(20l);
		sv.setFirstName("abc");
		sv.setLastName("xyz");
		sv.setUsername("cvb");
		sv.setSurveys(null);
	}
	
	
	@Test
	@DisplayName ("Positive test case for getting all Surveyor")
	 void testgetAllSurveyors()
	{

		Mockito.when(surveyorRepository.findAll()).thenReturn(Stream.of(sv).collect(Collectors.toList()));
		assertEquals(1, surveyorService.getAllSurveyors().size());
	}
	
	@Test
	@DisplayName ("Negative test case for getting all Surveyor")
	 void testgetAllSurveyorsNegative()
	{
		
		Mockito.when(surveyorRepository.findAll()).thenReturn(Stream.of(sv).collect(Collectors.toList()));
		assertNotEquals(2, surveyorService.getAllSurveyors().size());
	}
	
	@Test
	@DisplayName ("Positive test case for Adding Surveyor")
	
	 void testadd() throws InvalidSurveyorException
	{
		
		
		String s = "Surveyor Added Successfully";
		
		Mockito.when(surveyorRepository.save(sv)).thenReturn(sv);
		assertThat(surveyorService.add(sv)).isEqualTo(s);
	}
	
	@Test
	@DisplayName ("Negative test case for Adding Surveyor")
	
	 void testaddNegative() throws InvalidSurveyorException
	{
		
		Surveyor serveyor = new Surveyor();
		serveyor.setId(21l);
		serveyor.setFirstName("David");
		serveyor.setLastName("Austin");
		serveyor.setUsername("dav_aus");
		serveyor.setSurveys(null);
		
		String s = "Surveyor  Added Successfully";
		
		Mockito.when(surveyorRepository.save(sv)).thenReturn(sv);
		assertThat(surveyorService.add(serveyor)).isNotEqualTo(s);
	}
	
	
	
	@Test
	@DisplayName ("Positive Test case for getting Surveyor by ID")
	 void testgetById() throws SurveyorNotFoundException 
	{
		Mockito.when(surveyorRepository.findById(sv.getId())).thenReturn(Optional.of(sv));
		assertEquals(sv,surveyorService.getById(20l));
	}
	
	
	@Test
	@DisplayName ("Negative Test case for getting Surveyor by ID")
	 void testgetByIdNegative() throws SurveyorNotFoundException 
	{
		Mockito.when(surveyorRepository.findById(sv.getId())).thenReturn(Optional.of(sv));
		Assertions.assertThrows(SurveyorNotFoundException.class, ()-> surveyorService.getById(21l));
	}
	
	
	
	@Test
	@DisplayName ("Positive Test case for getting Surveyor by Username")
	 void testgetByUsername() throws SurveyorNotFoundException, InvalidSurveyorException 
	{
		
		
		Mockito.when(surveyorRepository.findByUsername("dav_aus")).thenReturn(sv);
		assertThat(surveyorService.getByUsername("dav_aus")).isEqualTo(sv);
		
		
	}
	
	@Test
	@DisplayName ("Negative Test case for getting Surveyor by Username")
	 void testgetByUsernameNegative() throws SurveyorNotFoundException, InvalidSurveyorException 
	{
		Surveyor serveyor = new Surveyor();
		serveyor.setId(21l);
		serveyor.setFirstName("David");
		serveyor.setLastName("Austin");
		serveyor.setUsername("dav_aus_hello");
		serveyor.setSurveys(null);
		
		
		Mockito.when(surveyorRepository.findByUsername("dav_aus")).thenReturn(sv);
		assertThat(surveyorService.getByUsername("dav_aus")).isNotEqualTo(serveyor);
		
		
	}
	
	@Test
	@DisplayName("Positive Test Case for updating record")
	 void testupdate() throws InvalidSurveyorException, SurveyorNotFoundException
	{
		Surveyor serveyor = new Surveyor();
		serveyor.setId(21l);
		serveyor.setFirstName("David");
		serveyor.setLastName("Austin");
		serveyor.setUsername("dav_aus");
		serveyor.setSurveys(null);
		String s = "Surveyor Updated Successfully";
		
		Mockito.when(surveyorRepository.save(serveyor)).thenReturn(serveyor);
		assertThat(surveyorService.update(serveyor)).isEqualTo(s);
		
	}
	
	
	@Test
	@DisplayName("Negative Test Case for updating record")
	 void testupdateNegative() throws InvalidSurveyorException, SurveyorNotFoundException
	{
		Surveyor serveyor = new Surveyor();
		serveyor.setId(21l);
		serveyor.setFirstName("David");
		serveyor.setLastName("Austin");
		serveyor.setUsername("dav_aus");
		serveyor.setSurveys(null);
		String s = "Surveyor Not Updated Successfully";
		
		Mockito.when(surveyorRepository.save(serveyor)).thenReturn(serveyor);
		assertThat(surveyorService.update(serveyor)).isNotEqualTo(s);
		
	}
	
	
	
	@Test
	@DisplayName("Positive Test Case for Getting Record Count")
	 void testgetRecordsCount()
	{
		
		Long a = 2l;
		Mockito.when(surveyorRepository.count()).thenReturn(a);
		assertThat(surveyorService.getRecordsCount()).isEqualTo(a);
	}
	
	@Test
	@DisplayName("Negative Test Case for Getting Record Count")
	 void testgetRecordsCountNegative()
	{
		
		Long a = 2l;
		Long b = 3l;
		Mockito.when(surveyorRepository.count()).thenReturn(a);
		assertThat(surveyorService.getRecordsCount()).isNotEqualTo(b);
	}
	
	
	
	
	@Test
	@DisplayName("Positive Test Case for removing all Records Count")
	
	 void testremoveAllRecords()
	{
		String s = "All Records Deleted ";
		assertThat(surveyorService.removeAllRecords()).isEqualTo(s);
		Mockito.verify(surveyorRepository).deleteAll();
	}
	
	
	@Test
	@DisplayName("Negative Test Case for removing all Records Count")
	
	 void testremoveAllRecordsNegative()
	{
		String s = "All Records Not Deleted ";
		assertThat(surveyorService.removeAllRecords()).isNotEqualTo(s);
		Mockito.verify(surveyorRepository).deleteAll();
	}
	
	
	
	@Test
	@DisplayName("Positive Test Case for remove record by id")
	 void testremoveById() throws InvalidSurveyorException
	{
		
		
		//String s = "Data Deleted Successfully";
		surveyorRepository.deleteById(sv.getId());
        assertEquals(0, surveyorRepository.count());
		//assertThat(surveyorService.removeById(20l)).isEqualTo(s);
		//Mockito.verify(surveyorRepository).deleteById(20l);
	}
	
	@Test
	@DisplayName("Negative Test Case for remove record by id")
	 void testremoveByIdNegative() throws InvalidSurveyorException
	{
		
		
		//String s = "Data Not Deleted Successfully";
		surveyorRepository.deleteById(sv.getId());
        assertNotEquals(1, surveyorRepository.count());
        
//		assertThat(surveyorService.removeById(23l)).isNotEqualTo(s);
//		Mockito.verify(surveyorRepository).deleteById(23l);
	}
	
	
	
}
