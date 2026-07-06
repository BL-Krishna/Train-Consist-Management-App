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
                        60
                ));

        trainService.addPassengerBogie(
                new PassengerBogie(
                        "PB102",
                        72,
                        58
                ));

        trainService.addPassengerBogie(
                new PassengerBogie(
                        "PB103",
                        60,
                        45
                ));

        // Duplicate ID
        trainService.addPassengerBogie(
                new PassengerBogie(
                        "PB101",
                        60,
                        40
                ));

        trainService.displayAllBogies();

    }

}
