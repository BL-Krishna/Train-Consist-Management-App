package service;

import command.Operation;
import command.OperationType;
import comparator.*;

import model.*;
import repository.TrainRepository;


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

    private final SearchService searchService =
            new SearchService(repository);

    private final UndoRedoService undoRedoService =
            new UndoRedoService(repository);

    public void attachRear(Bogie bogie) {

        repository.attachRear(bogie);

        undoRedoService.save(

                new Operation(

                        OperationType.ATTACH_REAR,

                        bogie

                )

        );

    }
    public void attachFront(Bogie bogie) {

        repository.attachFront(bogie);

        undoRedoService.save(

                new Operation(

                        OperationType.ATTACH_FRONT,

                        bogie

                )

        );

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
    public void linearSearch(String bogieId) {

        System.out.println(

                searchService.linearSearch(bogieId)

        );

    }

    public void binarySearch(String bogieId) {

        System.out.println(

                searchService.binarySearch(bogieId)

        );

    }
    public void removeFront() {

        Bogie removed =
                repository.removeFront();

        if (removed != null) {

            undoRedoService.save(

                    new Operation(

                            OperationType.REMOVE_FRONT,

                            removed

                    )

            );

        }

    }
    public void removeRear() {

        Bogie removed =
                repository.removeRear();

        if (removed != null) {

            undoRedoService.save(

                    new Operation(

                            OperationType.REMOVE_REAR,

                            removed

                    )

            );

        }

    }

    public void redo() {
    }
}