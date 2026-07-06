import model.CargoType;
import model.GoodsBogie;
import model.PassengerBogie;
import service.TrainService;

public class TrainConsistApplication {

    public static void main(String[] args) {

        TrainService service =
                new TrainService();

        service.attachRear(

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

                new GoodsBogie(
                        "GB201",
                        CargoType.COAL,
                        70));

        service.attachRear(

                new GoodsBogie(
                        "GB202",
                        CargoType.STEEL,
                        80));

        service.attachRear(

                new PassengerBogie(
                        "PB103",
                        60,
                        40));

        service.displayTrain();

    }

}