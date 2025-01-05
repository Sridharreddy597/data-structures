package com.java8features.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
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
    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = (long) age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
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

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //1. Find out the count of male and female employees present in the organization?
        /*Map<String, Integer> noOfMaleFemale = new HashMap<>();
        employeeList.forEach(e-> noOfMaleFemale.merge(e.getGender(),1, Integer::sum));
        noOfMaleFemale.forEach((key, value) -> System.out.println("key : " + key + " ::  value: " + value));
       */
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).forEach((key, value) -> System.out.println("key : " + key + " ::  value: " + value));

        //2. Write a program to print the names of all departments in the organization.
        employeeList.stream().map(Employee::getDepartment).distinct().toList().forEach(System.out::println);

        //3. Find the average age of Male and Female Employees.
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge))).forEach((key, value) -> System.out.println("key : " + key + " ::  value: " + value));

        //4. Get the Names of employees who joined after 2015.
        employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

        //5. Count the number of employees in each department.
        Map<String, Long> countByDept = employeeList.stream()
                .collect(Collectors.groupingBy
                        (Employee::getDepartment,
                                Collectors.counting()));
        employeeList.stream().
                collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((key, value) -> System.out.println(key + " -> " + value));

        //6. Find out the average salary of each department.
        System.out.println("Find out the average salary of each department.");
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))).forEach((key, value) -> System.out.println(key + " -> " + value));


        //7. Find out the oldest employee, his/her age and department?
        System.out.println("Find out the oldest employee, his/her age and department");
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingLong(Employee::getAge)))).forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("---Find out the oldest employee, his/her age and department");
        employeeList.stream().max(Comparator.comparingLong(Employee::getAge)).ifPresent(System.out::println);

        //8. Find out the average and total salary of the organization.
        System.out.println("average and total salary of the organization.");
        DoubleSummaryStatistics summaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary = " + summaryStatistics.getAverage());
        System.out.println("Total Salary = " + summaryStatistics.getSum());

        //9. List down the employees of each department.
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((key, value) -> System.out.println(key + " -> " + value));

        //10. Find out the highest experienced employees in the organization
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).limit(1).forEach(System.out::println);

        //1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 3, 9, 2, 4, 6, 10, 13));
        numbers.stream().filter(n -> n % 2 == 0).toList().forEach(System.out::println);
        //2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        System.out.println("----numbers starts with 1-----");
        numbers.stream().map(e -> e + "").filter(e -> e.startsWith("1")).toList().forEach(System.out::println);
        //3. How to find duplicate elements in a given integers list in java using Stream functions?
        System.out.println("----duplicate elements-----");
        Set<Integer> set1 = new HashSet<>();
        numbers.stream().filter(e -> !set1.add(e)).forEach(System.out::println);
        System.out.println("----non duplicate elements-----");
        numbers.stream().distinct().forEach(e -> System.out.print(e + ","));
        System.out.println();
        //4. Given the list of integers, find the first element of the list using Stream functions?
        System.out.println("----first element-----");
        numbers.stream().findFirst().ifPresent(System.out::println);
        //5. Given a list of integers, find the total number of elements present in the list using Stream functions?
        System.out.println("----total number of elements ----");
        Long l = numbers.stream().count();
        System.out.println(l);
        //6. Given a list of integers, find the maximum value element present in it using Stream functions?
        System.out.println("----maximum value----");
        numbers.stream().max(Comparator.comparingInt(e -> e)).ifPresent(System.out::println);
        //7. Given a String, find the first non-repeated character in it using Stream functions?
        System.out.println("----non-repeated character----");
        String input = "Java articles are Awesome";
        Character s = input.chars().mapToObj(e -> Character.toLowerCase((char) e)).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).firstEntry().getKey();
        System.out.println(s);
        //8. Given a String, find the first repeated character in it using Stream functions?
        System.out.println("----first repeated character----");
        input.chars().mapToObj(e -> Character.toLowerCase((char) e))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1L).findFirst().ifPresent(System.out::println);

        //9. Given a list of integers, sort all the values present in it using Stream functions?
        System.out.println("----sort---");
        numbers.stream().sorted().forEach(e -> System.out.print(e + ","));
        System.out.println();

        //10. Given a list of integers, sort all the values present in it in descending order using Stream functions?
        numbers.stream().sorted(Collections.reverseOrder()).forEach(e -> System.out.print(e + ","));
        //11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
        numbers.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).findFirst();
        Set<Integer> setData = new HashSet<>();
        numbers.stream().anyMatch(num -> !setData.add(num));
        //12. How will you get the current date and time using Java 8 Date and Time API?


        //13. Write a Java 8 program to concatenate two Streams?
        List<Integer> nums = new ArrayList<>(Arrays.asList(99, 66, 55, 88, 33));
        Stream.concat(numbers.stream(), nums.stream());

        //14. Java 8 program to perform cube on list elements and filter numbers greater than 50.
        System.out.println();
        System.out.println("perform cube on list elements");
        numbers.stream().map(a -> a * a * a).filter(a -> a > 50).forEach(e -> System.out.print(e + ","));

        //15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
        System.out.println();
        System.out.println("sort an array and then convert the sorted array into Stream");
        Stream.of(numbers.stream().sorted()).toList().forEach(e -> System.out.print(e + ","));
        //16. How to use map to convert object into Uppercase in Java 8?
        List<String> strs = new ArrayList<>(Arrays.asList("sddsf", "sdfdsfds", "dsfdsfsd"));
        System.out.println();
        System.out.println("map to convert object into Uppercase");
        strs.stream().map(String::toUpperCase).forEach(e -> System.out.print(e + ","));

        //17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1L, "note1", 11L));
        noteLst.add(new Notes(2L, "note2", 22L));
        noteLst.add(new Notes(3L, "note3", 33L));
        noteLst.add(new Notes(4L, "note4", 44L));
        noteLst.add(new Notes(5L, "note5", 55L));
        noteLst.add(new Notes(6L, "note4", 66L));




        //18. How to count each element/word from the String ArrayList in Java8?

        strs.add("sddsf");
        strs.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().forEach(e -> System.out.print(e.getKey() + "="+e.getValue()+"\n"));

        //19. How to find only duplicate elements with its count from the String ArrayList in Java8?
        System.out.println("only duplicate elements with its count------");
        strs.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(x->x.getValue()>1).forEach(e -> System.out.print(e.getKey() + "="+e.getValue()+"\n"));
        //20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
        Optional.of(noteLst).orElseGet(Collections::emptyList).stream().filter(Objects::nonNull).forEach(e->System.out.println(e.tagId+" "+e.tagName));
        //21. Write a Program to find the Maximum element in an array?
        System.out.println(numbers.stream().max(Comparator.comparingInt(e->e)).get());
        //22. Write a program to print the count of each character in a String?
        Map<Character, Integer> characterCount = new HashMap<>();
        String ss = "string data to count each character";

        ss.chars().forEach(e-> characterCount.merge((char) e, 1, Integer::sum));
        characterCount.forEach((key, value) -> System.out.print(key + "=" + value + "\n"));
    }
}


class Notes{
    public  Long id;
    public Long tagId;
    public  String tagName;

    public Notes(Long id, String tagName,  Long tagId) {
        this.id = id;
        this.tagId = tagId;
        this.tagName = tagName;
    }


}