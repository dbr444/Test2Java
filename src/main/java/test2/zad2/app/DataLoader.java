package test2.zad2.app;

import test2.zad2.models.Doctor;
import test2.zad2.models.Patient;
import test2.zad2.models.Visit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    private static List<String> processedNips = new ArrayList<>();

    public static List<Doctor> loadDoctors(String filename) throws IOException {
        List<Doctor> doctors = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
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
                doctors.add(new Doctor(id, lastName, firstName, specialty, LocalDate.parse(birthDate), nip, pesel));
            }
        }
        reader.close();
        return doctors;
    }

    public static List<Patient> loadPatients(String filename) throws IOException {
        List<Patient> patients = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length < 5) continue;

            int patientId = Integer.parseInt(parts[0]);
            String surname = parts[1];
            String name = parts[2];
            String pesel = parts[3];
            String birthDate = formatDateString(parts[4]);

            patients.add(new Patient(patientId, surname, name, pesel, LocalDate.parse(birthDate)));
        }
        reader.close();
        return patients;
    }

    public List<Visit> loadVisits(String filename, List<Doctor> doctors, List<Patient> patients) throws IOException {
        List<Visit> visits = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length < 3) continue;

            int doctorId = Integer.parseInt(parts[0]);
            int patientId = Integer.parseInt(parts[1]);
            String visitDateStr = parts[2];

            visitDateStr = formatDateString(visitDateStr);

            if (isDoctorExists(doctorId, doctors) && isPatientExists(patientId, patients)) {
                visits.add(new Visit(doctorId, patientId, LocalDate.parse(visitDateStr)));
            }
        }
        reader.close();
        return visits;
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

    private boolean isDoctorExists(int doctorId, List<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == doctorId) {
                return true;
            }
        }
        return false;
    }

    private boolean isPatientExists(int patientId, List<Patient> patients) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return true;
            }
        }
        return false;
    }
}
