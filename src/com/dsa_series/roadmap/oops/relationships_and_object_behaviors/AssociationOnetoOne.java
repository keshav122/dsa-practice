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

// Any Student will have 1 Passport
public class AssociationOnetoOne {

    public static void main(String[] args) {
        Passport passport = new Passport("89989933");
        Student student = new Student("Raj", passport);
        student.displayDetails();
    }
}
