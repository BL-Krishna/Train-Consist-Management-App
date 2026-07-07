package util;

import java.util.regex.Pattern;

public class RegexValidator {

    private RegexValidator() {
    }

    private static final Pattern BOGIE_ID_PATTERN =
            Pattern.compile("^(PB|GB)\\d{3}$");

    private static final Pattern NAME_PATTERN =
            Pattern.compile("^[A-Za-z ]{3,30}$");

    private static final Pattern CARGO_PATTERN =
            Pattern.compile("^[A-Za-z ]{2,30}$");

    public static boolean isValidBogieId(String id) {

        return id != null &&
                BOGIE_ID_PATTERN.matcher(id).matches();

    }

    public static boolean isValidPassengerName(String name) {

        return name != null &&
                NAME_PATTERN.matcher(name).matches();

    }

    public static boolean isValidCargoName(String cargo) {

        return cargo != null &&
                CARGO_PATTERN.matcher(cargo).matches();

    }

    public static boolean isPositive(int number) {

        return number > 0;

    }

    public static boolean isPositive(double number) {

        return number > 0;

    }

}
