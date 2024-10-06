package test2.zad2.services;

import test2.zad2.models.person.Doctor;
import test2.zad2.models.Visit;

import java.util.*;

public class DoctorService {

    public static Doctor findDoctorWithMostVisits(List<Doctor> doctors, List<Visit> visits) {
        int[] visitCounts = new int[doctors.size()];

        for (Visit visit : visits) {
            Doctor doctor = visit.getDoctor();
            int doctorIndex = findDoctorIndex(doctors, doctor.getId());

            if (doctorIndex != -1) {
                visitCounts[doctorIndex]++;
            }
        }


        int maxIndex = 0;
        for (int i = 1; i < visitCounts.length; i++) {
            if (visitCounts[i] > visitCounts[maxIndex]) {
                maxIndex = i;
            }
        }

        return doctors.get(maxIndex);
    }

    public static List<Doctor> getTop5OldestDoctors(List<Doctor> doctors) {
        Collections.sort(doctors, Comparator.comparing(Doctor::getBirthDate));
        return doctors.subList(0, Math.min(5, doctors.size()));
    }

    public static List<Doctor> getTop5DoctorsWithMostVisits(List<Doctor> doctors, List<Visit> visits) {
        int[] visitCounts = new int[doctors.size()];

        for (Visit visit : visits) {
            Doctor doctor = visit.getDoctor();
            int doctorIndex = findDoctorIndex(doctors, doctor.getId());
            if (doctorIndex != -1) {
                visitCounts[doctorIndex]++;
            }
        }

        List<Doctor> sortedDoctors = new ArrayList<>(doctors);

        sortedDoctors.sort((d1, d2) -> {
            int index1 = findDoctorIndex(doctors, d1.getId());
            int index2 = findDoctorIndex(doctors, d2.getId());
            int compareVisits = Integer.compare(visitCounts[index2], visitCounts[index1]);

            if (compareVisits != 0) {
                return compareVisits;
            } else {
                return Integer.compare(index2, index1);
            }
        });

        return sortedDoctors.subList(0, Math.min(5, sortedDoctors.size()));
    }


    public static String findMostPopularSpecialization(List<Doctor> doctors, List<Visit> visits) {
        String[] specializations = new String[doctors.size()];
        int[] specializationCount = new int[doctors.size()];

        for (int i = 0; i < doctors.size(); i++) {
            specializations[i] = doctors.get(i).getSpecialization();
        }

        for (Visit visit : visits) {
            Doctor doctor = visit.getDoctor();
            int doctorIndex = findDoctorIndex(doctors, doctor.getId());
            if (doctorIndex != -1) {
                String specialization = specializations[doctorIndex];

                for (int j = 0; j < doctors.size(); j++) {
                    if (specializations[j].equals(specialization)) {
                        specializationCount[j]++;
                        break;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < specializationCount.length; i++) {
            if (specializationCount[i] > specializationCount[maxIndex]) {
                maxIndex = i;
            }
        }

        return specializations[maxIndex];
    }

    public static List<Doctor> findDoctorsWithOnePatient(List<Doctor> doctors, List<Visit> visits) {
        List<Doctor> result = new ArrayList<>();
        int[] patientCount = new int[doctors.size()];

        for (Visit visit : visits) {
            Doctor doctor = visit.getDoctor();
            int doctorIndex = findDoctorIndex(doctors, doctor.getId());
            if (doctorIndex != -1) {
                patientCount[doctorIndex]++;
            }
        }

        for (int i = 0; i < doctors.size(); i++) {
            if (patientCount[i] == 1) {
                result.add(doctors.get(i));

            }
        }

        return result;
    }

    private static int findDoctorIndex(List<Doctor> doctors, int doctorId) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == doctorId) {
                return i;
            }
        }
        return -1;
    }

}
