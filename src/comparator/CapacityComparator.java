package comparator;

import model.Bogie;
import model.GoodsBogie;
import model.PassengerBogie;

import java.util.Comparator;

public class CapacityComparator
        implements Comparator<Bogie> {

    @Override
    public int compare(Bogie first,
                       Bogie second) {

        double firstCapacity = getCapacity(first);

        double secondCapacity = getCapacity(second);

        return Double.compare(
                firstCapacity,
                secondCapacity);

    }

    private double getCapacity(Bogie bogie) {

        if (bogie instanceof PassengerBogie passenger) {

            return passenger.getSeatingCapacity();

        }

        if (bogie instanceof GoodsBogie goods) {

            return goods.getMaximumCapacity();

        }

        return 0;

    }

}
