package service;

import model.Bogie;
import persistance.FileManager;
import repository.TrainRepository;

import java.util.List;

public class PersistenceService {

    private final TrainRepository repository;

    private final FileManager manager =
            new FileManager();

    public PersistenceService(
            TrainRepository repository) {

        this.repository = repository;

    }

    public void saveTrain() {

        manager.save(

                repository.getAllBogies());

    }

    public void loadTrain() {

        List<Bogie> list =
                manager.load();

        repository.clear();

        for (Bogie bogie : list) {

            repository.attachRear(
                    bogie);

        }

    }

}
