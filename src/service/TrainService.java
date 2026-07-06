package service;

import model.*;
import repository.TrainRepository;

public class TrainService {

    private final TrainRepository repository =
            new TrainRepository();

    public void attachRear(Bogie bogie) {

        repository.attachRear(bogie);

    }

    public void attachFront(Bogie bogie) {

        repository.attachFront(bogie);

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