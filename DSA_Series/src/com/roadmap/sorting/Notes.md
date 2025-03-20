#Sorting

## Selection sort :
Pushes the min to the first
The idea is that we select the minimum out of the array and place it at its correct position.  We repeat this for n-1 times and the array should be sorted.

Steps :
Select the starting index of the unsorted part using a loop with 'i' from 0 to n-1

Find the smallest element in the range from 'i+1' to n-1 using an inner loop.

Swap this smaller element with the index at i
Repeat the process for the next starting index.

## Bubble Sort :

Pushes the largest to the last using adjacent swapping 
After 1 full round of adjacent swaps the largest number will be at the last 
We need to perform n-1 such rounds

Steps 
Run a loop of i from n-1 to 0
keep a track whether any swaps are made
run a inner loop of j from 0 to i-1 => if nums[j] > nums[j+1] swap. set isSwapped to true
If no swaps are made , break out of the loop


