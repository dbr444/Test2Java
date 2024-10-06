package test2.zad1.models;

import java.time.LocalDate;

public class Child {
    private int id;
    private String gender;
    private String name;
    private LocalDate birthDate;
    private int weight;
    private int height;
    private Mother mother;

    public Child(int id, String gender, String name, LocalDate birthDate, int weight, int height, Mother mother) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
        this.mother = mother;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public Mother getMother() {
        return mother;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}