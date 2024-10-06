package test2.zad2.models.person;

import java.time.LocalDate;
import java.util.List;

public class Patient extends Person {
    public Patient(int id, String surname, String name, LocalDate birthDate, String pesel) {
        super(id, surname, name, birthDate, pesel);
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


}
