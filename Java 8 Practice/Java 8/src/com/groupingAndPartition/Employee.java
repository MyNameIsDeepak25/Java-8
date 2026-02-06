package com.groupingAndPartition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Employee {

	int id;
    String name;
    String department;
    String gender;
    int salary;
	public Employee(int id, String name, String department, String gender, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.gender = gender;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", gender=" + gender
				+ ", salary=" + salary + "]";
	}
	
	
	//get By Department
	public static Map<String, List<Employee>> getByDepartMent(List<Employee> list){
		return list.stream().collect(
				
				Collectors.groupingBy(Employee :: getDepartment)
				
				);
				
				
	}
	
	
	//Get by Gender
	public static Map<String, List<Employee>> getByGender(List<Employee> list){
		return list.stream().collect(
				
				Collectors.groupingBy(Employee :: getGender)
				
				);
												
	}
	
	
//	Group employees by salary range
//
//	"LOW" → salary < 30,000
//
//	"MID" → 30,000 – 60,000
//
//	"HIGH" → > 60,000
	public static Map<String, List<Employee>> getBySalary(List<Employee> list){
		return list.stream().collect(
				
				Collectors.groupingBy(
						
						e->e.getSalary()<=30000?"LOW":
								
						e.getSalary()<=60000?"MID":"HIGH"
						
						
						
						)
				
				);				
				
				
	}
	
//	
//	Group employees by department
//	and count employees in each department
//
	
	public static Map<String, Long> getByDeptAndCount(List<Employee> list){
		return list.stream().collect(
				
				Collectors.groupingBy(
						Employee :: getDepartment,
						Collectors.counting()
						
						
						)
				
				
				);
	}
	
	
//	Group employees by department
//	and calculate average salary per department
//	
	public static Map<String, Double> getAverageSalaryPerDepartMent(List<Employee> list){
		return list.stream().collect(
				
				Collectors.groupingBy(
						Employee :: getDepartment,
						Collectors.averagingDouble(Employee::getSalary)
						
						
						)
				
				
				);
				
				
	}
	
//	
//	Group employees by department
//	and get total salary per department
//	
	
	public static Map<String, Integer> getTotalSalaryPerDepartment(List<Employee> list){
		return list.stream().collect(
				
				Collectors.groupingBy(
						Employee :: getDepartment,
						
						
						Collectors.summingInt(Employee :: getSalary)
						
						
						)
				
				
				);
				
				
	}
	
	
//	Group employees by department
//	and store employee names only (not Employee objects)
//	
	public static Map<String, List<String>> getByNames(List<Employee> list){
		return list.stream().collect(
				
				Collectors.groupingBy(
						
						Employee :: getDepartment,
						Collectors.mapping(Employee :: getName, 
								
								Collectors.toList()
								)
						
						
						
						)
				
				
				
				);
				
	}
	
	
//	Group employees by department
//	but store result as a Set
	
	public static Map<String, Set<Employee>> getByDept(List<Employee> list){
		return list.stream().collect(
				Collectors.groupingBy(
						Employee :: getDepartment ,
						Collectors.toSet()
						
						)
				
				);
	}
    public static void main(String[] args) {
    	List<Employee> employees = List.of(
    		    new Employee(1,  "Amit",    "IT", "Male",   55000),
    		    new Employee(2,  "Neha",    "IT", "Female", 60000),
    		    new Employee(3,  "Rahul",   "HR", "Male",   35000),
    		    new Employee(4,  "Pooja",   "HR", "Female", 40000),
    		    new Employee(5,  "Suresh",  "IT", "Male",   75000),
    		    new Employee(6,  "Kavita",  "Sales", "Female", 30000),
    		    new Employee(7,  "Ramesh",  "Sales", "Male",   45000),
    		    new Employee(8,  "Sneha",   "Sales", "Female", 65000),
    		    new Employee(9,  "Anil",    "Finance", "Male", 50000),
    		    new Employee(10, "Meena",   "Finance", "Female", 70000)
    		);
    	
    	
 	getByDepartMent(employees).forEach(
 			(dept,employee)->System.out.println(dept + " " + employee )
 			
 			);
//        System.out.println(getByGender(employees));
//        System.out.println(getBySalary(employees));
//     
    	
 //   System.out.println(getAverageSalaryPerDepartMent(employees));
      Map<String, Long>  result=getByDeptAndCount(employees);
      for (Map.Entry<String, Long> employee : result.entrySet()) {
		System.out.println(employee.getKey() + " "  + employee.getValue());
	}
      
      
      Map<String, Double> result2 = getAverageSalaryPerDepartMent(employees);

      result2.forEach((dept, avg) ->
          System.out.println(dept + " -> " + String.format("%.2f", avg))
      );
    	
      
      Map<String, Integer> result3=getTotalSalaryPerDepartment(employees);
      result3.forEach(
    		  
    		  (dept,sum)->
    		  System.out.println(dept+ "-> " + sum)
    		  );
      
      Map<String, List<String>> result4=getByNames(employees);
      result4.forEach(
    		  
    		  (dept,name)->
    		  System.out.println(dept+ "-> " + name)
    		  );
      
      Map<String, Set<Employee>> result5=getByDept(employees);
      result5.forEach(
    		  
    		  (dept,name)->
    		  System.out.println(dept+ "-> " + name)
    		  );
      
	}
	
}
