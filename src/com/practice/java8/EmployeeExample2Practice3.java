package com.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeExample2Practice3 {
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
		List<Employee> list = empList.stream()
		.sorted((emp1, emp2) -> emp1.getEsalary() < emp2.getEsalary() ? 1: -1)
		.toList();
		System.out.println("Desc: " + list);
	}

	private static void avgSalaryPerDepartment(List<Employee> empList) {
		Map<String, Double> collect = empList.stream()
				.collect(Collectors.groupingBy(Employee::getEdept, Collectors.mapping(Employee::getEsalary, Collectors.averagingLong(s -> s))));
			System.out.println("avg salary per dept: " + collect);
	}

	private static void employeeCountPerDepartment(List<Employee> empList) {
		Map<String, Long> collect = empList.stream()
			.collect(Collectors.groupingBy(Employee::getEdept, Collectors.counting()));
		System.out.println("employee per dept: " + collect);
	}

	private static void distinctDepartments(List<Employee> empList) {
		List<String> list = empList.stream()
		.map(Employee::getEdept)
		.distinct()
		.toList();
		System.out.println("Deps "+ list);
	}

	private static void highestSalaryPerDepartment(List<Employee> empList) {
		Map<String, Optional<Long>> collect = empList.stream().collect(Collectors.groupingBy(Employee::getEdept,
				Collectors.mapping(Employee::getEsalary, Collectors.maxBy((s1, s2) -> s1 > s2 ? 1 : -1))));
		System.out.println(collect);
	}

	private static void highestSalary(final List<Employee> empList) {
		long maxSalary = empList.stream()
		.map(Employee::getEsalary)
		.max((s1, s2) -> s1 > s2 ? 1 : -1)
		.orElse(0L);
		
		System.out.println("Max Salary: " + maxSalary);
	}

	private static void secondHighestSalary(final List<Employee> empList) {
	}

	private static void secondHighestSalaryUsingSorting(final List<Employee> empList) {
		Long secondMaxSal = empList.stream()
		.map(Employee::getEsalary)
		.sorted(Comparator.reverseOrder())
		.skip(1)
		.limit(1)
		.findFirst()
		.orElse(0L);
		System.out.println("Second max salary: " + secondMaxSal);
	}

}
