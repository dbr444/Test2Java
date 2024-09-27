package test2.zad2.models;

import java.time.LocalDate;

public class Patient {
    private int id;
    private String surname;
    private String name;
    private String pesel;
    private LocalDate birthDate;

    public Patient(int id, String surname, String name, String pesel, LocalDate birthDate) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.pesel = pesel;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Patient: " + surname + " " + name;
    }
}
