package repository;
import model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class TrainRepository {

    private final List<PassengerBogie> passengerBogies =
            new ArrayList<>();

    private final Set<String> bogieIds =
            new HashSet<>();

    public void addBogie(PassengerBogie bogie) {

        if (bogieIds.contains(bogie.getBogieId())) {

            throw new IllegalArgumentException(
                    "Duplicate Bogie ID : " + bogie.getBogieId()
            );

        }

        passengerBogies.add(bogie);

        bogieIds.add(bogie.getBogieId());

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

        PassengerBogie bogie =
                findById(bogieId);

        if (bogie == null) {

            return false;

        }

        passengerBogies.remove(bogie);

        bogieIds.remove(bogieId);

        return true;

    }

    public boolean containsId(String bogieId) {

        return bogieIds.contains(bogieId);

    }

    public int totalBogies() {

        return passengerBogies.size();

    }

}