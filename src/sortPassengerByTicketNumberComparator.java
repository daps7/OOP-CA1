import java.util.Comparator;

public class sortPassengerByTicketNumberComparator implements Comparator<Passenger>
{
    public int compare (Passenger p1, Passenger p2)
    {
        return p1.getTicketNumber().compareTo(p2.getTicketNumber());
    }
}
