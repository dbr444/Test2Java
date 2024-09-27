package test2.zad3.app;

import test2.zad3.models.Employee;
import test2.zad3.models.Person;
import test2.zad3.models.Student;
import test2.zad3.services.FileService;
import test2.zad3.services.PersonService;

import java.io.IOException;
import java.util.List;

public class PersonsRunner {
    public static void main(String[] args) {

        Student student = new Student("John", "Wick", "12345678401", "New York", "CS101", 1500);
        Employee employee = new Employee("Angelina", "Jolie", "23456789782", "Los Angeles", "Developer", 5000);
        Student student2 = new Student("Nina", "Dobrev", "34567890123", "Chicago", "CS102", 1200);

        List <Person> persons = List.of(student, employee, student2);

        //save do pliku

        String filename = "persons.txt";
        try {
            FileService.savePersonsToFile(persons, filename);
            System.out.println("saved to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving persons: " + e.getMessage());
        }

        // osoba z najwieskzym dochodem
        Person richestPerson = PersonService.findRichestPerson(persons);
        if (richestPerson != null) {
            System.out.println("The person with the highest income is: " + richestPerson.getFirstName() + " " + richestPerson.getLastName() + " with income: " + richestPerson.getIncome());
        }

        //zliczam kobitki

        int femaleCount = PersonService.countFemales(persons);
        System.out.println("Number of females: " + femaleCount);
    }
}
