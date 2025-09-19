package com.dsa_series.roadmap.oops.advance_programming_in_oops;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHandling {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(5);
        try {
            System.out.println(arr.get(5));
        } catch (Exception e) {
            System.out.println("Exception occured : " + e.getMessage());
        } finally {
            System.out.println("this line will be executed");
            // Typically used for closing resources
        }

    }
}
