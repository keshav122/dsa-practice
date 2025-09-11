package com.dsa_series.roadmap.oops.relationships_and_object_behaviors;

class Passport {

    private String passportNumber;

    Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }
}

class Student {

    private String name;

    // Student class has passport class in it and owns it. - Strong relationship
    private Passport passport;

    Student(String name, String passportNumber) {
        this.name = name;
        // The instance of the Passport is created inside the Student class
        // Strong relationship
        this.passport = new Passport(passportNumber);
    }

    public void displayDetails() {
        System.out.println("Student Name : " + name);
        System.out.println("Passport Number : " + passport.getPassportNumber());
    }
}

public class Composition {

}
