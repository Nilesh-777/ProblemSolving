package com.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
	private Integer eid;
	private String ename;
	private Long esalary;
	private String edept;

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", edept=" + edept + "]";
	}

	public Employee(Integer eid, String ename, Long esalary, String edept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.edept = edept;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Long getEsalary() {
		return esalary;
	}

	public void setEsalary(Long esalary) {
		this.esalary = esalary;
	}

	public String getEdept() {
		return edept;
	}

	public void setEdept(String edept) {
		this.edept = edept;
	}

}

public class EmployeeExample {
	public static void main(String[] args) {
		EmployeeClass e1 = new EmployeeClass(1, "John", 100000L, "IT");
		EmployeeClass e2 = new EmployeeClass(2, "Snow", 900000L, "HR");
		EmployeeClass e3 = new EmployeeClass(3, "Rohit", 15000L, "IT");
		EmployeeClass e4 = new EmployeeClass(4, "Virat", 150000L, "HR");
		EmployeeClass e5 = new EmployeeClass(5, "SKY", 1000L, "IT");

		List<EmployeeClass> emplist = Arrays.asList(e1, e2, e3, e4, e5);
		// Print Highest paid employee from each department
//		 Map<City, Set<String>> namesByCity
//		   = people.stream().collect(
//		     groupingBy(Person::getCity,
//		                TreeMap::new,
//		                mapping(Person::getLastName,
//		                        toSet())));

		// 1. -> Print Highest paid employee from each department.
		Map<String, EmployeeClass> highestPaidEmployees = emplist.stream().collect(Collectors.toMap(EmployeeClass::getEdept,
				employee -> employee,
				(existing, replacement) -> existing.getEsalary() >= replacement.getEsalary() ? existing : replacement));

		Map<String, Optional<EmployeeClass>> hpe = emplist.stream().collect(Collectors.groupingBy(EmployeeClass::getEdept,
				Collectors.minBy(Comparator.comparingLong(EmployeeClass::getEsalary))));
		System.out.println(hpe);

		// 2. -> Print distinct department.
		List<String> list = emplist.stream().map(EmployeeClass::getEdept).distinct().toList();
		System.out.println(list);

		// 3. -> Count of employees from each department.
		Map<String, Long> deptToCountMap = emplist.stream()
				.collect(Collectors.groupingBy(EmployeeClass::getEdept, Collectors.counting()));
		System.out.println(deptToCountMap);

//		4. -> Average salary of IT & HR employees.
		Map<String, Double> deptToAvgSalaryMap = emplist.stream()
				.collect(Collectors.groupingBy(EmployeeClass::getEdept, Collectors.averagingLong(emp -> emp.getEsalary())));
		System.out.println(deptToAvgSalaryMap);

		// 5. -> Print List of integers in sorted order.
		emplist.sort(Comparator.comparingLong(EmployeeClass::getEsalary).reversed());
		System.out.println(emplist.get(1));

	}

}
