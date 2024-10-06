package test2.zad2.models.person;

import java.time.LocalDate;
import java.util.Objects;

public class Doctor extends Person {
    private String specialization;
    private String nip;

    public Doctor(int id, String surname, String name, LocalDate birthDate, String pesel, String specialization, String nip) {
        super(id, surname, name, birthDate, pesel);
        this.specialization = specialization;
        this.nip = nip;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getSpecialization(), doctor.getSpecialization()) && Objects.equals(nip, doctor.nip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSpecialization(), nip);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", specialization='" + specialization + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }
}
