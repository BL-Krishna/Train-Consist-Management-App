package algorithm;

import model.Bogie;

import java.util.Comparator;
import java.util.List;

public class InsertionSort {

    public void sort(List<Bogie> list,
                     Comparator<Bogie> comparator) {

        for (int i = 1; i < list.size(); i++) {

            Bogie key = list.get(i);

            int j = i - 1;

            while (j >= 0 &&
                    comparator.compare(list.get(j), key) > 0) {

                list.set(j + 1, list.get(j));

                j--;

            }

            list.set(j + 1, key);

        }

    }

}
