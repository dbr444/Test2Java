package test2.zad2.models.person;

import test2.zad2.models.Visit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Person {
    protected int id;
    protected String surname;
    protected String name;
    protected LocalDate birthDate;
    protected String pesel;
    protected List<Visit> visits = new ArrayList<>();

    public Person(int id, String surname, String name, LocalDate birthDate, String pesel) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPesel() {
        return pesel;
    }

    public List<Visit> getVisits() {
        return visits;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() && Objects.equals(getSurname(), person.getSurname()) && Objects.equals(getName(), person.getName()) && Objects.equals(getBirthDate(), person.getBirthDate()) && Objects.equals(getPesel(), person.getPesel()) && Objects.equals(getVisits(), person.getVisits());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSurname(), getName(), getBirthDate(), getPesel(), getVisits());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", pesel='" + pesel + '\'';
    }
}