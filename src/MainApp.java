
import org.w3c.dom.ls.LSOutput;

import java.io. * ;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

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
//        ticketOwner();
//        averageAge(passengerList);
//        getPassengersByTicketClass();
//        sortPassengersByPassengerId()
//        sortPassengersByName();
//        sortPassengersByAgeThenName();
//        sortPassengersByGenderThenPassengerNumber()
//        sortPassengersByFareThenSurvival();
//        sortPassengersByTicketClass()
//        sortPassengersByAge();
//        sortPassengersByTicketNumberLambda();
//        sortPassengersByTicketNumberStatic();
//        findPassengerByTicketNumber();
//        findPassengerByPassengerId();


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
            System.out.println("Go...");

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

                System.out.println(passengerId +", " + name);

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

public static void averageAge(ArrayList<Passenger> passengerList)
   {
   int totalage = 0;
   int averageage = 0;
   for(Passenger passenger : passengerList)
   {
       totalage += passenger.getAge();
   }
   averageage = totalage / passengerList.size();
       System.out.println(averageage+" is the average age on the titanic.");
   }

}