import java.util.Comparator;

public class PassengerAgeThenNameComparator implements Comparator<Passenger>
{
    public int compare(Passenger passenger1, Passenger passenger2)
    {
        int age = passenger1.getAge() - passenger2.getAge();
        if (age == 0)
        {
            return passenger1.getName().compareTo(passenger2.getName());
        }
        return age;

    }
}
