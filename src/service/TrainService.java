package service;

import model.PassengerBogie;
import repository.TrainRepository;

public class TrainService {

    private final TrainRepository repository =
            new TrainRepository();

    public void addPassengerBogie(
            PassengerBogie bogie) {

        repository.addBogie(bogie);

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

        System.out.println("Bogie Found");

        System.out.println(bogie);

    }

    public void removeBogie(String bogieId) {

        if (repository.removeBogie(bogieId)) {

            System.out.println("Bogie Removed Successfully.");

        } else {

            System.out.println("Bogie Not Found.");

        }

    }

    public void displaySummary() {

        System.out.println();

        System.out.println("Total Passenger Bogies : "
                + repository.totalBogies());

    }

}