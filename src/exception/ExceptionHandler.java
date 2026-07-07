package exception;
public class ExceptionHandler {

    private ExceptionHandler() {

    }

    public static void handle(Exception exception) {

        System.out.println();

        System.out.println("================================");

        if (exception instanceof ApplicationException) {

            System.out.println("APPLICATION ERROR");

        } else {

            System.out.println("SYSTEM ERROR");

        }

        System.out.println(exception.getMessage());

        System.out.println("================================");

    }

}
