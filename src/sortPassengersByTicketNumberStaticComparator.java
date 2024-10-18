import java.util.Comparator;

public class sortPassengersByTicketNumberStaticComparator
{
public static final Comparator<Passenger> sortbyTicketNumber = new Comparator<Passenger>() {
    @Override
    public int compare(Passenger p1, Passenger p2) {

        return p1.getTicketNumber().compareTo(p2.getTicketNumber());
    }
};

}
