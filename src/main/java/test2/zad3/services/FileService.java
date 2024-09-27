package test2.zad3.services;

import test2.zad3.models.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileService {
    public static void savePersonsToFile(List<Person> persons, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (Person person : persons) {
                writer.write(person.toString());
                writer.newLine();
            }
        }
    }
}
