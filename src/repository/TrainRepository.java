package repository;

import model.Bogie;

import java.util.*;

public class TrainRepository {

    private final LinkedList<Bogie> consist =
            new LinkedList<>();

    private final Set<String> bogieIds =
            new HashSet<>();

    public void attachFront(Bogie bogie) {

        validateDuplicate(bogie);

        consist.addFirst(bogie);

        bogieIds.add(bogie.getBogieId());

    }

    public void attachRear(Bogie bogie) {

        validateDuplicate(bogie);

        consist.addLast(bogie);

        bogieIds.add(bogie.getBogieId());

    }

    private void validateDuplicate(Bogie bogie) {

        if (bogieIds.contains(bogie.getBogieId()))

            throw new IllegalArgumentException(
                    "Duplicate Bogie ID : "
                            + bogie.getBogieId());

    }

    public List<Bogie> getAllBogies() {

        return consist;

    }

}