package test2.zad2.models;

import test2.zad2.models.person.Doctor;
import test2.zad2.models.person.Patient;

import java.time.LocalDate;

public class Visit {
    private Doctor doctor;
    private Patient patient;
    private LocalDate visitDate;

    public Visit(Doctor doctor, Patient patient, LocalDate visitDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.visitDate = visitDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }
}
