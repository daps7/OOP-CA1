
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.io. * ;
import java.sql.SQLOutput;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        String fileName = "titanic-data-100.txt"; // file should be in the project folder (below pom.xml)

        ArrayList<Passenger> passengerList= new ArrayList<>();

        loadPassengerDataFromFile( passengerList, fileName);

//        displayAllPassengers( passengerList );


        // Assignment: Implement and test the following methods
//            getPassengerNames(passengerList);
//            getPassengersContainingName( passengerList, fileName);
//            getPassengersOlderThan(passengerList);
//            countPassengersByGender(passengerList);
//                sumFares(passengerList);
//                maleSurvivors(passengerList);
//        ticketOwner(passengerList);
//        averageAge(passengerList);
//            getPassengersByTicketClass(passengerList);
//            sortPassengersByPassengerId(passengerList);
//            sortPassengersByName(passengerList);
//            sortPassengersByAgeThenName(passengerList);
//        sortPassengersByGenderThenPassengerNumber(passengerList);
//            sortPassengersByFareThenSurvival(passengerList);
//        sortPassengersByTicketClass(passengerList);
//        sortPassengersByAge(passengerList);
//        sortPassengersByTicketNumberLambda(passengerList);
//        sortPassengersByTicketNumberStatic(passengerList);
//        findPassengerByTicketNumber(passengerList, "A/5. 2151");
        findPassengerByPassengerId(passengerList,"22");


    }

    public static void loadPassengerDataFromFile( ArrayList<Passenger> passengerList, String fileName) {

        // Format of each row of data is:
        // Name,Age,Height(m),GPA  - these heading names are included as the first row in file
        // John Malone,20,1.78,3.55   for example

        // Use a Regular Expression to set both comma and newline as delimiters.
        //  sc.useDelimiter("[,\\r\\n]+");
        // Text files in windows have lines ending with "CR-LF" or "\r\n" sequences.
        // or may have only a newline - "\n"
        // Windows uses CRLF (\r\n, 0D 0A) line endings while Unix just uses LF (\n, 0A).
        //
        try (Scanner sc = new Scanner(new File(fileName))
                .useDelimiter("[,\\r\\n]+"))
        {

            // skip past the first line, as it has field names (not data)
            if(sc.hasNextLine())
                sc.nextLine();   // read the header line containing column titles, but don't use it

            // while there is a next token to read....
//            System.out.println("Go...");

            while (sc.hasNext())
            {
                String passengerId = sc.next();    // read passenger ID
                int survived = sc.nextInt();     // 0=false, 1=true
                int passengerClass = sc.nextInt();  // passenger class, 1=1st, 2=2nd or 3rd
                String name = sc.next();
                String gender = sc.next();
                int age = sc.nextInt();
                int siblingsAndSpouses = sc.nextInt();
                int parentsAndChildren = sc.nextInt();
                String ticketNumber = sc.next();
                double fare = sc.nextDouble();
                String cabin = sc.next();
                String embarkedAt = sc.next();

//                System.out.println(passengerId +", " + name);

                passengerList.add(
                        new Passenger( passengerId, survived, passengerClass,
                                name, gender, age, siblingsAndSpouses,parentsAndChildren,ticketNumber,
                                fare, cabin, embarkedAt)
                );
            }
        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }
    }

//    public static void displayAllPassengers( ArrayList<Passenger> passengerList ) {
//        for( Passenger passenger : passengerList)
//        {
//            System.out.println(passenger);
//        }
//    }
//    public static void getPassengerNames(ArrayList<Passenger> passengerList)
//    {
//        for(Passenger passenger : passengerList)
//        {
//            System.out.println("getPassengerNames Method");
//            System.out.println(passenger.getName());
//        }
//    }
//    public static void getPassengersContainingName(ArrayList<Passenger> passengerList,String name)
//    {
//        Scanner kb = new Scanner(System.in);
//        System.out.println("What passenger are you looking for");
//        name = kb.nextLine();
//        for (Passenger passenger : passengerList)
//        {
//            if(passenger.getName().contains(name))
//            {
//                System.out.println(passenger.getName());
//            }
//        }
//    }
//    public static void getPassengersOlderThan(ArrayList<Passenger> passengerList)
//    {
//        Scanner kb =  new Scanner(System.in);
//        System.out.println("What age of passenger are you looking for?");
//        int age = kb.nextInt();
//        for (Passenger passenger: passengerList)
//        {
//           if(passenger.getAge() >= age)
//           {
//               System.out.println(passenger);
//           }
//           else
//           {
//               System.out.println("no passengers are "+age+"on the titanic");
//           }
//        }
//    }
//    public static void countPassengersByGender(ArrayList<Passenger> passengerList)
//    {
//        Scanner kb =  new Scanner(System.in);
//        int counter = 0;
//        System.out.println("What gender are you looking to count?");
//        String gender = kb.nextLine();
//            for (Passenger passenger : passengerList) {
//                if (gender.equalsIgnoreCase(passenger.getGender())) {
//                    counter++;
//                }
//            }
//        System.out.println("There are "+counter+" "+gender+"'s on the titanic");
//    }
//public static void sumFares(ArrayList<Passenger> passengerList)
//{
//    int totalFare = 0;
//    for (Passenger passenger : passengerList)
//    {
//        totalFare += passenger.getFare();
//    }
//    System.out.println(totalFare);
//}
    public static void maleSurvivors(ArrayList<Passenger> passengerList)
    {
     for (Passenger passenger : passengerList)
     {
         if(passenger.getGender().equalsIgnoreCase("Male"))
         {
             System.out.println(passenger);
         }
     }
    }
//        public static void ticketOwner(ArrayList<Passenger> passengerList)
//        {
//            Scanner kb = new Scanner(System.in);
//                System.out.println("What ticket are you looking for?");
//                String ticketNumber = kb.nextLine();
//                for (Passenger passenger : passengerList)
//                {
//                    if (passenger.getTicketNumber().equals(ticketNumber))
//                    {
//                        System.out.println(passenger);
//                    }
//                    else
//                    {
//                        System.out.println("null");
//                        break;
//                    }
//                }
//        }
//public static void averageAge(ArrayList<Passenger> passengerList)
//   {
//   int totalage = 0;
//   int averageage = 0;
//   for(Passenger passenger : passengerList)
//   {
//       totalage += passenger.getAge();
//   }
//   averageage = totalage / passengerList.size();
//       System.out.println(averageage+" is the average age on the titanic.");
//   }

//    public static void getPassengersByTicketClass(ArrayList<Passenger> passengersList) {
//        Scanner kb = new Scanner(System.in);
//        System.out.println("What class of passenger are you looking for? (FIRST, SECOND or THIRD)");
//        try {
//            PassengerClass passengerClass = PassengerClass.valueOf(kb.next().toUpperCase());
//
//            for (Passenger passenger : passengersList) {
//                if (passenger.getPassengerClass() == passengerClass) {
//                    System.out.println(passenger);
//                }
//            }
//        } catch (IllegalArgumentException e) {
//            // Handle invalid class input
//            System.out.println("Invalid passenger class.Please enter FIRST, SECOND or THIRD");
//        }
//    }
//    public static void sortPassengersByPassengerId(ArrayList<Passenger> passengerList)
//    {
//        System.out.println("Passengers sorted by passenger ID");
//        passengerComparatorID IDComparator = new passengerComparatorID();
//        Collections.sort(passengerList, IDComparator);
//        display(passengerList);
//    }
//    public static void sortPassengersByName(ArrayList<Passenger> passengerList)
//    {
//        System.out.println("Passengers sorted by name");
//        PassengerNameComparator NameComparator = new PassengerNameComparator();
//        Collections.sort(passengerList, NameComparator);
//        display(passengerList);
//    }
//    public static void sortPassengersByAgeThenName(ArrayList<Passenger> passengerList)
//    {
//        System.out.println("Passengers sorted by age then name");
//        PassengerAgeThenNameComparator AgeComparator = new PassengerAgeThenNameComparator();
//        Collections.sort(passengerList, AgeComparator);
//        display(passengerList);
//    }
//    public static void sortPassengersByGenderThenPassengerNumber(ArrayList<Passenger> passengerList)
//    {
//        System.out.println("Passengers sorted by passenger number");
//        sortPassengersByGenderThenPassengerNumberComparator GenderComparator = new sortPassengersByGenderThenPassengerNumberComparator();
//        Collections.sort(passengerList, GenderComparator);
//        display(passengerList);
//    }
//    public static void sortPassengersByFareThenSurvival(ArrayList<Passenger> passengerList)
//    {
//        System.out.println("Passengers sorted by fare then survival");
//    sortPassengersByFareThenSurvivalComparator FareComparator = new sortPassengersByFareThenSurvivalComparator();
//    Collections.sort(passengerList, FareComparator);
//    display(passengerList);
//    }
//    public static void sortPassengersByTicketClass(ArrayList<Passenger> passengerList)
//    {
//        System.out.println("Passengers sorted by Ticket Class");
//        sortPassengersByTicketClassComparator TicketClassComparator = new sortPassengersByTicketClassComparator();
//        Collections.sort(passengerList, TicketClassComparator);
//        display(passengerList);
//    }
//
//     public static void sortPassengersByAge(ArrayList<Passenger> passengerList) {
//         //using an anonymous inner class to sort passengers by age
//         Collections.sort(passengerList, new Comparator<Passenger>() {
//             @Override
//             public int compare(Passenger p1, Passenger p2) {
//                 //compare passengers based on their age
//                 return Integer.compare(p1.getAge(), p2.getAge());
//             }
//         });
//         display(passengerList);
//     }
//    }
//    public static void sortPassengersByTicketNumberLambda(ArrayList<Passenger> passengerList)
//    {
//        System.out.println("Passengers sorted by Ticket Number using Lambda");
//        Collections.sort(passengerList, (p1, p2) -> p1.getTicketNumber().compareTo(p2.getTicketNumber()));
//        display(passengerList);
//    }
//    public static void sortPassengersByTicketNumberStatic(ArrayList<Passenger> passengerList)
//    {
//        System.out.println("Passengers sorted by Ticket Number using Static");
//        Collections.sort(passengerList, sortPassengersByTicketNumberStaticComparator.sortbyTicketNumber);
//        display(passengerList);
//    }
//    public static void findPassengerByTicketNumber(ArrayList<Passenger> passengerList, String ticketNumber)
//    {
//        Collections.sort(passengerList, new sortPassengerByTicketNumberComparator());
//        int index = Collections.binarySearch(passengerList, new Passenger(ticketNumber,""), new sortPassengerByTicketNumberComparator());
//        if (index >= 0) {
//            System.out.println("Passenger found: " + passengerList.get(index));
//        } else {
//            System.out.println("Passenger not found.");
//        }
//    }
    public static void findPassengerByPassengerId(ArrayList<Passenger> passengerList, String passengerId)
    {
        Collections.sort(passengerList, new sortingPassengerIDForBinary());
        int index = Collections.binarySearch(passengerList, new Passenger("",passengerId), new sortingPassengerIDForBinary());
        if (index >= 0) {
            System.out.println("Passenger ID found: " + passengerList.get(index));
        } else {
            System.out.println("Passenger ID not found.");
        }
    }













    public static void display(List<Passenger> passengerList)
    {
        for (Passenger passenger : passengerList) { System.out.println(passenger); }
    }
}







