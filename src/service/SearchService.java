package service;

import algorithm.BinarySearch;
import algorithm.LinearSearch;
import comparator.BogieIdComparator;
import model.Bogie;
import repository.TrainRepository;

public class SearchService {

    private final TrainRepository repository;

    public SearchService(TrainRepository repository) {

        this.repository = repository;

    }

    public Bogie linearSearch(String bogieId) {

        return new LinearSearch()

                .search(

                        repository.getAllBogies(),

                        bogieId

                );

    }

    public Bogie binarySearch(String bogieId) {

        return new BinarySearch()

                .search(

                        repository.getAllBogies(),

                        bogieId,

                        new BogieIdComparator()

                );

    }

}