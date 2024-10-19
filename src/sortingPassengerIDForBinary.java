import java.util.Comparator;
public class sortingPassengerIDForBinary implements Comparator<Passenger> {
    @Override
    public int compare(Passenger p1, Passenger p2) {
        return p1.getPassengerId().compareTo(p2.getPassengerId());
    }
}
