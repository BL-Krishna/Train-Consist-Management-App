import model.PassengerBogie;
import service.TrainService;

public class TrainConsistApplication {

    public static void main(String[] args) {

        TrainService service =
                new TrainService();

        service.attachFront(

                new PassengerBogie(
                        "PB101",
                        72,
                        60));

        service.attachRear(

                new PassengerBogie(
                        "PB102",
                        72,
                        58));

        service.attachRear(

                new PassengerBogie(
                        "PB103",
                        60,
                        45));

        service.attachFront(

                new PassengerBogie(
                        "PB100",
                        72,
                        55));

        service.displayTrain();

        service.displayEnds();

        service.detachFront();

        service.detachRear();

        service.displayTrain();

    }

}