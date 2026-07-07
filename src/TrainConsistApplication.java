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
                    65));

    service.attachRear(
            new PassengerBogie(
                    "PB102",
                    80,
                    75));

    GoodsBogie goods1 =
            new GoodsBogie(
                    "GB201",
                    CargoType.COAL,
                    100);

    goods1.loadCargo(60);

    GoodsBogie goods2 =
            new GoodsBogie(
                    "GB202",
                    CargoType.STEEL,
                    120);

    goods2.loadCargo(100);

    service.attachRear(goods1);

    service.attachRear(goods2);


    service.streamReport();

}