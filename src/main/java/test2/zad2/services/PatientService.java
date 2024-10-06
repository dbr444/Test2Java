package test2.zad2.services;

import test2.zad2.models.person.Doctor;
import test2.zad2.models.person.Patient;
import test2.zad2.models.Visit;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    public static List<Patient> findPatientWithMostVisits(List<Patient> patients, List<Visit> visits) {
        int[] visitCounts = new int[patients.size()];

        for (Visit visit : visits) {
            Patient patient = visit.getPatient();
            int patientIndex = findPatientIndex(patients, patient.getId());
            if (patientIndex != -1) {
                visitCounts[patientIndex]++;
            }
        }

        int maxVisits = 0;
        for (int count : visitCounts) {
            if (count > maxVisits) {
                maxVisits = count;
            }
        }

        List<Patient> patientsWithMostVisits = new ArrayList<>();
        for (int i = 0; i < visitCounts.length; i++) {
            if (visitCounts[i] == maxVisits) {
                patientsWithMostVisits.add(patients.get(i));
            }
        }

        return patientsWithMostVisits;
    }

    public static List<Patient> findPatientsWithAtLeast5Doctors(List<Patient> patients, List<Visit> visits) {
        List<Patient> min5visits = new ArrayList<>();

        for (Patient patient : patients) {
            int doctorCount = 0;
            List<Doctor> visitedDoctors = new ArrayList<>();

            for (Visit visit : visits) {
                if (visit.getPatient().equals(patient)) {
                    Doctor doctor = visit.getDoctor();
                    if (!visitedDoctors.contains(doctor)) {
                        visitedDoctors.add(doctor);
                        doctorCount++;
                    }
                }
            }

            if (doctorCount >= 5) {
                min5visits.add(patient);
            }
        }

        return min5visits;
    }

    private static int findPatientIndex(List<Patient> patients, int patientId) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == patientId) {
                return i;
            }
        }
        return -1;
    }
}
