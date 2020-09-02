package com.mindex.challenge.data;

public class Compensate {
	private Employee employee;
	private String employeeId;
	private int salary;
	private String effectiveDate; // Depending on the usage this can use different class such as Date class
						  // In this case, for the simplicity sake, it is just String
	
	/**
	 * Compensate constructor
	 */
	public Compensate () {
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
	 * Employee Id setter. To be safe this can also be omitted 
	 * and only be set when employee is set
	 * @param newEmployeeId
	 */
	public void setEmployeeId(String newEmployeeId) {
		this.employeeId = newEmployeeId;
	}
	
	/**
	 * Employee Id getter
	 * @return String
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * Salary setter
	 * @param newSalary
	 */
	public void setSalary(int newSalary) {
		this.salary = newSalary;
	}
	
	/**
	 * Salary getter
	 * @return int
	 */
	public int getSalary() {
		return salary;
	}
	
	/**
	 * Effective Date setter.
	 * For sake of simplicity, it takes String as effective date.
	 * @param newEffectiveDate
	 */
	public void setEffectiveDate(String newEffectiveDate) {
		this.effectiveDate = newEffectiveDate;
	}
	
	/**
	 * Effective Date getter
	 * @return String
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}
	
}
