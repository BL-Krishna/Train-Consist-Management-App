package service;



import algorithm.*;
import comparator.BogieIdComparator;
import model.Bogie;
import repository.TrainRepository;

public class SortingService {

    private final TrainRepository repository;

    public SortingService(TrainRepository repository) {

        this.repository = repository;

    }

    public void bubbleSortById() {

        BubbleSort sort =
                new BubbleSort();

        sort.sort(
                repository.getAllBogies(),
                new BogieIdComparator());

    }

    public void selectionSortById() {

        SelectionSort sort =
                new SelectionSort();

        sort.sort(
                repository.getAllBogies(),
                new BogieIdComparator());

    }

    public void insertionSortById() {

        InsertionSort sort =
                new InsertionSort();

        sort.sort(
                repository.getAllBogies(),
                new BogieIdComparator());

    }

    public void mergeSortById() {

        MergeSort sort =
                new MergeSort();

        sort.sort(
                repository.getAllBogies(),
                new BogieIdComparator());

    }

}