package com.mindex.challenge.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensate;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensateService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensateServiceImplTest {
	private String compensateUrl;
	private String compensateIdUrl;
	
	@Autowired
	private CompensateService compensateService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
    @LocalServerPort
    private int port;
	
	@Before
    public void setup() {
        compensateUrl = "http://localhost:" + port + "/compensate";
        compensateIdUrl = "http://localhost:" + port + "/compensate/{id}";
    }
    
    @Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void testCreateRread() {
		Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");

		// Test Compensate	
		Compensate testCompensate = new Compensate();
		testCompensate.setEmployee(employee);
		testCompensate.setEmployeeId(employee.getEmployeeId());
		testCompensate.setSalary(65000);
		testCompensate.setEffectiveDate("2/20/2020");
		
		// Create Check
		Compensate createdCompensate = restTemplate.postForEntity(compensateUrl, testCompensate, Compensate.class).getBody();
		assertEquals(createdCompensate.getEmployeeId(), testCompensate.getEmployeeId());
		assertCompensateEquivalence(createdCompensate, testCompensate);
		
		// Read Check
		Compensate readCompensate = restTemplate.getForEntity(compensateIdUrl, Compensate.class, createdCompensate.getEmployeeId()).getBody();
		assertEquals(createdCompensate.getEmployeeId(), readCompensate.getEmployeeId());
		assertCompensateEquivalence(createdCompensate, readCompensate);
	}
	
	private static void assertCompensateEquivalence(Compensate expected, Compensate actual) {
		assertEquals(expected.getEmployee().getFirstName(), actual.getEmployee().getFirstName());
		assertEquals(expected.getEmployee().getLastName(), actual.getEmployee().getLastName());
		assertEquals(expected.getEmployee().getDepartment(), actual.getEmployee().getDepartment());
		assertEquals(expected.getEmployee().getPosition(), actual.getEmployee().getPosition());
		assertEquals(expected.getSalary(), actual.getSalary());
		assertEquals(expected.getEffectiveDate(), actual.getEffectiveDate());
	}
}
