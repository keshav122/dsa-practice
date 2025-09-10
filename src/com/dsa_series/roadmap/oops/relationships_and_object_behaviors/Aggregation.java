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

    // Student class has passport class in it but doesn't own it. - Weak
    // relationship
    private Passport passport;

    Student(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    public void displayDetails() {
        System.out.println("Student Name : " + name);
        System.out.println("Passport Number : " + passport.getPassportNumber());
    }
}

public class Aggregation {

}
