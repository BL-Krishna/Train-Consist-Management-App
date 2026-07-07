package model;

import java.io.Serializable;

public abstract class Bogie implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String bogieId;

    protected BogieType bogieType;

    public Bogie(String bogieId,
                 BogieType bogieType) {

        this.bogieId = bogieId;
        this.bogieType = bogieType;

    }

    public String getBogieId() {

        return bogieId;

    }

    public BogieType getBogieType() {

        return bogieType;

    }

    @Override
    public String toString() {
        return null;
    }
}
