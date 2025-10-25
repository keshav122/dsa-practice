/*Author: keshav122 */
package com.dsa_series.roadmap.oops.relationships_and_object_behaviors;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private String id;

    Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Student Name : " + name);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class College {

    private String name;
    private List<Student> students;

    College(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public void printAllStudents() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("Name " + student.getName() + " id : " + student.getId());
        }
    }
}

public class AssociationOnetoMany {

}
