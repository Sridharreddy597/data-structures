package com.java8features.streams;

import java.util.*;
import java.util.stream.Stream;

class Employee
{
    private String firstName;
    private String lastName;
    private Long age;
    private Double salary;
    String name;
    String gender;
    int id;
    String department;
    int yearOfJoining;
    String designation;

    public Employee(String firstName, String lastName, Long age, Double salary){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.salary=salary;
    }
    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, Double salary, String designation) {
        this.id = id;
        this.name = name;
        this.age = (long) age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.designation=designation;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + ", designation="
				+ designation + "]";
	}


    @Override
    public int hashCode(){
        int result = 17;
        result = 31*result+firstName.hashCode();
        result = 32*result+lastName.hashCode();
        return result;
    }

    public boolean equals(Object obj){
        if(this == obj) return  true;
        if(obj==null || getClass()!= obj.getClass()) return false;
        Employee other =  (Employee) obj;
        return ( (other.age == age)
                && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName,other.lastName));

    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "AliceLastName", 29L, 70d),
                new Employee("Bob", "BobLastName", 10L, 80d),
                new Employee("Charlie", "CharlieLastname", 40L, 120d),
                new Employee("David", "DavidLastName", 38L, 50d),
                new Employee("Eve", "EveLastName", 16L, 95d)
        );

        List<Employee> top2Employees = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(2).toList();
        System.out.println("Top 2 Employees: " + top2Employees);

        // Initial stream
        Stream<Integer> stream = Stream.of(2, 17, 5,20, 17, 30,4, 23, 59, 23);
        // find duplicates
        Set<Integer> set = new HashSet<>();
        stream.filter(e-> !set.add(e)).forEach(System.out::println);

        //Count occurrence of a given character in a string using Stream API in Java.
        // String str = "geeksforgeeks";
        //        char c = 'g';
        String str = "geeksforgeeks"; char c ='e';
        System.out.println(str.chars().filter(ch-> ch==c).count());
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        str = "geeksforgeeks";
        str.chars().forEach(e->map.merge((char) e,1, Integer::sum));
        map.forEach((key, value) -> System.out.println("key: "+key+" ::  value:"+value));
    }


}