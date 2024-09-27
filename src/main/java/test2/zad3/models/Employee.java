package test2.zad3.models;

public class Employee extends Person {
    private double salary;
    private String position;

    public Employee(String firstName, String lastName, String pesel, String city, String position, double salary) {
        super(firstName, lastName, pesel, city);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public double getIncome() {
        return salary;
    }

    @Override
    public String toString() {
        return getFirstName() + "\t" + getLastName() + "\t" + getPesel() + "\t" + getCity() + "\t" + position + "\t" + salary;
    }
}

