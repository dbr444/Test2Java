package test2.zad2.models;

import java.time.LocalDate;

public class Doctor {
    private int id;
    private String surname;
    private String name;
    private String specialization;
    private LocalDate birthDate;
    private String nip;
    private String pesel;

    public Doctor(int id, String surname, String name, String specialization, LocalDate birthDate, String nip, String pesel) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.specialization = specialization;
        this.birthDate = birthDate;
        this.nip = nip;
        this.pesel = pesel;
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

    public String getSpecialization() {
        return specialization;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
