import java.util.Comparator;

public class passengerComparatorID implements Comparator<Passenger>
{
    public int compare(Passenger passenger1, Passenger passenger2)
    {
        //converts PassengerId into integers
        int id1 = Integer.parseInt(passenger1.getPassengerId());
        int id2 = Integer.parseInt(passenger2.getPassengerId());

        if (id1 < id2) {
            return -1;
        } else if (id1 > id2) {
            return 1;
        } else {
            return 0;
        }

    }


}
