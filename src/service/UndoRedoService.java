package service;

import command.Operation;
import repository.TrainRepository;

import java.util.Stack;

public class UndoRedoService {

    private final Stack<Operation> undoStack =
            new Stack<>();

    private final Stack<Operation> redoStack =
            new Stack<>();

    private final TrainRepository repository;

    public UndoRedoService(
            TrainRepository repository) {

        this.repository = repository;

    }

    public void save(Operation operation) {

        undoStack.push(operation);

        redoStack.clear();

    }

    public void undo() {

        if (undoStack.isEmpty()) {

            System.out.println("Nothing to undo.");

            return;

        }

        Operation operation =
                undoStack.pop();

        switch (operation.getType()) {

            case ATTACH_FRONT ->

                    repository.removeFront();

            case ATTACH_REAR ->

                    repository.removeRear();

            case REMOVE_FRONT ->

                    repository.attachFront(
                            operation.getBogie());

            case REMOVE_REAR ->

                    repository.attachRear(
                            operation.getBogie());

        }

        redoStack.push(operation);

    }

    public void redo() {

        if (redoStack.isEmpty()) {

            System.out.println("Nothing to redo.");

            return;

        }

        Operation operation =
                redoStack.pop();

        switch (operation.getType()) {

            case ATTACH_FRONT ->

                    repository.attachFront(
                            operation.getBogie());

            case ATTACH_REAR ->

                    repository.attachRear(
                            operation.getBogie());

            case REMOVE_FRONT ->

                    repository.removeFront();

            case REMOVE_REAR ->

                    repository.removeRear();

        }

        undoStack.push(operation);

    }

}
