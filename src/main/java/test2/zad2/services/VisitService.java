package test2.zad2.services;

import test2.zad2.models.Visit;

import java.time.LocalDate;
import java.util.List;

public class VisitService {
    public static int findYearWithMostVisits(List<Visit> visits) {
        if (visits.isEmpty()) {
            System.out.println("Brak wizyt");
        }

        int currentYear = LocalDate.now().getYear();
        int[] yearCount = new int[currentYear + 1];
        int maxVisits = 0;
        int yearWithMostVisits = 0;

        for (Visit visit : visits) {
            int year = visit.getVisitDate().getYear();
            yearCount[year]++;
            if (yearCount[year] > maxVisits) {
                maxVisits = yearCount[year];
                yearWithMostVisits = year;
            }
        }

        System.out.println("Year with most visits: ");
        return yearWithMostVisits;
    }
}
