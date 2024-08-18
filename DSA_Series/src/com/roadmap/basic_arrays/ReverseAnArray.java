package com.roadmap.basic_arrays;

public class ReverseAnArray {
    public int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        // We iterate from start to end and swap the values at the start and the end
        // and increment and decrement the start and end pointers respectively.
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
