import model.BogieType;
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

        service.allocateCargo(
                "GB201",
                40);

        service.allocateCargo(
                "GB202",
                70);

        service.validateTrain();

        service.validateTrain();

    }

}