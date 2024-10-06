package test2.zad2.app;

import test2.zad2.models.person.Doctor;
import test2.zad2.models.person.Patient;
import test2.zad2.models.Visit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public void assignVisitsToDoctors(List<Doctor> doctors, List<Visit> visits) {
        for (Doctor d : doctors) {
            for (Visit v : visits) {
                if (v.getDoctor().equals(d)) {
                    d.getVisits().add(v);
                }
            }
        }
    }

    public void assignVisitsToPatients(List<Patient> patients, List<Visit> visits) {
        for (Patient p : patients) {
            for (Visit v : visits) {
                if (v.getPatient().equals(p)) {
                    p.getVisits().add(v);
                }
            }
        }
    }

    private static List<String> processedNips = new ArrayList<>();

    public static List<Doctor> loadDoctors(String filename) {
        List<Doctor> doctors = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(filename));
        ) {
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length < 7) continue;

                int id = Integer.parseInt(parts[0]);
                String lastName = parts[1];
                String firstName = parts[2];
                String specialty = parts[3];
                String birthDate = formatDateString(parts[4]);
                String nip = parts[5];
                String pesel = parts[6];

                if (!isDuplicateNIP(nip)) {
                    processedNips.add(nip);
                    doctors.add(new Doctor(id, lastName, firstName, LocalDate.parse(birthDate), pesel, specialty, nip));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public static List<Patient> loadPatients(String filename) {
        List<Patient> patients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length < 5) continue;

                int id = Integer.parseInt(parts[0]);
                String lastName = parts[1];
                String firstName = parts[2];
                String pesel = parts[3];
                String birthDate = formatDateString(parts[4]);

                patients.add(new Patient(id, lastName, firstName, LocalDate.parse(birthDate), pesel));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return patients;
    }


    public List<Visit> loadVisits(String filename, List<Doctor> doctors, List<Patient> patients) {
        List<Visit> visits = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length < 3) continue;

                int doctorId = Integer.parseInt(parts[0]);
                int patientId = Integer.parseInt(parts[1]);
                String visitDateStr = formatDateString(parts[2]);

                Doctor doctor = findDoctorById(doctors, doctorId);
                Patient patient = findPatientById(patients, patientId);

                if (doctor != null && patient != null) {
                    visits.add(new Visit(doctor, patient, LocalDate.parse(visitDateStr)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return visits;
    }


    private Doctor findDoctorById(List<Doctor> doctors, int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }

    private Patient findPatientById(List<Patient> patients, int patientId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public static String formatDateString(String dateStr) throws IllegalArgumentException {
        String[] parts = dateStr.split("-");
        if (parts.length == 3) {
            String year = parts[0];
            String month = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
            String day = parts[2].length() == 1 ? "0" + parts[2] : parts[2];
            return year + "-" + month + "-" + day;
        }
        throw new IllegalArgumentException("Niepoprawny format daty: " + dateStr);
    }

    public static boolean isDuplicateNIP(String nip) {
        return processedNips.contains(nip);
    }
}
