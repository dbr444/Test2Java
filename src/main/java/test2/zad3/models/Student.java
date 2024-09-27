package test2.zad3.models;
public class Student extends Person {
    private double scholarship;
    private String group;

    public Student(String firstName, String lastName, String pesel, String city, String group, double scholarship) {
        super(firstName, lastName, pesel, city);
        this.group = group;
        this.scholarship = scholarship;
    }

    @Override
    public double getIncome() {
        return scholarship;
    }

    public double getScholarship() {
        return scholarship;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return getFirstName() + "\t" + getLastName() + "\t" + getPesel() + "\t" + getCity() + "\t" + getGroup() + "\t" + getScholarship();
    }
}
