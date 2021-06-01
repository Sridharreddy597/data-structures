package com.java8features.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sridhar
 *
 */
public class EmployeeHighestSalaries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> employees = getEmployees();

		// No of male and female employees present
		employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
				.forEach((key, value) -> System.out.println(key + "  " + value));

		System.out.println(employees.stream().filter(e -> "manager".equalsIgnoreCase(e.designation))
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get());

		System.out.println("--------------------All departments------------------------------------------");
		// Print the name of all departments in the organization
		employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		// average age of male and female employees
		System.out.println("--------------------Average age of male and female employees-----------------");
		employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)))
				.forEach((key, value) -> System.out.println(key + "  " + value));

		// Get the details of highest paid employee in the organization
		System.out.println("-------------------highest paid employee-----------------");
		employees.stream()
		//		.sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.groupingBy(Employee::getSalary)) // .forEach((key, value)-> System.out.println(key+"
																		// "+ value));
				.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.flatMap(e -> e.getValue().stream().sorted(Comparator.comparing(Employee::getId)))
				.collect(Collectors.toList()).forEach(System.out::println);
				//.flatMap(e->e.getValue().stream().sorted(Employee::getId)));		

		// Get the names of all employees who have joined after 2015?
		System.out.println("-------------------names of all employees who have joined after 2015-----------------");
		employees.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

		// Count the number of employees in each department
		System.out.println("-------------------Count the number of employees in each department-----------------");
		employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
				.forEach((key, value) -> System.out.println(key + "  " + value));

		// Average salary of each department
		System.out.println("-------------------Average salary of each department------------------------------");
		employees.stream()
				.collect(
						Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
				.forEach((key, value) -> System.out.println(key + "  " + value));

		// Get the details of youngest male employee in the product development
		// department
		System.out.println(
				"----------Get the details of youngest male employee in the product development department-----------------");
		System.out.println(employees.stream()
				.filter(e -> "male".equalsIgnoreCase(e.getGender())
						&& "Product Development".equalsIgnoreCase(e.getDepartment()))
				.min(Comparator.comparing(Employee::getAge)).get());

		// Who has the most working experience in the organization
		System.out.println("----------most working experience in the organization-----------------");
		System.out.println(employees.stream().min(Comparator.comparing(Employee::getYearOfJoining)).get());

		// How many male and female employees are there in the sales and marketing team
		System.out.println(
				"----------No of male and female employees are there in the sales and marketing team-----------------");
		employees.stream().filter(e -> "sales and marketing".equalsIgnoreCase(e.getDepartment()))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
				.forEach((key, value) -> System.out.println(key + "  " + value));

		// average salary of male and female employees
		System.out.println("----------average salary of male and female employees-----------------");
		employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)))
				.forEach((key, value) -> System.out.println(key + "  " + value));

		// List down the names of all employees in each department?
		System.out.println("----------List down the names of all employees in each department-----------------");
		employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))
				.forEach((key, value) -> System.out.println(key + "  " + value));

		// What is the average salary and total salary of the whole organization
		System.out.println("----------average salary and total salary of the whole organization-----------------");
		System.out.println(
				" Average salary : " + employees.stream().collect(Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(" Total salary : "
				+ employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary)).getSum());

		// Separate the employees who are younger or equal to 25 years from those
		// employees who are older than 25 years.
		System.out.println(
				"----------Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years-----------------");
		employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25))
				.forEach((key, value) -> System.out.println(key + "  " + value));

		// Who is the oldest employee in the organization? What is his age and which
		// department he belongs to?
		System.out.println("----------oldest employee in the organization-----------------");

		Employee e = employees.stream().max(Comparator.comparing(Employee::getAge)).get();
		System.out.println("Name :" + e.getName());
		System.out.println("Age :" + e.getAge());
		System.out.println("Department :" + e.getDepartment());

	}

	private static List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0, "associate"));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0, "manager"));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0, "associate"));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 13500.0, "manager"));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0, "manager"));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0, "associate"));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0, "associate"));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0, "manager"));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0, "associate"));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 34500.5, "manager"));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0, "associate"));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0, "manager"));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0, "associate"));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5, "associate"));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 28200.0, "manager"));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0, "associate"));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0, "manager"));
		employeeList.add(new Employee(276, "Ajay  Chopra", 33, "Male", "Product Development", 2012, 35700.0, "manager"));

		return employeeList;
	}

	boolean isManager(Employee employee) {
		return "manager".equalsIgnoreCase(employee.getDesignation());
	}

}
