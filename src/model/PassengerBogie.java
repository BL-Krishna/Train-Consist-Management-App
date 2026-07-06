package model;

public class PassengerBogie {

    private String bogieId;
    private int seatingCapacity;
    private int occupiedSeats;
    private BogieType bogieType;

    public PassengerBogie(String bogieId,
                          int seatingCapacity,
                          int occupiedSeats) {

        this.bogieId = bogieId;
        this.seatingCapacity = seatingCapacity;
        this.occupiedSeats = occupiedSeats;
        this.bogieType = BogieType.PASSENGER;
    }

    public String getBogieId() {
        return bogieId;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public void setOccupiedSeats(int occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

    public BogieType getBogieType() {
        return bogieType;
    }

    @Override
    public String toString() {

        return "PassengerBogie{" +
                "bogieId='" + bogieId + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", occupiedSeats=" + occupiedSeats +
                ", bogieType=" + bogieType +
                '}';
    }
}
