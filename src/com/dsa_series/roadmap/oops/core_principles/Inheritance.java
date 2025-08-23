package com.dsa_series.roadmap.oops.core_principles;

//Parent class or Super class
class School {
    private String name;

    School() {
        name = "DPS";
    }

    void printSchoolName() {
        System.out.println("School Name : " + name);
    }
}

// Child class or subclass
class Student extends School {
    private String name;

    Student(String name) {
        this.name = name;
    }

    void printStudentName() {
        System.out.println("Student Name : " + name);
    }
}

class Parent extends Student {
    private String name;

    Parent(String name, String studentName) {
        super(studentName);
        this.name = name;
    }

    void printParentName() {
        System.out.println("Parent Name : " + name);
    }

}

class Teacher extends School {
    private String name;
    private String subjectName;

    Teacher(String name, String subjectName) {
        this.name = name;
        this.subjectName = subjectName;
    }

    void printTeacherInfo() {
        System.out.println("Name : " + name);
        System.out.println("Subject Name : " + subjectName);
    }
}

public class Inheritance {

    public static void main(String[] args) {
        Parent p = new Parent("Dad", "Keshav");
        p.printStudentName();
        p.printParentName();
        p.printSchoolName();
    }
}