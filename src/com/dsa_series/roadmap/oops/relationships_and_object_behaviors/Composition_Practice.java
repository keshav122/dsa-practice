package com.dsa_series.roadmap.oops.relationships_and_object_behaviors;

import java.util.ArrayList;
import java.util.List;

class College {
    String name;
    String id;

    public College(String name, String id) {
        this.name = name;
        this.id = id;
    }
}

class University {
    String name;
    List<College> colleges;

    public University(String name) {
        this.name = name;
        this.colleges = new ArrayList<College>();
    }

    public void addCollege(String collegeName, String collegeId) {
        colleges.add(new College(collegeName, collegeId));
    }

    public void displayDetails() {
        System.out.println("University Name : " + name);
        for (College college : colleges) {
            System.out.println("College Name : " + college.name);
            System.out.println("College ID : " + college.id);
        }
    }
}

// Please Do not change anything below, It is only for your reference.
/*
 * 
 * This is the driver code that will execute and demonstrate the functionality
 * of your class `University` and the class 'College'.
 * 
 * 
 * public class Main {
 * 
 * public static void main(String[] args) {
 * 
 * Scanner scanner = new Scanner(System.in);
 * 
 * String name;
 * List<String> collegeName, collegeId;
 * 
 * //creating the object of class University with the name as constructor
 * argument
 * University university = new University(name);
 * 
 * //adding the collge names and id using the addCollege mthod called through
 * the university object
 * for (int j = 0; j < collegeName.size(); j++) {
 * university.addCollege(collegeName.get(j), collegeId.get(j));
 * }
 * 
 * //calling the method displayDetails through the university object
 * university.displayDetails();
 * 
 * scanner.close();
 * }
 * }
 * 
 */

/*
 * //Below is the output format
 * 
 * System.out.println("University Name : " + name);
 * System.out.println("College Name : " + name);
 * System.out.println("College ID : " + id);
 * 
 */
public class Composition_Practice {

}
