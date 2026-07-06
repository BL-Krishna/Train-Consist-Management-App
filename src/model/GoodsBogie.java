package model;

public class GoodsBogie extends Bogie {

    private CargoType cargoType;

    private double loadCapacity;

    public GoodsBogie(String bogieId,
                      CargoType cargoType,
                      double loadCapacity) {

        super(bogieId,
                BogieType.GOODS);

        this.cargoType = cargoType;
        this.loadCapacity = loadCapacity;

    }

    public CargoType getCargoType() {

        return cargoType;

    }

    public double getLoadCapacity() {

        return loadCapacity;

    }

    @Override
    public String toString() {

        return "GoodsBogie{" +
                "bogieId='" + bogieId + '\'' +
                ", cargoType=" + cargoType +
                ", loadCapacity=" + loadCapacity +
                '}';

    }

}
