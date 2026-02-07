package com.infy.collectorp;

import java.util.List;
import java.util.stream.Collectors;

public class Employee {
	
	private String dept;
	private int salary;
	public Employee(String dept, int salary) {
		this.dept = dept;
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
        public static void main(String[] args) {
        	List<Employee> employees = List.of(
        		    new Employee("IT", 50000),
        		    new Employee("IT", 60000),
        		    new Employee("HR", 30000),
        		    new Employee("HR", 40000),
        		    new Employee("Finance", 70000)
        		);
        	
        	
        	employees.stream()
        	.collect(
        			
        			Collectors.groupingBy(
        					Employee :: getDept,
        					  Collectors.summingInt(Employee :: getSalary)
                                        					
        					)
        			
        			).forEach((k,v)-> System.out.println(k + " "  + v));

		}
}
