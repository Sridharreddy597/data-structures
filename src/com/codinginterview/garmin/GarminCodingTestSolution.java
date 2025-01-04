package company_wise_tests;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GarminCodingTestSolution {

    static class GarminCustomer {

        public String name;
        public Integer dailyActivityCalorieBurnGoal;
        public UUID id = UUID.randomUUID();

        public GarminCustomer(String name, Integer dailyActivityCalorieBurnGoal) {
            this.name = name;
            this.dailyActivityCalorieBurnGoal = dailyActivityCalorieBurnGoal;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum ActivityType {
        Biking,
        Cycling,
        Diving,
        Golfing,
        Hiking,
        Rowing,
        Running,
        Swimming,
        Yoga,
        Walking
    }

    static class Activity {
        public GarminCustomer customer;
        public Integer calories;
        public LocalDate date;
        public ActivityType type;

        public Activity(GarminCustomer customer, Integer calories, LocalDate date, ActivityType type) {
            this.customer = customer;
            this.calories = calories;
            this.date = date;
            this.type = type;
        }
    }

    // Returns the number of days a given customer has met their calorie burn goal. Activities are not guaranteed to match the customer
    public static int getDaysGoalMet(List<Activity> activities, GarminCustomer customer) {
        Map<LocalDate, Integer> caloriesPerDay = new HashMap<>();

        activities.stream().filter(act -> act.customer.equals(customer))
                .forEach(cal -> caloriesPerDay.merge(cal.date, cal.calories, Integer::sum));


        return (int) caloriesPerDay.values().stream().filter(calPerDay -> calPerDay >= customer.dailyActivityCalorieBurnGoal).count();
    }

    public static void main(String[] args) throws Exception {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yy, hh:mm a");
        GarminCustomer customer1 = new GarminCustomer("Sam", 415);
        GarminCustomer customer2 = new GarminCustomer("Jesse", 470);
        GarminCustomer customer3 = new GarminCustomer("Monique", 365);

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(customer1, 428, LocalDate.parse("01/01/21, 10:47 AM", dateFormatter), ActivityType.Walking));
        activities.add(new Activity(customer2, 511, LocalDate.parse("01/01/21, 03:22 PM", dateFormatter), ActivityType.Hiking));
        activities.add(new Activity(customer3, 364, LocalDate.parse("01/01/21, 07:56 PM", dateFormatter), ActivityType.Cycling));
        activities.add(new Activity(customer1, 269, LocalDate.parse("01/02/21, 05:40 AM", dateFormatter), ActivityType.Yoga));
        activities.add(new Activity(customer3, 366, LocalDate.parse("01/02/21, 04:04 PM", dateFormatter), ActivityType.Running));
        activities.add(new Activity(customer1, 147, LocalDate.parse("01/02/21, 06:49 PM", dateFormatter), ActivityType.Swimming));
        activities.add(new Activity(customer1, 313, LocalDate.parse("01/03/21, 09:43 AM", dateFormatter), ActivityType.Rowing));
        activities.add(new Activity(customer2, 572, LocalDate.parse("01/03/21, 09:57 AM", dateFormatter), ActivityType.Running));
        activities.add(new Activity(customer1, 476, LocalDate.parse("01/05/21, 11:38 AM", dateFormatter), ActivityType.Walking));
        activities.add(new Activity(customer2, 364, LocalDate.parse("01/05/21, 02:43 PM", dateFormatter), ActivityType.Biking));
        activities.add(new Activity(customer3, 488, LocalDate.parse("01/05/21, 04:26 PM", dateFormatter), ActivityType.Diving));
        activities.add(new Activity(customer1, 407, LocalDate.parse("01/06/21, 06:37 AM", dateFormatter), ActivityType.Running));
        activities.add(new Activity(customer2, 451, LocalDate.parse("01/06/21, 03:45 PM", dateFormatter), ActivityType.Running));
        activities.add(new Activity(customer3, 368, LocalDate.parse("01/06/21, 06:09 PM", dateFormatter), ActivityType.Walking));
        activities.add(new Activity(customer3, 273, LocalDate.parse("01/07/21, 11:59 PM", dateFormatter), ActivityType.Yoga));
        activities.add(new Activity(customer1, 309, LocalDate.parse("01/08/21, 07:29 AM", dateFormatter), ActivityType.Rowing));
        activities.add(new Activity(customer3, 493, LocalDate.parse("01/08/21, 10:34 AM", dateFormatter), ActivityType.Golfing));
        activities.add(new Activity(customer2, 299, LocalDate.parse("01/08/21, 08:34 PM", dateFormatter), ActivityType.Walking));

        Map<GarminCustomer, Integer> testCases = new HashMap<>();
        testCases.put(customer1, 3);
        testCases.put(customer2, 2);
        testCases.put(customer3, 4);

        for (GarminCustomer customer : testCases.keySet()) {
            Integer expectedDaysMet = testCases.get(customer);
            Integer resultingDaysMet = getDaysGoalMet(activities, customer);
            if (!Objects.equals(expectedDaysMet, resultingDaysMet)) {
                throw new Exception();
            } else {
                System.out.println("success");
            }
        }
        System.out.println("Success!");
    }
}

