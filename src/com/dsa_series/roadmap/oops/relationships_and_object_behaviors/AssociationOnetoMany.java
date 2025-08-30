package com.dsa_series.roadmap.oops.relationships_and_object_behaviors;

import java.util.List;

class Student {
    private String name;
    private String id;

    Student(String name) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Student Name : " + name);
    }
}

class College {

    private String name;
    private List<Student> students;

    College(String name) {
        this.name = name;
    }
}

public class AssociationOnetoMany {

}
