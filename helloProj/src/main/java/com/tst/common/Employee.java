package com.tst.common;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private int salary;
	private Date hireDate;
	private String jobId;

	@Override
	public String toString() {
		return this.employeeId + " " + this.firstName + " " + this.lastName + " " + this.salary + " " + this.email;
	}

}
