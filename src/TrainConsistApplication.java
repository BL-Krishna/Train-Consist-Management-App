import model.PassengerBogie;
import service.TrainService;

public class TrainConsistApplication {

    public static void main(String[] args) {

        TrainService trainService =
                new TrainService();

        trainService.addPassengerBogie(

                new PassengerBogie(
                        "PB101",
                        72,
                        55
                )
        );

        trainService.addPassengerBogie(

                new PassengerBogie(
                        "PB102",
                        72,
                        62
                )
        );

        trainService.addPassengerBogie(

                new PassengerBogie(
                        "PB103",
                        60,
                        45
                )
        );

        trainService.displayAllBogies();

        trainService.searchBogie("PB102");

        trainService.removeBogie("PB103");

        trainService.displaySummary();

    }

}
