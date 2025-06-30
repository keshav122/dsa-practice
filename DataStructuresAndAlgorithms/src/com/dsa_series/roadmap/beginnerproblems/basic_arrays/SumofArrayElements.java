package com.roadmap.beginnerproblems.basic_arrays;

public class SumofArrayElements {
    public int sum(int arr[], int n) {
        int sum = 0;
        // We iterate over the array and add each element to the sum
        for (int element : arr) {
            sum += element;
        }
        return sum;
    }
}
