package model;

public class GoodsBogie extends Bogie {

    private static final long serialVersionUID = 1L;

    private CargoType cargoType;

    private double maximumCapacity;

    private double currentLoad;

    public GoodsBogie(String bogieId,
                      CargoType cargoType,
                      double maximumCapacity) {

        super(bogieId, BogieType.GOODS);

        this.cargoType = cargoType;
        this.maximumCapacity = maximumCapacity;
        this.currentLoad = 0;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public double getMaximumCapacity() {
        return maximumCapacity;
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public double getRemainingCapacity() {

        return maximumCapacity - currentLoad;

    }

    public void loadCargo(double weight) {

        if (currentLoad + weight > maximumCapacity) {

            throw new IllegalArgumentException(
                    "Maximum capacity exceeded."
            );

        }

        currentLoad += weight;

    }

    @Override
    public String toString() {

        return "GoodsBogie{" +
                "bogieId='" + bogieId + '\'' +
                ", cargoType=" + cargoType +
                ", maximumCapacity=" + maximumCapacity +
                ", currentLoad=" + currentLoad +
                ", remainingCapacity=" + getRemainingCapacity() +
                '}';
    }

}
