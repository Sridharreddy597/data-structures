import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lab2HelloWorld {
    public static void main(String[] args) {
        System.out.println("Please enter following values");
        Scanner myObj = new Scanner(System.in);

//        System.out.println("Enter first name:");
//        String fristName = myObj.nextLine();
//
//        System.out.println("Enter Second name:");
//        String secondName = myObj.nextLine();
//
//        System.out.println("Enter age :");
//        String age = myObj.nextLine();
//        int ageInt=0;
//        try{
//            ageInt = Integer.parseInt(age);
//        }
//        catch(Exception e){
//            System.out.println("Please enter a valid age");
//            ageInt= Integer.parseInt(myObj.nextLine());
//        }
//        System.out.println("First Name: " + fristName);
//        System.out.println("Second Name: " + secondName);
//        System.out.println("Age: " + ageInt);

//        (Sample input: [Jithin, Arunima, Akhil, Matthew, Benjamin]
//         Sample output: [Akhil, Jithin, Matthew, Arunima, Benjamin])
        List<String> list = Arrays.asList("Jithin", "Arunima", "Akhil", "Matthew", "Benjamin");
        list.sort((e1, e2) -> (e1.length() > e2.length()) ? 1 : -1);
        System.out.println(list);
    }



}
