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

            new GoodsBogie(
                    "GB201",
                    CargoType.COAL,
                    100));

    System.out.println();

    System.out.println("Original Train");

    service.displayTrain();

    service.saveTrain();

    service.removeFront();

    service.removeFront();

    System.out.println();

    System.out.println("After Removing");

    service.displayTrain();

    service.loadTrain();

    System.out.println();

    System.out.println("After Loading");

    service.displayTrain();

}