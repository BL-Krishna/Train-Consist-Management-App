package service;

import model.Bogie;
import model.GoodsBogie;
import model.PassengerBogie;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamService {

    public List<PassengerBogie> getPassengerBogies(
            List<Bogie> consist) {

        return consist.stream()

                .filter(bogie -> bogie instanceof PassengerBogie)

                .map(bogie -> (PassengerBogie) bogie)

                .collect(Collectors.toList());

    }

    public List<GoodsBogie> getGoodsBogies(
            List<Bogie> consist) {

        return consist.stream()

                .filter(bogie -> bogie instanceof GoodsBogie)

                .map(bogie -> (GoodsBogie) bogie)

                .collect(Collectors.toList());

    }

    public long passengerCount(
            List<Bogie> consist) {

        return consist.stream()

                .filter(PassengerBogie.class::isInstance)

                .count();

    }

    public long goodsCount(
            List<Bogie> consist) {

        return consist.stream()

                .filter(GoodsBogie.class::isInstance)

                .count();

    }

    public int totalSeats(
            List<Bogie> consist) {

        return consist.stream()

                .filter(PassengerBogie.class::isInstance)

                .map(PassengerBogie.class::cast)

                .mapToInt(PassengerBogie::getSeatingCapacity)

                .sum();

    }

    public int occupiedSeats(
            List<Bogie> consist) {

        return consist.stream()

                .filter(PassengerBogie.class::isInstance)

                .map(PassengerBogie.class::cast)

                .mapToInt(PassengerBogie::getOccupiedSeats)

                .sum();

    }

    public double totalCargoCapacity(
            List<Bogie> consist) {

        return consist.stream()

                .filter(GoodsBogie.class::isInstance)

                .map(GoodsBogie.class::cast)

                .mapToDouble(GoodsBogie::getMaximumCapacity)

                .sum();

    }

    public double totalCargoLoaded(
            List<Bogie> consist) {

        return consist.stream()

                .filter(GoodsBogie.class::isInstance)

                .map(GoodsBogie.class::cast)

                .mapToDouble(GoodsBogie::getCurrentLoad)

                .sum();

    }

    public PassengerBogie mostOccupiedPassenger(
            List<Bogie> consist) {

        return consist.stream()

                .filter(PassengerBogie.class::isInstance)

                .map(PassengerBogie.class::cast)

                .max(Comparator.comparingInt(
                        PassengerBogie::getOccupiedSeats))

                .orElse(null);

    }

    public GoodsBogie highestLoadedGoods(
            List<Bogie> consist) {

        return consist.stream()

                .filter(GoodsBogie.class::isInstance)

                .map(GoodsBogie.class::cast)

                .max(Comparator.comparingDouble(
                        GoodsBogie::getCurrentLoad))

                .orElse(null);

    }

}