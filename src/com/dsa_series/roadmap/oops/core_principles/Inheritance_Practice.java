package com.dsa_series.roadmap.oops.core_principles;

class Employee {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayDetails() {
        System.out.println("Name : " + name);
        System.out.println("Id : " + id);
    }
}

class Manager extends Employee {

    private int teamSize;

    Manager(String name, int id, int teamSize) {
        super(name, id);
        this.teamSize = teamSize;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size : " + teamSize);
    }
}

class Engineer extends Employee {
    private String specialization;

    Engineer(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization : " + specialization);
    }

}

public class Inheritance_Practice {

}
