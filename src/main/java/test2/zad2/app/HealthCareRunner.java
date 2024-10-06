package test2.zad2.app;

import test2.zad2.models.person.Doctor;
import test2.zad2.models.person.Patient;
import test2.zad2.models.Visit;
import test2.zad2.services.DoctorService;
import test2.zad2.services.PatientService;
import test2.zad2.services.VisitService;

import java.io.IOException;
import java.util.List;

public class HealthCareRunner {
    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();

        List<Doctor> doctors = dataLoader.loadDoctors("lekarze.txt");
        List<Patient> patients = dataLoader.loadPatients("pacjenci.txt");
        List<Visit> visits = dataLoader.loadVisits("wizyty.txt", doctors, patients);
        dataLoader.assignVisitsToDoctors(doctors, visits);
        dataLoader.assignVisitsToPatients(patients, visits);

        // 1. Znajdź lekarza, który miał najwięcej wizyt
        Doctor doctorWithMostVisits = DoctorService.findDoctorWithMostVisits(doctors, visits);
        System.out.println("Doctor with most visits:");
        System.out.println(doctorWithMostVisits.getName() + " " + doctorWithMostVisits.getSurname());
        System.out.println("**************************************************************");

        // 2. Znajdź pacjenta, który miał najwięcej wizyt
        List<Patient> patientsWithMostVisits = PatientService.findPatientWithMostVisits(patients, visits);
        System.out.println("Patient(s) with most visits:");
        for (Patient patient : patientsWithMostVisits) {
            System.out.println(patient.getName() + " " + patient.getSurname());
        }
        System.out.println("**************************************************************");


        // 3. Ktora specjalizacja cieszy się największym powodzeniem?
        String mostPopularSpecialization = DoctorService.findMostPopularSpecialization(doctors, visits);
        System.out.println("Most popular specialization: " + mostPopularSpecialization);
        System.out.println("**************************************************************");


        // 4. Którego roku było najwięcej wizyt?
        int yearWithMostVisits = VisitService.findYearWithMostVisits(visits);
        System.out.println(yearWithMostVisits);
        System.out.println("**************************************************************");


        // 5. Wypisz top 5 najstarszych lekarzy
        List<Doctor> top5OldestDoctors = DoctorService.getTop5OldestDoctors(doctors);
        System.out.println("Top 5 oldest doctors:");
        for (Doctor doctor : top5OldestDoctors) {
            System.out.println(doctor.getName() + " " + doctor.getSurname());
        }
        System.out.println("**************************************************************");


        // 6. Wypisz top 5 lekarzy, co mieli najwięcej wizyt
        List<Doctor> top5DoctorsWithMostVisits = DoctorService.getTop5DoctorsWithMostVisits(doctors, visits);

        System.out.println("Top 5 doctors with most visits:");
        for (Doctor doctor : top5DoctorsWithMostVisits) {
            System.out.println(doctor.getName() + " " + doctor.getSurname());
        }
        System.out.println("**************************************************************");


        // 7. Zwróć pacjentów, którzy byli u minimum 5 różnych lekarzy
        List<Patient> patientsWith5Doctors = PatientService.findPatientsWithAtLeast5Doctors(patients, visits);
        if (patientsWith5Doctors.isEmpty()) {
            System.out.println("No patient has visited at least 5 different doctors.");
        } else {
            System.out.println("Patients with at least 5 different doctors:");
        }
        for (Patient patient : patientsWith5Doctors) {
            System.out.println(patient.getName());
        }
        System.out.println("**************************************************************");


        // 8. Zwróć lekarzy, którzy przyjęli tylko jednego pacjenta
        List<Doctor> doctorsWithOnePatient = DoctorService.findDoctorsWithOnePatient(doctors, visits);
        if (doctorsWithOnePatient.isEmpty()) {
            System.out.println("No doctor accepted only one patient.");
        } else {
            System.out.println("Doctors who accepted only one patient: ");
        }
        for (Doctor doctor : doctorsWithOnePatient) {
            System.out.println(doctor.getName());
        }
        System.out.println("**************************************************************");


    }
}
