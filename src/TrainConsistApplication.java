import exception.ExceptionHandler;
import model.BogieType;
import model.CargoType;
import model.GoodsBogie;
import model.PassengerBogie;
import service.TrainService;

public class TrainConsistApplication {

    public static void main(String[] args) {

        TrainService service =
                new TrainService();

        try {

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

            service.allocateCargo(
                    "GB201",
                    90);

            //service.displayTrain();

        }

        catch (Exception exception) {

            ExceptionHandler.handle(
                    exception);

        }

    }

}