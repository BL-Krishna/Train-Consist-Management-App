package service;

import model.PassengerBogie;
import repository.TrainRepository;

public class TrainService {

    private final TrainRepository repository =
            new TrainRepository();

    public void addPassengerBogie(
            PassengerBogie bogie) {

        repository.addBogie(bogie);

        System.out.println(
                bogie.getBogieId()
                        + " Added Successfully.");

    }

    public void displayAllBogies() {

        System.out.println();

        System.out.println("===== PASSENGER BOGIES =====");

        repository.getAllBogies()

                .forEach(System.out::println);

    }

    public void searchBogie(String bogieId) {

        PassengerBogie bogie =
                repository.findById(bogieId);

        if (bogie == null) {

            System.out.println("Bogie Not Found.");

            return;

        }

        System.out.println();

        System.out.println(bogie);

    }

    public void removeBogie(String bogieId) {

        if (repository.removeBogie(bogieId)) {

            System.out.println(
                    bogieId + " Removed Successfully.");

        }

        else {

            System.out.println("Bogie Not Found.");

        }

    }

    public void displaySummary() {

        System.out.println();

        System.out.println(
                "Total Passenger Bogies : "
                        + repository.totalBogies());

    }

}