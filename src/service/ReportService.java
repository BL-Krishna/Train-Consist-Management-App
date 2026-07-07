package service;

import model.Bogie;
import model.GoodsBogie;
import model.PassengerBogie;

import java.util.List;

public class ReportService {

    public void generateReport(List<Bogie> consist) {

        int passengerBogies = 0;
        int goodsBogies = 0;

        int totalSeats = 0;
        int occupiedSeats = 0;

        double totalCargoCapacity = 0;
        double currentCargoLoad = 0;

        for (Bogie bogie : consist) {

            if (bogie instanceof PassengerBogie passenger) {

                passengerBogies++;

                totalSeats += passenger.getSeatingCapacity();

                occupiedSeats += passenger.getOccupiedSeats();

            }

            if (bogie instanceof GoodsBogie goods) {

                goodsBogies++;

                totalCargoCapacity += goods.getMaximumCapacity();

                currentCargoLoad += goods.getCurrentLoad();

            }

        }

        int vacantSeats =
                totalSeats - occupiedSeats;

        double cargoUtilization = 0;

        if (totalCargoCapacity > 0) {

            cargoUtilization =
                    (currentCargoLoad / totalCargoCapacity) * 100;

        }

        System.out.println();

        System.out.println("========== TRAIN REPORT ==========");

        System.out.println("Passenger Bogies : " + passengerBogies);

        System.out.println("Goods Bogies     : " + goodsBogies);

        System.out.println();

        System.out.println("Total Seats      : " + totalSeats);

        System.out.println("Occupied Seats   : " + occupiedSeats);

        System.out.println("Vacant Seats     : " + vacantSeats);

        System.out.println();

        System.out.println("Cargo Capacity   : " + totalCargoCapacity + " Tons");

        System.out.println("Cargo Loaded     : " + currentCargoLoad + " Tons");

        System.out.printf("Cargo Utilization: %.2f %%\n", cargoUtilization);

        System.out.println("==============================");

    }

}
