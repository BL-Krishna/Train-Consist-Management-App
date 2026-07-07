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

                new PassengerBogie(
                        "PB102",
                        80,
                        70));

        service.attachRear(

                new GoodsBogie(
                        "GB201",
                        CargoType.COAL,
                        100));

        service.attachRear(

                new GoodsBogie(
                        "GB202",
                        CargoType.STEEL,
                        120));

        service.allocateCargo(
                "GB201",
                80);

        service.allocateCargo(
                "GB202",
                60);

        service.validateTrain();

        service.generateReport();

    }

}