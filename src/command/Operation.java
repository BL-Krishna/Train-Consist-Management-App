package command;

import model.Bogie;

public class Operation {

    private final OperationType type;

    private final Bogie bogie;

    public Operation(OperationType type,
                     Bogie bogie) {

        this.type = type;
        this.bogie = bogie;

    }

    public OperationType getType() {

        return type;

    }

    public Bogie getBogie() {

        return bogie;

    }

}
