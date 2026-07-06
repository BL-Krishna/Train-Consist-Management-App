package repository;
import model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class TrainRepository {

    private final List<PassengerBogie> passengerBogies =
            new ArrayList<>();

    public void addBogie(PassengerBogie bogie) {

        passengerBogies.add(bogie);

    }

    public List<PassengerBogie> getAllBogies() {

        return passengerBogies;

    }

    public PassengerBogie findById(String bogieId) {

        for (PassengerBogie bogie : passengerBogies) {

            if (bogie.getBogieId().equalsIgnoreCase(bogieId)) {

                return bogie;

            }

        }

        return null;

    }

    public boolean removeBogie(String bogieId) {

        PassengerBogie bogie = findById(bogieId);

        if (bogie == null) {

            return false;

        }

        passengerBogies.remove(bogie);

        return true;
    }

    public int totalBogies() {

        return passengerBogies.size();

    }

}