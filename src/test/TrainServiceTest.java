package test;

import org.junit.jupiter.api.Test;
import model.PassengerBogie;

import static org.junit.jupiter.api.Assertions.*;

class TrainServiceTest {

    @Test
    void shouldCreatePassengerBogie() {

        PassengerBogie bogie =
                new PassengerBogie(
                        "PB101",
                        72,
                        50
                );

        assertEquals("PB101", bogie.getBogieId());
        assertEquals(72, bogie.getSeatingCapacity());
        assertEquals(50, bogie.getOccupiedSeats());

    }

}
