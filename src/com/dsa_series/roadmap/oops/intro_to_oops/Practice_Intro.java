package com.dsa_series.roadmap.oops.intro_to_oops;

// Your code goes here

class Student {
    private String name;
    private int rollNumber;

    public void setDetails(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public void displayDetails() {
        System.out.println("Name : " + this.name);
        System.out.println("Roll Number : " + this.rollNumber);
    }
}

// Please Do not change anything below, It is only for your reference.
/*
 * 
 * This is the driver code that will execute and demonstrate the functionality
 * of your `Student` class.
 * 
 * It creates a `Student` object, initializes its details using user input, and
 * displays the details using the provided methods.
 * 
 * // Main class to demonstrate the functionality of the Student class
 * public class Main {
 * public static void main(String[] args) {
 * 
 * // Create a Scanner object for taking input from the user
 * Scanner sc = new Scanner(System.in);
 * 
 * String name = sc.nextLine(); // Read the name as a string input
 * 
 * int rollNumber = sc.nextInt(); // Read the roll number as an integer input
 * 
 * // Create an object of the Student class
 * Student student = new Student();
 * 
 * // Set the details of the student using the setDetails() method
 * student.setDetails(name, rollNumber);
 * 
 * // Display the student's details using the displayDetails() method
 * student.displayDetails();
 * 
 * // Close the Scanner to free resources
 * sc.close();
 * }
 * }
 * 
 */

/*
 * //Below are the output statements
 * 
 * System.out.println("Name : " + this.name);
 * System.out.println("Roll Number : " + this.rollNumber);
 * 
 */
