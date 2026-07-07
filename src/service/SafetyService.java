package service;

import exception.InvalidTrainException;
import model.Bogie;
import model.GoodsBogie;
import model.PassengerBogie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SafetyService {

    public void validateTrain(List<Bogie> consist) {

        if (consist.isEmpty()) {

            throw new InvalidTrainException(
                    "Train consist is empty.");

        }

        boolean passengerFound = false;

        Set<String> ids = new HashSet<>();

        for (Bogie bogie : consist) {

            if (!ids.add(bogie.getBogieId())) {

                throw new InvalidTrainException(
                        "Duplicate Bogie ID : "
                                + bogie.getBogieId());

            }

            if (bogie instanceof PassengerBogie passenger) {

                passengerFound = true;

                if (passenger.getOccupiedSeats()
                        > passenger.getSeatingCapacity()) {

                    throw new InvalidTrainException(

                            "Passenger capacity exceeded in "

                                    + passenger.getBogieId());

                }

            }

            if (bogie instanceof GoodsBogie goods) {

                if (goods.getCargoType() == null) {

                    throw new InvalidTrainException(

                            "Cargo type missing for "

                                    + goods.getBogieId());

                }

                if (goods.getCurrentLoad()
                        > goods.getMaximumCapacity()) {

                    throw new InvalidTrainException(

                            "Cargo overload in "

                                    + goods.getBogieId());

                }

            }

        }

        if (!passengerFound) {

            throw new InvalidTrainException(

                    "Train must contain at least one Passenger Bogie.");

        }

    }

}
