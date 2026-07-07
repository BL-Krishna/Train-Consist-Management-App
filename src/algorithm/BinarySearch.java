package algorithm;

import model.Bogie;

import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    public Bogie search(List<Bogie> list,
                        String bogieId,
                        Comparator<Bogie> comparator) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            Bogie middle = list.get(mid);

            int result = comparator.compare(
                    middle,
                    new DummyBogie(bogieId));

            if (result == 0) {

                return middle;

            }

            if (result < 0) {

                low = mid + 1;

            } else {

                high = mid - 1;

            }

        }

        return null;

    }

    /**
     * Temporary Bogie used only for comparison.
     */
    private static class DummyBogie extends Bogie {

        DummyBogie(String bogieId) {

            super(bogieId, null);

        }

    }

}
