import model.BogieType;
import model.CargoType;
import model.GoodsBogie;
import model.PassengerBogie;
import service.TrainService;

import java.util.Scanner;

public class TrainConsistApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TrainService service = new TrainService();

        boolean running = true;

        while (running) {

            System.out.println();

            System.out.println("====================================");

            System.out.println("TRAIN CONSIST MANAGEMENT SYSTEM");

            System.out.println("====================================");

            System.out.println("1. Attach Passenger Bogie");

            System.out.println("2. Attach Goods Bogie");

            System.out.println("3. Display Train");

            System.out.println("4. Search Bogie");

            System.out.println("5. Sort By Bogie ID");

            System.out.println("6. Analytics Report");

            System.out.println("7. Validate Train");

            System.out.println("8. Undo");

            System.out.println("9. Redo");

            System.out.println("10. Save Train");

            System.out.println("11. Load Train");

            System.out.println("12. Exit");

            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1 -> {

                    System.out.print("Bogie ID : ");

                    String id = scanner.next();

                    System.out.print("Seat Capacity : ");

                    int seats = scanner.nextInt();

                    System.out.print("Occupied Seats : ");

                    int occupied = scanner.nextInt();

                    service.attachRear(

                            new PassengerBogie(

                                    id,

                                    seats,

                                    occupied

                            )

                    );

                }

                case 2 -> {

                    System.out.print("Bogie ID : ");

                    String id = scanner.next();

                    System.out.println("Cargo Type");

                    for (CargoType cargo : CargoType.values()) {

                        System.out.println(cargo.ordinal() + 1 + ". " + cargo);

                    }

                    int cargoChoice = scanner.nextInt();

                    CargoType cargo = CargoType.values()[cargoChoice - 1];

                    System.out.print("Maximum Capacity : ");

                    double capacity = scanner.nextDouble();

                    GoodsBogie goods =

                            new GoodsBogie(

                                    id,

                                    cargo,

                                    capacity

                            );

                    System.out.print("Current Load : ");

                    goods.loadCargo(

                            scanner.nextDouble()

                    );

                    service.attachRear(goods);

                }

                case 3 ->

                        service.displayTrain();

                case 4 -> {

                    System.out.print("Enter Bogie ID : ");

                    service.linearSearch(

                            scanner.next()

                    );

                }

                case 5 -> {

                    service.bubbleSortById();

                    System.out.println("Sorted Successfully.");

                }

                case 6 ->

                        service.analyticsReport();

                case 7 ->

                        service.validateTrain();

                case 8 ->

                        service.undo();

                case 9 ->

                        service.redo();

                case 10 ->

                        service.saveTrain();

                case 11 ->

                        service.loadTrain();

                case 12 -> {

                    running = false;

                    System.out.println("Application Closed.");

                }

                default ->

                        System.out.println("Invalid Choice.");

            }

        }

    }

}