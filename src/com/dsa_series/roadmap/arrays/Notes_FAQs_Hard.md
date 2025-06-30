### Majority Element I and II : MOORE's Voting Algorithm
The idea is to take a candidate and a count . If the nums[i] is equal to candidate we increment the count otherwise we decrease the count . If the count reaches zero, then we take the new candidate. The whole idea is that if an element is actually present more than n/2 times it would be the candidate at the end. (Upto here is the idea of moore voting algo)
But we must do a verfication after traversing in the array to ensure that the candidate we chose is the occuring more than n/2 times.

```
Input: Array of integers 'nums' 
Output: Majority element if it occurs more than n/2 times, otherwise -1

n = nums.length , candidate = 0, count = 0

    // First pass to find a potential candidate
     For i from 0 to n-1:
       If count == 0:
           candidate = nums[i]
           count = 1
       Else if nums[i] == candidate:
           count += 1
       Else:
           count -= 1

5. // Second pass to confirm the candidate is the majority
```



** Input: Array of integers 'nums'
Output: List of elements appearing more than ⌊n/3⌋ times **
```
Initialize an empty list 'ans'
Set n = length of nums , candidate1 = 0, count1 = 0 , candidate2 = 0, count2 = 0

// First pass to find up to 2 potential majority candidates
For i from 0 to n - 1:
       If count1 == 0 AND nums[i] != candidate2:
           candidate1 = nums[i]
           count1 = 1
       Else if count2 == 0 AND nums[i] != candidate1:
           candidate2 = nums[i]
           count2 = 1
       Else if nums[i] == candidate1:
           count1 += 1
       Else if nums[i] == candidate2:
           count2 += 1
       Else:
           count1 -= 1
           count2 -= 1

6. // Second pass to confirm the candidates
```


### Find repeating and missing number
The optimal approach of finding the repeating and missing number is to 
calculate sum and subtract the natural sum =>  x -y
And calculate sum squared and subtratct the squares of first n natural numbers => x^2 - y^2
From this we get the x and y, where x is the repeating number and y is the missing number.

🧠 XOR Trick to Find Missing and Repeating Numbers
🔍 Intuition
To find the repeating and missing numbers in an array of size N containing elements from 1 to N:

Use the XOR operation to compute the XOR of the repeating number X and the missing number Y.

The XOR of X ^ Y gives us a number where the bits set correspond to the positions where X and Y differ.

Identify the rightmost set bit in this XOR result — this bit helps us divide all numbers into two groups:

Group 1: Numbers with this bit set.

Group 2: Numbers with this bit not set.

By XOR-ing the numbers in each group separately (from both the input array and the range 1 to N), we isolate the repeating and missing numbers.

Finally, determine which number is repeating by checking its frequency in the array.

✅ Approach
Step 1: XOR of Array and Range 1 to N
xr = 0
for num in arr:
    xr ^= num
for i in range(1, N + 1):
    xr ^= i
After this step, xr = X ^ Y (repeating ^ missing)

Step 2: Find Rightmost Set Bit
bit = xr & ~(xr - 1)
This gives us the rightmost set bit in xr, indicating the first differing bit between X and Y.

Step 3: Divide Numbers into Two Buckets Based on This Bit
zero = one = 0
for num in arr:
    if num & bit:
        one ^= num
    else:
        zero ^= num

for i in range(1, N + 1):
    if i & bit:
        one ^= i
    else:
        zero ^= i
After this, zero and one will hold X and Y in some order.

Step 4: Identify Which is Repeating
count = arr.count(zero)
if count == 2:
    repeating = zero
    missing = one
else:
    repeating = one
    missing = zero


### Count Inversions
Given an integer array nums. Return the number of inversions in the array.
Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

The optimal approach is based on the insight that if there are two sorted arrays :
{5,10,11}  & {3,4,7,9} so comparing the first element if 5 is greater than 3 then the elements
ahead of it will always be greater than 3.
Using this , we know that in Merge sort we divide the arrays into sorted subaarays
and compare the sorted arrays so from there we can calcuate our count.

# Reverse Pairs
Given an integer array nums. Return the number of reverse pairs in the array.
An index pair (i, j) is called a reverse pair if:
0 <= i < j < nums.length
nums[i] > 2 * nums[j].

We cannot directly apply the merge sort and change the condition to if(nums[left] > 2 * nums[right]) otherwise we will not lose on a lot of cases
For eg : {6,13,14,15} and {3,4,5}
Although 6 and 3 will not form pair but 3 can form pairs with 13, 14 and 15 but that also will be missed. 
To manage this we write another function to count the possible pairs.
```
private int countPairs(int[] nums, int low , int mid , int high){
      int count = 0, right = mid + 1;
      for(int i = low ; i<= mid; i++){
        while(right <= high && nums[i] > 2 * nums[right]){
            right++;
        }
        count += right - (mid + 1);
      }
      return count;
    }
```

### Maximum Product Subarray 
It has few observations:
1. If the all the values are positives or there are even negatives with all the other values
as positives => we can mutiply all the elements to get the max product
2. If there are odd number of negatives => we need to remove one negative to get the max product. So for example : 3  4 -1 2 3 4 -5 5 - 2 6
If we don't take the -1 the subarrays can be either {3,4} or {2 3 4 -5 5 - 2 6 }
3. If there are zeroes , we avoid them completely that is we set the product back to 1.

Approach is to calculate the prefix and suffix and return whatever is the max.
If the prefix/suffix ever turns to be zero , set the prefix/suffix to 1.

```
public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        for(int i = 0; i< n ; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            maxProduct = Math.max(maxProduct,Math.max(prefix,suffix));
        }
        return maxProduct;
    }
```

### Merge Two Sorted Arrays Without Extra Space
BF : we take the extra array as generally the problem don;t specify not to take extra space
Optimal 1: 
keep a pointer at the end of first array and at the first of second array
If nums1[i] > nums2[j] swap(nums1[i] , nums2[j])
Keep repeating this until the condition holds
After that all the smaller nos are in first array and the larger in the second array .
Sort both the arrays.

Optimal 2: 
This works on the Gap method taken from shell sort
Take gap = (len)/2 + (len) %2 where len is sum of length of both the arrays
while(gap > 0) 
Keep left ptr at 0 and right ptr at gap
There can be three scenarios , both are in left , both are in right , left in 1st arr and right in 2nd array. 
If a[left] > a[right] => swap
If right crosses boundary(len) , readjust gap to ceil(gap/2) achived by
gap = (gap/2) + (gap%2) 