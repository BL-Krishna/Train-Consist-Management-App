package persistance;

import model.Bogie;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME =
            "train.dat";

    public void save(List<Bogie> consist) {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(

                             new FileOutputStream(FILE_NAME))) {

            output.writeObject(
                    new LinkedList<>(consist));

            System.out.println("Train saved successfully.");

        }

        catch (IOException exception) {

            exception.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")
    public List<Bogie> load() {

        try (ObjectInputStream input =
                     new ObjectInputStream(

                             new FileInputStream(FILE_NAME))) {

            return (LinkedList<Bogie>)
                    input.readObject();

        }

        catch (IOException |
               ClassNotFoundException exception) {

            exception.printStackTrace();

        }

        return new LinkedList<>();

    }

}
