package model;

public class PassengerBogie extends Bogie {

    private static final long serialVersionUID = 1L;

    private int seatingCapacity;

    private int occupiedSeats;

    public PassengerBogie(String bogieId,
                          int seatingCapacity,
                          int occupiedSeats) {

        super(bogieId,
                BogieType.PASSENGER);

        this.seatingCapacity = seatingCapacity;
        this.occupiedSeats = occupiedSeats;

    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    @Override
    public String toString() {

        return "PassengerBogie{" +
                "bogieId='" + bogieId + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", occupiedSeats=" + occupiedSeats +
                '}';

    }

}