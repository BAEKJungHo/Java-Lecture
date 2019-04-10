package Oepnchallenge;

import java.time.LocalDate;

public class Employee {

	public int empNo; 
	public String name;
	public Position position;
	public LocalDate date;
	
	public Employee(int empNo, String name, Position position, LocalDate date) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.position = position;
		this.date = date;
	}
	
	
}
