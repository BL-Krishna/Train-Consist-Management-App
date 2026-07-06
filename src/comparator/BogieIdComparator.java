package comparator;


import model.Bogie;

import java.util.Comparator;

public class BogieIdComparator
        implements Comparator<Bogie> {

    @Override
    public int compare(Bogie first,
                       Bogie second) {

        return first.getBogieId()
                .compareToIgnoreCase(second.getBogieId());

    }

}
