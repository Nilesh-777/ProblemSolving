package com.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeExample2Practice {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "John", 100L, "IT");
		Employee e2 = new Employee(2, "Snow", 200L, "HR");
		Employee e3 = new Employee(3, "Rohit", 300L, "IT");
		Employee e4 = new Employee(4, "Virat", 400L, "HR");
		Employee e5 = new Employee(5, "SKY", 500L, "IT");

		List<Employee> empList = Arrays.asList(e1, e2, e3, e4, e5);

		// 1. -> Print Highest paid employee from each department.
		highestSalaryPerDepartment(empList);
		
		// 2. -> Print distinct department.
		distinctDepartments(empList);

		// 3. -> Count of employees from each department.
		employeeCountPerDepartment(empList);

		// 4. -> Average salary of IT & HR employees.
		avgSalaryPerDepartment(empList);

		// 5. -> Print List of employees in sorted salary in desc order.
		employeesBySalaryDesc(empList);
		

		// 6. Highest Salary
		highestSalary(empList);

		// 7. Second highest salary overall
		secondHighestSalaryUsingSorting(empList);
		secondHighestSalary(empList);

	}

	private static void employeesBySalaryDesc(List<Employee> empList) {
		List<Employee> empListAsPerSalary = empList.stream()
		.sorted((emp1, emp2) -> emp2.getEsalary() > emp1.getEsalary() ?  1 : -1)
		.toList();
		System.out.println("Employees  as per salary desc: "+ emp);
	}

	private static void avgSalaryPerDepartment(List<Employee> empList) {
		Map<String, Double> avgSalaryPerDep = empList.stream()
		.collect(Collectors.groupingBy(emp ->emp.getEdept(), Collectors.mapping(emp -> emp.getEsalary(), Collectors.averagingDouble(sal -> Double.valueOf(sal)))));
		System.out.println("Avg salary per department: " + avgSalaryPerDep);
	}

	private static void employeeCountPerDepartment(List<Employee> empList) {
		Map<String, Integer> employeeCountPerDep = empList.stream()
		.collect(Collectors.toMap(emp -> emp.getEdept(), emp -> 1, (prev, next) -> prev + next));
		System.out.println("Employee Count per department " + employeeCountPerDep);

		Map<String, Long> employeeCountPerDep2 = empList.stream()
		.collect(Collectors.groupingBy(emp -> emp.getEdept(), Collectors.counting()));
		System.out.println("Employee Count per department " + employeeCountPerDep2);
	}

	private static void distinctDepartments(List<Employee> empList) {
		List<String> distinctDepartments = empList.stream()
		.map(emp -> emp.getEdept())
		.distinct()
		.toList();
		System.out.println("Distinct Departments: " + distinctDepartments);
	}

	private static void highestSalaryPerDepartment(List<Employee> empList) {
		Map<String, Long> higestSalaryPerDepartment = empList.stream()
		.collect(Collectors.toMap(emp -> emp.getEdept(), emp -> emp.getEsalary(), (prev, next) -> prev >= next ? prev : next));
		System.out.println("Higest Salary per Department: " + higestSalaryPerDepartment);
		
		Map<Object, Optional<Long>> higestSalaryPerDepartment2 = empList.stream()
		.collect(Collectors.groupingBy(emp -> emp.getEdept(), Collectors.mapping(emp -> emp.getEsalary(), Collectors.maxBy(Long::compare))));
		System.out.println("Higest Salary per Department: " + higestSalaryPerDepartment2);

	}

	private static void highestSalary(final List<Employee> empList) {
		Integer maxSalary = empList.stream().map(Employee::getEsalary).map(Long::intValue)
				.max((salary1, salary2) -> salary1 - salary2).orElse(0);

		System.out.println("Max Salary: " + maxSalary);
	}

	private static void secondHighestSalary(final List<Employee> empList) {
		Integer maxSalary = empList.stream()
				.map(Employee::getEsalary)
				.map(Long::intValue)
				.distinct()
				.max((salary1, salary2) -> salary1 - salary2)
				.orElse(0);

		Integer secondMaxSalary = empList.stream()
				.map(Employee::getEsalary)
				.map(Long::intValue)
				.distinct()
				.filter(salary -> salary < maxSalary)
				.max((salary1, salary2) -> salary1 - salary2)
				.orElse(0);

		System.out.println("Second Max Salary: " + secondMaxSalary);
	}
	
	private static void secondHighestSalaryUsingSorting(final List<Employee> empList) {
		Integer secondMaxSalary = empList.stream()
				.map(Employee::getEsalary)
				.map(Long::intValue)
				.distinct()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.limit(1)
				.findFirst()
				.orElse(0);

		System.out.println("Second Max Salary Using Sorting: " + secondMaxSalary);
	}


}
