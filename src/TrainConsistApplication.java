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

                new GoodsBogie(
                        "GB201",
                        CargoType.COAL,
                        80));

        service.attachRear(

                new GoodsBogie(
                        "GB202",
                        CargoType.STEEL,
                        100));

        service.attachRear(

                new PassengerBogie(
                        "PB102",
                        72,
                        58));

        service.allocateCargo(
                "GB201",
                40);

        service.allocateCargo(
                "GB201",
                20);

        service.allocateCargo(
                "GB202",
                75);

        service.displayTrain();

    }
}