## Leaders Of An Array Problem :
- BF solution : Take a index i and then traverse from i+1 to n to see if there is any number larger as compared to the element at the index i. If no such element is there add the number to the ans list.


### Pascal Triangle I  :
The first variation of Pascal Triangle that is asked is given a row and column tell the value . The BF way to achieve that is to print the complete triangle and then tell the value. The other way is to compute the $nCr$ for (n= r-1 and r = c-1).  Again we can calculate that by taking the  $n!/(r!  * (n-r) !)$ but that will become too complex and might also give overflow.

```
function nCr(n,r){
  long res = 1;
  for(int i = 0; i< r; i++){
      res = (res * (n-i));
      res = res/(i+1);
  }
  return res;
}

```   
# Pascal Triangle II - Print the complete row of Pascal triangle
A naive approach to solve this problem will be to use the formula for the element of rth row and cth column of Pascal's triangle repetitively to find each element in the rth row. The time complexity of this approach will be O(n2) as we need to calculate the value of each element in the nth row.

A better way to solve this is by identifying a pattern in the rows of the Pascal's triangle. 
It can be seen that any element in the rth row is of the form:
curr = (prev * (r-i))/(i)
where prev is the previous element in the row and i is the index of the element in the row.

Approach:

Initialize the list with a size equal to the given row number.
Set the first element of the row to 1, as the first element in every row of Pascal's Triangle is always 1.
Iterate through the row to compute each value using the above formula.
Return the computed row as the final result.


### Rotate the matrix by 90 degrees.
The BF approach is to take an extra matrix
The in-place and optimal approach includes first doing the transpose(the rows becomes the columns and the columns becomes the rows) followed by reversing each of the rows.

### Sort the array - 0s , 1s and 2s
We basically keep three pointers low , mid & high

Three rules of DNF Algo :

Everything b/w 0- (low-1) will be **zero (extreme left)**
Everything b/w low to (mid-1) will be **one**
Everything b/w high+1 to (n-1) will be **two (extreme right)**

In b/w mid to high 0,1 & 2 will be random/unsorted

If are able to sort values b/w indices mid and high we will eventually sort the complete array.
![Sort012_Image](src/com/dsa_series/roadmap/arrays/FAQs_Medium/docs/sort012.png)


### Two Sum Problem :
 The optimal approach of sorting the array and then using the two pointers is ideal for the case where we just have to identify whether the target exists or not.

### 3Sum Problem : 
While using hashset , it is important to make sure that we are not using the same element twice. To ensure we always look for the target between the i and j indices.
```
Set<List<Integer>> res = new HashSet<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      Set<Integer> hashSet = new HashSet<>();
      for (int j = i + 1; j < n; j++) {
        int target = -(nums[i] + nums[j]);
        if (hashSet.contains(target)) {
          List<Integer> li = Arrays.asList(nums[i],nums[j],target);
          Collections.sort(li);
          res.add(li);
        }
        hashSet.add(nums[j]);
      }
    }
    List<List<Integer>> ans = new ArrayList<>(res);
    return ans;
```
In the optimal approach for 3 Sum we sort the input array first and then we avoid duplicate value for all the three pointers i , j and k


### Four Sum : 

Better Approach : Take set before the 3rd loop . If set contains fourth element add quadruple , else add the element to the hashset.
```
for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (nums[i] + nums[j] + nums[k]);
                    long fourth = target - sum;

                    if (hashset.contains(fourth)) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(quadruplet);
                        quadruples.add(quadruplet);
                    }
                    hashset.add((long) nums[k]);
                }
            }
        }

  ```

Optimal Approach : Sort the array first. Run loops for i and j . Then take k = j+ 1 and l = n-1. Make sure that no duplicate values are added (for i , j , k and l). Use the two pointers to move.
```
Checking uniqueness
while (k < l && nums[k] == nums[k + 1]) k++;
while (l > k && nums[l] == nums[l - 1]) l--;
```

### Kadane's Algorithm 
The idea of Kadane's algo is that we take two variables maxSubArraySum and sum . We add each number to the sum and then compare maxSubArraySum and sum. If sum < 0 then we make the sum as 0 because taking forward a negative sum is never going to contribute to the overall result.

```
    int maxSubArraySum = Integer.MIN_VALUE ,sum = 0;
    for (i = 0-> n) {
      sum += arr[i];
      maxSubArraySum = max(maxSubArraySum, sum);
      if (sum < 0) sum = 0;
    }
    return maxSubArraySum;
````

Follow up - To print one of the subarrays with the max subarray sum (there can be mutiple)

```
    int maxSubArraySum = Integer.MIN_VALUE ,sum = 0, ansStart = -1, ansEnd = -1;
    for (i = 0-> n) {
      if(sum == 0) ansStart = i;
      sum += arr[i];
      if(sum > maxSubArraySum){
           maxSubArraySum = sum;
           ansEnd = i;
      }
      
      if (sum < 0) sum = 0;
    }
    return maxSubArraySum;
````