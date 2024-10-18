import java.util.Comparator;

public class sortPassengersByTicketClassComparator implements Comparator<Passenger> {
    public int compare(Passenger p1, Passenger p2)
    {
        return p1.getPassengerClass().compareTo(p2.getPassengerClass());
    }
}
