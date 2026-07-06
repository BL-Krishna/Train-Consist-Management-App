package repository;

import comparator.CapacityComparator;
import model.Bogie;
import model.GoodsBogie;

import java.util.*;

public class TrainRepository {

    private final LinkedList<Bogie> consist =
            new LinkedList<>();

    private final Set<String> bogieIds =
            new HashSet<>();

    public void attachFront(Bogie bogie) {

        validateDuplicate(bogie);

        consist.addFirst(bogie);

        bogieIds.add(bogie.getBogieId());

    }

    public void attachRear(Bogie bogie) {

        validateDuplicate(bogie);

        consist.addLast(bogie);

        bogieIds.add(bogie.getBogieId());

    }

    private void validateDuplicate(Bogie bogie) {

        if (bogieIds.contains(bogie.getBogieId()))

            throw new IllegalArgumentException(
                    "Duplicate Bogie ID : "
                            + bogie.getBogieId());

    }

    public List<Bogie> getAllBogies() {

        return consist;

    }

    public void sort(CapacityComparator bogieIdComparator) {
    }

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

}