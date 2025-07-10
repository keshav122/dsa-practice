# Search In A 2D Matrix II
- Start looking from the 1st/3rd quadrant diagonal endpoints so that the array is sorted and you can eliminate.

# Peak Element
- Take  low = 0 and high = m-1 (m columns are present)
and find the max element in the mid column and then compare the right and left .
- By already calculating the max element we are ensuring that the top and bottom values are already lesser and based on the left and right values we can either eliminate the halves or we have found the peak element .

# Median of 2D Array - row wise sorted
- We observe that (No. of elements <= median) will be greater than (half of total elements - i.e. (n * m)/2).
- Therefore we want to find the first element at which the number of elements is greater than half.
- We take low as min of first column and high as max of last column
- Then we take mid and calculate number of elements smaller than or equal to mid
- We can do that in O(log2 M * N) by using the upper bound for each of the row wise sorted rows (for N rows)
- If count <= half => low = mid + 1;
else high = mid -1;
- return low or take the ans variable and return ans


