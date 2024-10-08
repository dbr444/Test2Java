package test2.zad1.app;

import test2.zad1.models.Mother;
import test2.zad1.models.Child;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public List<Mother> loadMothers(String filename) {
        List<Mother> mothers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                int motherId = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                mothers.add(new Mother(motherId, name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mothers;
    }

    public List<Child> loadChildren(String filename, List<Mother> mothers) {
        List<Child> children = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                int childId = Integer.parseInt(data[0]);
                String gender = data[1];
                String name = data[2];
                LocalDate birthDate = LocalDate.parse(data[3]);
                int weight = Integer.parseInt(data[4]);
                int height = Integer.parseInt(data[5]);
                int motherId = Integer.parseInt(data[6]);

                Mother mother = mothers.stream()
                        .filter(m -> m.getId() == motherId)
                        .findFirst()
                        .orElse(null);

                if (mother != null) {
                    Child child = new Child(childId, gender, name, birthDate, weight, height, mother);
                    mother.addChild(child);
                    children.add(child);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return children;
    }
}
