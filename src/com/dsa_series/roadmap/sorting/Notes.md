# Sorting

## Selection sort :
Pushes the min to the first
The idea is that we select the minimum out of the array and place it at its correct position.  We repeat this for n-1 times and the array should be sorted.

Steps :
1. Select the starting index of the unsorted part using a loop with 'i' from 0 to n-1
2. Find the smallest element in the range from 'i+1' to n-1 using an inner loop.
3. Swap this smaller element with the index at i.
4. Repeat the process for the next starting index.

## Bubble Sort :

- Pushes the largest to the last using adjacent swapping  . After 1 full round of adjacent swaps the largest number will be at the last .We need to perform n-1 such rounds

Steps 
1. Run a loop of i from n-1 to 0
2. keep a track whether any swaps are made
3. run a inner loop of j from 0 to i-1 => if nums[j] > nums[j+1] swap. 
    a. set isSwapped to true
    b. If no swaps are made , break out of the loop

## Insertion Sort 
Imagine two regions : sorted and unsorted
Pick one element from unsorted and place it into the sorted region
Similar to how we would Sort a set of playing cards in our hand. 

Approach:
In each iteration,  select an element from the unsorted part of the array using an outer loop.

1. Place this element in it's correct position within the sorted part of the array. 
2. Use an inner loop to shift the remaining elements as necessary to accommodate the seleted element. 
3. This involves shifting until the selected element is in it's correct position. 
4. Continue this process until the array is sorted 



## Merge Sort 
The merge sort works on the divide and conquer technique, it divides the arrays into two halves until we reach to a level where each half contains only one element, which is by default sorted. Then we merge the two sorted halves which is basically merging two sorted arrays.
Algo looks like:

mergeSort(arr, sI, eI): // where sI - startIndex and eI- endIndex
     int mid = (sI + eI)/2
     mergeSort(arr, sI, mid);
     mergeSort(arr, mid+1, eI);
     mergeTwoSortedArrays(arr,sI,mid,eI);

One of the key points in mergingTwoSortedArrays is to take a temp array and make changes and then copy back , rather than making the changes inplace in the input array.

TC : O(NlogN)
SC : O(N)

## Quick Sort
Quick Sort is also an divide and conquer algorithm. The idea is:
1. Pick a pivot element(it can be anything : first , last , median or any random element of the array) and place in its correct place (as it will be placed in the sorted array).
2. Elements smaller than the pivotElement should be on left whereas elements greater than the pivotElement should be on the right.
3. Repeat these steps until the array is sorted.

Pseudocode:
        qs(arr,low,high):
            int pivotIndex = pivotIndex(arr,low, high);// pivotIndex is the correct position of // the pivot element
            qs(arr, low ,pivotIndex-1);
            qs(arr,pivotIndex + 1, high);

        pivotIndex(arr,low,high):
            pivotElem = arr[low]
            int i = low , j = high;
            while(i< j):
                while(arr[i] <= pivotElem && i< high) {i++};
                while(arr[j] > pivotElem && j> low) {j--};
                if(i<j) swap(arr[i],arr[j])
            
            swap(arr[low],arr[j]);
            return j;


