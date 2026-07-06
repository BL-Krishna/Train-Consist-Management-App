package service;

import comparator.*;
import model.*;
import repository.TrainRepository;

public class TrainService {

    private final TrainRepository repository =
            new TrainRepository();

    public void attachRear(Bogie bogie) {

        repository.attachRear(bogie);

    }
    public void sortByBogieId() {

        repository.sort(
                new BogieIdComparator());

    }

    public void sortByCapacity() {

        repository.sort(
                new CapacityComparator());

    }

    public void sortByCurrentLoad() {

        repository.sort(
                new CurrentLoadComparator());

    }

    public void attachFront(Bogie bogie) {

        repository.attachFront(bogie);

    }
    public void searchById(String bogieId) {

        Bogie bogie =
                repository.findById(bogieId);

        if (bogie == null) {

            System.out.println("Bogie Not Found");

            return;

        }

        System.out.println(bogie);

    }

    public void searchPassengerCapacity(int capacity) {

        repository.findPassengerByCapacity(capacity)

                .forEach(System.out::println);

    }

    public void searchCargoType(CargoType cargoType) {

        repository.findByCargoType(cargoType)

                .forEach(System.out::println);

    }

    public void searchGoodsByLoad(double load) {

        repository.findGoodsByLoad(load)

                .forEach(System.out::println);

    }

    public void searchBogieType(BogieType type) {

        repository.findByType(type)

                .forEach(System.out::println);

    }

    public void displayTrain() {

        System.out.println();

        System.out.println(
                "========= TRAIN CONSIST =========");

        repository.getAllBogies()

                .forEach(System.out::println);

    }
    public void allocateCargo(String bogieId,
                              double weight) {

        for (Bogie bogie : repository.getAllBogies()) {

            if (bogie instanceof GoodsBogie goods
                    && goods.getBogieId().equalsIgnoreCase(bogieId)) {

                goods.loadCargo(weight);

                System.out.println();

                System.out.println(weight +
                        " Tons Loaded into " +
                        bogieId);

                return;

            }

        }


        System.out.println("Goods Bogie Not Found.");


    }



}