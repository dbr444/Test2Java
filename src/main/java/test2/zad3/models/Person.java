package test2.zad3.models;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String pesel;
    private String city;

    public Person(String firstName, String lastName, String pesel, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        setPesel(pesel);
        this.city = city;

        //tu jeszcze pomyslalem, ze spoko bedzie jak dodam taka dodatkowa mini walidacje do srpawdzania pesela:)
    }

    public String getPesel() {
        return pesel;
    }

    public String getGender() {
        return pesel.charAt(8) % 2 == 0 ? "Male" : "Female";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract double getIncome();

    private boolean isValidPesel(String pesel) {
        return pesel.matches("\\d{11}");
    }

    public void setPesel(String pesel) {
        if (isValidPesel(pesel)) {
            this.pesel = pesel;
        } else {
            throw new IllegalArgumentException("Invalid PESEL. It must be 11 digits long.");
        }
    }
}

