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
3. This involves swapping until the selected element is in it's correct position. 
4. Continue this process until the array is sorted 
