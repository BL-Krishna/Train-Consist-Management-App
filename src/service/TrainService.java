package service;

import model.Bogie;
import model.PassengerBogie;
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

}