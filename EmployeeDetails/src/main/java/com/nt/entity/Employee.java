package com.nt.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "EMPLOYEE_DETAILS")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer EmployeeID;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "Email")
	private String Email;
	@Column(name = "phoneNumber")
	private Long phoneNumbers;
	@Column(name = "Doj")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Doj;
	@Column(name = "Salary")
	private Double Salary;
	@Column(name = "tax")
	private Double tax;

	
	  
	  public Employee(Integer employeeID2, String firstName2, String lastName2,
	  double totalSalary, int tax, int cess, double lossOfPayPerDay) { }
	  
	  public Integer getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Long getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Long phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public LocalDate getDoj() {
		return Doj;
	}

	public void setDoj(LocalDate doj) {
		Doj = doj;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Employee(Integer employeeID, String firstName, String lastName, String email, Long phoneNumbers,
			LocalDate doj, Double salary, Double tax) {
		super();
		EmployeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
		this.phoneNumbers = phoneNumbers;
		Doj = doj;
		Salary = salary;
		this.tax = tax;
	}
}
