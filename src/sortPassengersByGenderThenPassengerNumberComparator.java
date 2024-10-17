import java.util.Comparator;

public class sortPassengersByGenderThenPassengerNumberComparator  implements Comparator<Passenger> {
    public int compare(Passenger p1, Passenger p2)
    {
        int genderCompare = p1.getGender().compareTo(p2.getGender());
        if(genderCompare ==0)
        {
            int passenger1 = Integer.parseInt(p1.getPassengerId());
            int passenger2 = Integer.parseInt(p2.getPassengerId());
            return Integer.compare(passenger1, passenger2);
        }
        return genderCompare;
    }
}
