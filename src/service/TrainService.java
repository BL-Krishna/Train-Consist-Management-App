package service;

import comparator.*;
import exception.InvalidInputException;
import model.*;
import repository.TrainRepository;
import util.RegexValidator;

public class TrainService {

    private final TrainRepository repository =
            new TrainRepository();
    private final SafetyService safetyService =
            new SafetyService();

    private final ReportService reportService =
            new ReportService();

    private final StreamService streamService =
            new StreamService();

    public void attachRear(Bogie bogie) {

        if (!RegexValidator.isValidBogieId(
                bogie.getBogieId())) {

            throw new InvalidInputException(
                    "Invalid Bogie ID : "
                            + bogie.getBogieId());

        }

        repository.attachRear(bogie);

    }
    public void attachFront(Bogie bogie) {

        if (!RegexValidator.isValidBogieId(
                bogie.getBogieId())) {

            throw new InvalidInputException(
                    "Invalid Bogie ID : "
                            + bogie.getBogieId());

        }

        repository.attachFront(bogie);

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
    public void validateTrain() {

        safetyService.validateTrain(

                repository.getAllBogies());

        System.out.println();

        System.out.println(
                "Train Safety Validation Successful.");

    }
    public void generateReport() {

        reportService.generateReport(

                repository.getAllBogies());

    }
    public void streamReport() {

        System.out.println();

        System.out.println("========== STREAM REPORT ==========");

        System.out.println("Passenger Bogies : " +
                streamService.passengerCount(
                        repository.getAllBogies()));

        System.out.println("Goods Bogies : " +
                streamService.goodsCount(
                        repository.getAllBogies()));

        System.out.println("Total Seats : " +
                streamService.totalSeats(
                        repository.getAllBogies()));

        System.out.println("Occupied Seats : " +
                streamService.occupiedSeats(
                        repository.getAllBogies()));

        System.out.println("Cargo Capacity : " +
                streamService.totalCargoCapacity(
                        repository.getAllBogies()));

        System.out.println("Cargo Loaded : " +
                streamService.totalCargoLoaded(
                        repository.getAllBogies()));

        System.out.println();

        System.out.println("Most Occupied Passenger");

        System.out.println(

                streamService.mostOccupiedPassenger(

                        repository.getAllBogies()

                )

        );

        System.out.println();

        System.out.println("Highest Loaded Goods");

        System.out.println(

                streamService.highestLoadedGoods(

                        repository.getAllBogies()

                )

        );

    }



}