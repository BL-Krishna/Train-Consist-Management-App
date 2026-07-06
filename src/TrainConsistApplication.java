import service.TrainService;

public class TrainConsistApplication {

    public static void main(String[] args) {

        System.out.println();

        System.out.println("======================================");
        System.out.println(" TRAIN CONSIST MANAGEMENT APPLICATION ");
        System.out.println("======================================");

        TrainService trainService =
                new TrainService();

        trainService.displaySummary();

    }

}
