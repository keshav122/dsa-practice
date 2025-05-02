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