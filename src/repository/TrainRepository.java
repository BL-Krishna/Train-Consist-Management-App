package repository;
import model.PassengerBogie;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class TrainRepository {

    private final LinkedList<PassengerBogie> consist =
            new LinkedList<>();

    private final Set<String> bogieIds =
            new HashSet<>();

    public void addFront(PassengerBogie bogie) {

        validateDuplicate(bogie);

        consist.addFirst(bogie);

        bogieIds.add(bogie.getBogieId());

    }

    public void addRear(PassengerBogie bogie) {

        validateDuplicate(bogie);

        consist.addLast(bogie);

        bogieIds.add(bogie.getBogieId());

    }

    private void validateDuplicate(PassengerBogie bogie) {

        if (bogieIds.contains(bogie.getBogieId())) {

            throw new IllegalArgumentException(
                    "Duplicate Bogie ID : "
                            + bogie.getBogieId());

        }

    }

    public PassengerBogie removeFront() {

        if (consist.isEmpty())
            return null;

        PassengerBogie bogie =
                consist.removeFirst();

        bogieIds.remove(bogie.getBogieId());

        return bogie;

    }

    public PassengerBogie removeRear() {

        if (consist.isEmpty())
            return null;

        PassengerBogie bogie =
                consist.removeLast();

        bogieIds.remove(bogie.getBogieId());

        return bogie;

    }

    public PassengerBogie getFront() {

        return consist.peekFirst();

    }

    public PassengerBogie getRear() {

        return consist.peekLast();

    }

    public List<PassengerBogie> getAllBogies() {

        return consist;

    }

    public int size() {

        return consist.size();

    }

}