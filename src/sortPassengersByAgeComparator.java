import java.util.Comparator;

public class sortPassengersByAgeComparator implements Comparator<Passenger>
{
    public int compare(Passenger p1, Passenger p2)
    {
        return p1.getAge() - p2.getAge();
    }
}
