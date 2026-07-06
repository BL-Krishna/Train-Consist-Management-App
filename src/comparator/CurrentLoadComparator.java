package comparator;

import model.Bogie;
import model.GoodsBogie;

import java.util.Comparator;

public class CurrentLoadComparator
        implements Comparator<Bogie> {

    @Override
    public int compare(Bogie first,
                       Bogie second) {

        return Double.compare(

                getCurrentLoad(first),

                getCurrentLoad(second)

        );

    }

    private double getCurrentLoad(Bogie bogie) {

        if (bogie instanceof GoodsBogie goods) {

            return goods.getCurrentLoad();

        }

        return 0;

    }

}
