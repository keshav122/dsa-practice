package com.dsa_series.roadmap.oops.relationships_and_object_behaviors;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Name : " + students.get(i).getName());
        }
    }

}

public class AssociationManytoMany {

}
