import java.util.*;
import java.util.stream.Stream;

public class Employee {

    public Long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, Long age, Long salary){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.salary=salary;
    }
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;
    private Long age;
    private Long salary;

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
                    new Employee("Alice", "AliceLastName", 29L, 70L),
                    new Employee("Bob", "BobLastName", 10L, 80L),
                    new Employee("Charlie", "CharlieLastname", 40L, 120L),
                    new Employee("David", "DavidLastName", 38L, 50L),
                    new Employee("Eve", "EveLastName", 16L, 95L)
            );

            List<Employee> top2Employees = employees.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).limit(2).toList();
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
