package test2.zad3.services;

import test2.zad3.models.Person;

import java.util.List;

public class PersonService {
    public static int countFemales(List<Person> persons) {
        int count = 0;
        for (Person person : persons) {
            if (person.getGender().equals("Female")) {
                count++;
            }
        }
        return count;
    }

    public static Person findRichestPerson(List<Person> persons) {
        Person richestPerson = null;
        double maxIncome = 0;

        for (Person person : persons) {
            double income = person.getIncome();
            if (income > maxIncome) {
                maxIncome = income;
                richestPerson = person;
            }
        }
        return richestPerson;
    }
}
