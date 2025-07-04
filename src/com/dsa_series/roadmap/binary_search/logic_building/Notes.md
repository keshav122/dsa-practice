# Search In Rotated Sorted Array 
In which only unique elements are present , we need to observe which half is sorted hai and then the element is present in that half or not. If yes, then keep otherwise eliminate  that half.
- One more thing to keep in mind is to check nums[left] ≤ nums[mid] , not only less than but equals to in cases where the left and right search spaces are reduced to 1. For eg : arr : [2,1] and k = 1;

# Search In Rotated Sorted Array II
- In the case where duplicates are also allowed , in case of arr[low] = arr[mid] &&  arr[mid] = arr[high] ⇒ decrease the search by low = low + 1 ; high = high -1 as they are no longer relevant