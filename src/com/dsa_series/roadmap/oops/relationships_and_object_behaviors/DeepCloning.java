package com.dsa_series.roadmap.oops.relationships_and_object_behaviors;

class Passport implements Cloneable {
    String passportNumber;

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student implements Cloneable {
    String name;
    Passport passport;

    public Student(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Deep Cloning
        Student student = (Student) super.clone();
        student.passport = (Passport) passport.clone();
        return student;
    }
}

public class DeepCloning {

    public static void main(String[] args) throws CloneNotSupportedException {
        Passport passport = new Passport("AB887767");
        Student student = new Student("Raj", passport);

    }
}
