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


