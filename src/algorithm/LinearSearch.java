package algorithm;

import model.Bogie;

import java.util.List;

public class LinearSearch {

    public Bogie search(List<Bogie> list,
                        String bogieId) {

        for (Bogie bogie : list) {

            if (bogie.getBogieId()
                    .equalsIgnoreCase(bogieId)) {

                return bogie;

            }

        }

        return null;

    }

}
