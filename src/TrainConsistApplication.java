import model.BogieType;
import model.CargoType;
import model.GoodsBogie;
import model.PassengerBogie;
import service.TrainService;

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
                    55));

    service.attachRear(

            new GoodsBogie(
                    "GB201",
                    CargoType.COAL,
                    100));

    service.displayTrain();

}