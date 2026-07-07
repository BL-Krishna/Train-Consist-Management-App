package algorithm;
import model.Bogie;

import java.util.Comparator;
import java.util.List;

public class SelectionSort {

    public void sort(List<Bogie> list,
                     Comparator<Bogie> comparator) {

        int n = list.size();

        for (int i = 0; i < n - 1; i++) {

            int min = i;

            for (int j = i + 1; j < n; j++) {

                if (comparator.compare(
                        list.get(j),
                        list.get(min)) < 0) {

                    min = j;

                }

            }

            Bogie temp = list.get(i);

            list.set(i, list.get(min));

            list.set(min, temp);

        }

    }

}
