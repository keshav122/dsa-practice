package com.dsa_series.roadmap.oops.advanced_oops_features;

class Counter {
    static int count;

    Counter() {
        count++;
    }

    static int getCount() {
        return count;
    }

    static void resetCount() {
        count = 0;
    }

}

// Please Do not change anything below, It is only for your reference.
/*
 * 
 * This is the driver code that will execute and demonstrate the functionality
 * of your `Counter` class.
 * 
 * It creates a object of class `Counter`, the default constructor increments
 * the count variable each time a object is created.
 * At the end we simply call the etCount method to print the total number of
 * objects instantiated.
 * 
 * // Main class to demonstrate the functionality of the Student class
 * public class Main {
 * 
 * public static void main(String[] args) {
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * int count = sc.nextInt();
 * 
 * while (count-- > 0) {
 * Counter obj = new Counter(); // Create Counter objects
 * }
 * 
 * System.out.println("Number of objects created : " + Counter.getCount());
 * 
 * sc.close();
 * }
 * }
 * 
 */
public class Static_Keyword_Practice {

}
