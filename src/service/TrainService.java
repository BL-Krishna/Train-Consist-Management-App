package service;

import repository.TrainRepository;

public class TrainService {

    private final TrainRepository repository =
            new TrainRepository();

    public void displaySummary() {

        System.out.println();

        System.out.println("===== TRAIN CONSIST SUMMARY =====");

        System.out.println("Initial Bogie Count : "
                + repository.getConsist().size());

    }

}