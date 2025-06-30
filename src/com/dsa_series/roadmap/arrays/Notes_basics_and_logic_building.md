### While doing problems like finding second largest element in an array
 - Clarify what do you want to return only if there is one number in the whole array like {10,10,10}
 - Also check whether negative numbers can be there or not in the array as lets say you have to return -1 if there are no secondLargest element but there are negative numbers in the array ,it can mess up your calculations.
 - For those cases , take the min value to be 'Integer.MIN_VALUE' and at last check if value is Integer.MIN_VALUE return -1.


 ### For rotate array by K places
 The basic logic is to create temp array and copy back the elements
 The optimal approach comes from observation that : {1,2,3,4,5,6} ; k= 2
 - reverse the first k elements : {2,1,3,4,5,6}
 - reverse the remaining n-k elemenets : {2,1,6,5,4,3}
 - reverse the array - {3,4,5,6,1,2}


### Move Zeroes To End : 
BF  : Count the non-zero elements , store them and copy them back and then put zero for all the other elements. 
Optimal : 
a. Keep j = -1; j denotes the first index where 0 occurs. Traverse to the first place where 0 occurs. If the j = -1; after complete traversal of the array ⇒ do nothing as there are no zeroes.
b. Otherwise start from i= j+ 1 to i = n ; if arr[i] ≠ 0 swap(arr[i],arr[j]) j++;


### Remove Duplicates From Sorted Array
- If the length of array is 0 return 0
- Take the lastUniqueIndex to be 0 and start the traversal from the index 1 taking currIndex to be 1
- If nums[currIndex] != nums[lastUniqueIndex] :
     - Increment the lastUniqueIndex
     - nums[lastUniqueIndex] = nums[currIndex]


