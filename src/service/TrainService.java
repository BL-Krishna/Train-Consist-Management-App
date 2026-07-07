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

    private final AnalyticsService analyticsService =
            new AnalyticsService();

    private final SortingService sortingService =
            new SortingService(repository);

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
    public void analyticsReport() {

        System.out.println();

        System.out.println("========== ANALYTICS ==========");

        System.out.println();

        System.out.println("Bogie Count");

        analyticsService

                .bogieCountByType(repository.getAllBogies())

                .forEach((type, count) ->

                        System.out.println(type + " : " + count));

        System.out.println();

        System.out.println("Cargo Distribution");

        analyticsService

                .cargoCount(repository.getAllBogies())

                .forEach((cargo, count) ->

                        System.out.println(cargo + " : " + count));

        System.out.println();

        System.out.println("Average Passenger Occupancy : "

                + analyticsService.averagePassengerOccupancy(

                repository.getAllBogies()));

        System.out.println();

        System.out.println("Average Cargo Load : "

                + analyticsService.averageCargoLoad(

                repository.getAllBogies()));

        System.out.println();

        System.out.println("Top Passenger Bogie");

        System.out.println(

                analyticsService.topPassengerBogie(

                        repository.getAllBogies()

                )

        );

        System.out.println();

        System.out.println("Top Goods Bogie");

        System.out.println(

                analyticsService.topGoodsBogie(

                        repository.getAllBogies()

                )

        );

        System.out.println();

        System.out.println("Passenger Statistics");

        System.out.println(

                analyticsService.passengerStatistics(

                        repository.getAllBogies()

                )

        );

        System.out.println();

        System.out.println("Cargo Statistics");

        System.out.println(

                analyticsService.cargoStatistics(

                        repository.getAllBogies()

                )

        );

    }
    public void bubbleSortById() {

        sortingService.bubbleSortById();

    }

    public void selectionSortById() {

        sortingService.selectionSortById();

    }

    public void insertionSortById() {

        sortingService.insertionSortById();

    }

    public void mergeSortById() {

        sortingService.mergeSortById();

    }
    public void displayTrain() {

        repository.displayTrain();

    }
}