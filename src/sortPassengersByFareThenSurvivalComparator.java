import java.util.Comparator;

public class sortPassengersByFareThenSurvivalComparator implements Comparator<Passenger>
{
    public int compare(Passenger p1, Passenger p2)
    {
     double fareCompare1 = p1.getFare();
     double fareCompare2 = p2.getFare();
        if (fareCompare1 < fareCompare2) {
            return -1;
        } else if (fareCompare1 > fareCompare2) {
            return 1;
        } else {
            return Integer.compare(p2.getSurvived(), p1.getSurvived());
        }

    }
}
