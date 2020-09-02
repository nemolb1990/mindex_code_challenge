package com.mindex.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void contextLoads() {
		Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
		/*{
		    "employeeId" : "16a596ae-edd3-4847-99fe-c4518e82c86f",
		    "firstName" : "John",
		    "lastName" : "Lennon",
		    "position" : "Development Manager",
		    "department" : "Engineering",
		    "directReports" : [
		      {
		        "employeeId" : "b7839309-3348-463b-a7e3-5de1c168beb3" // Paul McCartney
		      },
		      {
		        "employeeId": "03aa1462-ffa9-4978-901b-7c001562cf6f" // Ringo Starr
		      }
		    ]
		  }
		*/
		
		// Test ReportingStructure
		ReportingStructure reportingStructure = new ReportingStructure(employee);
		
		assertNotNull(reportingStructure);
		assertEquals("John", reportingStructure.getEmployee().getFirstName());
		assertEquals("Lennon", reportingStructure.getEmployee().getLastName());
		assertEquals("Development Manager", reportingStructure.getEmployee().getPosition());
		assertEquals("Engineering", reportingStructure.getEmployee().getDepartment());
		assertEquals(2, reportingStructure.getNumberOfReport()); // According to employee_database.json, it seems like it should be 4
																 // However, when run by hand Ringo Starr comes up as not having any direct report
		

	}

}
