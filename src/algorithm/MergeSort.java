package algorithm;

import model.Bogie;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeSort {

    public void sort(List<Bogie> list,
                     Comparator<Bogie> comparator) {

        Collections.sort(list, comparator);

    }

}
