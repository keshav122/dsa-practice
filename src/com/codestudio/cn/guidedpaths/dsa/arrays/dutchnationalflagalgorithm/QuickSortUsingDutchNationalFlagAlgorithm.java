package com.codestudio.cn.guidedpaths.dsa.arrays.dutchnationalflagalgorithm;

/*
Time Complexity: O(N * log(N))
Space Complexity: O(log N)

Where 'N' is the number of elements in the given array/list.
*/

import java.util.ArrayList;
import java.util.Collections;

public class QuickSortUsingDutchNationalFlagAlgorithm 
{
public static void partition(ArrayList<Integer> arr, int beg, int last, int[] start, int[] mid) 
{
    int pivot = arr.get(last);
    int end = last;

    // Iterate while mid is not greater than end.
    while (mid[0] <= end) 
    {
        // Place the element at the starting if it's value is less than pivot.
        if (arr.get(mid[0]) < pivot) 
        {

            Collections.swap(arr, mid[0], start[0]);

            mid[0] = mid[0] + 1;
            start[0] = start[0] + 1;
        }

        // Place the element at the end if it's value is greater than pivot.
        else if (arr.get(mid[0]) > pivot) 
        {

            Collections.swap(arr, mid[0], end);

            end = end - 1;
        }
        else 
        {
            mid[0] = mid[0] + 1;
        }
    }
}

// An auxiallary function to sort the array.
public static void quicksort(ArrayList<Integer> arr, int beg, int last) 
{
    // Base case when the size of array is 1.
    if (beg >= last) 
    {
        return;
    }

    // To handle the case when there are only 2 elements in the array.
    if (last == beg + 1) 
    {
        if (arr.get(beg) > arr.get(last)) 
        {

            Collections.swap(arr, beg, last);

            return;
        }
    }


    int [] start = {beg};
    int [] mid = {beg};


    // Function to partition the array.
    partition(arr, beg, last, start, mid);

    // Recursively sort the left and the right partitions.
    quicksort(arr, beg, start[0] - 1);
    quicksort(arr, mid[0], last);

}

public static ArrayList<Integer> quickSortUsingDutchNationalFlag(ArrayList<Integer> arr) 
{
    // Call the quicksort function.
    quicksort(arr, 0, arr.size() - 1);

    // Return the array/list after sorting.
    return arr;
}
}