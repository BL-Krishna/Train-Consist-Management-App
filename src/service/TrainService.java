package service;

import model.PassengerBogie;
import repository.TrainRepository;

public class TrainService {

    private final TrainRepository repository =
            new TrainRepository();

    public void attachFront(
            PassengerBogie bogie) {

        repository.addFront(bogie);

        System.out.println(
                bogie.getBogieId()
                        + " Attached at Front");

    }

    public void attachRear(
            PassengerBogie bogie) {

        repository.addRear(bogie);

        System.out.println(
                bogie.getBogieId()
                        + " Attached at Rear");

    }

    public void detachFront() {

        PassengerBogie bogie =
                repository.removeFront();

        System.out.println(
                "Detached : " + bogie);

    }

    public void detachRear() {

        PassengerBogie bogie =
                repository.removeRear();

        System.out.println(
                "Detached : " + bogie);

    }

    public void displayTrain() {

        System.out.println();

        System.out.println(
                "========= TRAIN CONSIST =========");

        repository.getAllBogies()

                .forEach(System.out::println);

    }

    public void displayEnds() {

        System.out.println();

        System.out.println(
                "Front : "
                        + repository.getFront());

        System.out.println(
                "Rear : "
                        + repository.getRear());

    }

}