package service;


import model.*;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsService {

    public Map<BogieType, Long> bogieCountByType(
            List<Bogie> consist) {

        return consist.stream()

                .collect(Collectors.groupingBy(

                        Bogie::getBogieType,

                        Collectors.counting()

                ));

    }

    public Map<CargoType, Long> cargoCount(
            List<Bogie> consist) {

        return consist.stream()

                .filter(GoodsBogie.class::isInstance)

                .map(GoodsBogie.class::cast)

                .collect(Collectors.groupingBy(

                        GoodsBogie::getCargoType,

                        Collectors.counting()

                ));

    }

    public double averagePassengerOccupancy(
            List<Bogie> consist) {

        return consist.stream()

                .filter(PassengerBogie.class::isInstance)

                .map(PassengerBogie.class::cast)

                .collect(Collectors.averagingInt(

                        PassengerBogie::getOccupiedSeats

                ));

    }

    public double averageCargoLoad(
            List<Bogie> consist) {

        return consist.stream()

                .filter(GoodsBogie.class::isInstance)

                .map(GoodsBogie.class::cast)

                .collect(Collectors.averagingDouble(

                        GoodsBogie::getCurrentLoad

                ));

    }

    public PassengerBogie topPassengerBogie(
            List<Bogie> consist) {

        return consist.stream()

                .filter(PassengerBogie.class::isInstance)

                .map(PassengerBogie.class::cast)

                .max(

                        Comparator.comparingInt(

                                PassengerBogie::getOccupiedSeats

                        )

                )

                .orElse(null);

    }

    public GoodsBogie topGoodsBogie(
            List<Bogie> consist) {

        return consist.stream()

                .filter(GoodsBogie.class::isInstance)

                .map(GoodsBogie.class::cast)

                .max(

                        Comparator.comparingDouble(

                                GoodsBogie::getCurrentLoad

                        )

                )

                .orElse(null);

    }

    public IntSummaryStatistics passengerStatistics(
            List<Bogie> consist) {

        return consist.stream()

                .filter(PassengerBogie.class::isInstance)

                .map(PassengerBogie.class::cast)

                .collect(Collectors.summarizingInt(

                        PassengerBogie::getOccupiedSeats

                ));

    }

    public DoubleSummaryStatistics cargoStatistics(
            List<Bogie> consist) {

        return consist.stream()

                .filter(GoodsBogie.class::isInstance)

                .map(GoodsBogie.class::cast)

                .collect(Collectors.summarizingDouble(

                        GoodsBogie::getCurrentLoad

                ));

    }

}
