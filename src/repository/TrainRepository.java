package repository;

import comparator.CapacityComparator;
import model.*;

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

    public Bogie removeRear() {
        return null;
    }

    public Bogie removeFront() {
        return null;
    }

    public void clear() {
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
        public Bogie findById(String bogieId) {

            for (Bogie bogie : consist) {

                if (bogie.getBogieId().equalsIgnoreCase(bogieId)) {

                    return bogie;

                }

            }

            return null;

        }

        public LinkedList<Bogie> findByType(BogieType type) {

            LinkedList<Bogie> result =
                    new LinkedList<>();

            for (Bogie bogie : consist) {

                if (bogie.getBogieType() == type) {

                    result.add(bogie);

                }

            }

            return result;

        }

        public LinkedList<GoodsBogie> findByCargoType(CargoType cargoType) {

            LinkedList<GoodsBogie> result =
                    new LinkedList<>();

            for (Bogie bogie : consist) {

                if (bogie instanceof GoodsBogie goods &&
                        goods.getCargoType() == cargoType) {

                    result.add(goods);

                }

            }

            return result;

        }

        public LinkedList<PassengerBogie> findPassengerByCapacity(int capacity) {

            LinkedList<PassengerBogie> result =
                    new LinkedList<>();

            for (Bogie bogie : consist) {

                if (bogie instanceof PassengerBogie passenger &&
                        passenger.getSeatingCapacity() == capacity) {

                    result.add(passenger);

                }

            }

            return result;

        }

        public LinkedList<GoodsBogie> findGoodsByLoad(double load) {

            LinkedList<GoodsBogie> result =
                    new LinkedList<>();

            for (Bogie bogie : consist) {

                if (bogie instanceof GoodsBogie goods &&
                        goods.getCurrentLoad() >= load) {

                    result.add(goods);

                }

            }

            return result;

        }

    }
    public void displayTrain() {

        System.out.println();

        System.out.println("========== TRAIN CONSIST ==========");

        consist.forEach(System.out::println);

    }
    public void clear() {

        consist.clear();

        bogieIds.clear();

        TrainRepository bogieIndex;
        bogieIndex.clear();

    }



}