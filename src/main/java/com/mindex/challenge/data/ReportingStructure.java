package com.mindex.challenge.data;

import java.util.List;

public class ReportingStructure {
	private Employee employee;
	
	/**
	 * Reporting Structure Constructor
	 * @param newEmployee
	 */
	public ReportingStructure(Employee newEmployee) {
		this.setEmployee(newEmployee);
	}
	
	/**
	 * Employee setter
	 * @param newEmployee
	 */
	public void setEmployee(Employee newEmployee) {
		this.employee = newEmployee;
	}
	
	/**
	 * Employee getter
	 * @return Employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * Number of Report getter
	 * This field does not come from database, it is computed.
	 * It adds report of the employee and the report of direct report
	 * of the employee
	 * @return
	 */
	public int getNumberOfReport() {
		return computeNumberOfReport(employee.getDirectReports());
	}
	
	/**
	 * Recursive function that compute how many report is in employee.
	 * For each employee in direct report list, check if it has its own
	 * direct report. If it does, recursively check and increment.
	 * @param directReport
	 * @return
	 */
	private int computeNumberOfReport(List<Employee> directReport) {
		int reportSize = 0;
		for (Employee e : directReport) {
			if (e.getDirectReports() != null) {
				computeNumberOfReport(e.getDirectReports());
			}
			reportSize++;
		}
		return reportSize;
	}

}
