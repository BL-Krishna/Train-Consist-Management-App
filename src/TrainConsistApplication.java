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
        System.out.println();

        System.out.println("========= ORIGINAL =========");

        service.displayTrain();

        service.sortByBogieId();

        System.out.println();

        System.out.println("========= SORTED BY ID =========");

        service.displayTrain();

        service.sortByCapacity();

        System.out.println();

        System.out.println("========= SORTED BY CAPACITY =========");

        service.displayTrain();

        service.sortByCurrentLoad();

        System.out.println();

        System.out.println("========= SORTED BY LOAD =========");

        service.displayTrain();

        System.out.println();

        System.out.println("========== SEARCH BY ID ==========");

        service.searchById("GB201");

        System.out.println();

        System.out.println("========== PASSENGER CAPACITY ==========");

        service.searchPassengerCapacity(72);

        System.out.println();

        System.out.println("========== GOODS BY CARGO ==========");

        service.searchCargoType(CargoType.COAL);

        System.out.println();

        System.out.println("========== GOODS LOAD >= 50 ==========");

        service.searchGoodsByLoad(50);

        System.out.println();

        System.out.println("========== PASSENGER BOGIES ==========");

        service.searchBogieType(BogieType.PASSENGER);

    }
}