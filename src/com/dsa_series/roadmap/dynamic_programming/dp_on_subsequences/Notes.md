# Subsequence
Any contiguous or non-part of the array present in the same order as of the array.
For eg: [1,3,2] => [1,2] is a subsequence but [2,1] is not a subsequence

Thumb rule :
1.We will try to express all the problems in the subsequences in terms of (index , target).
2. Explore possibilities of that index : There can be broadly two possibilities
 a. The element at that index is part of the subsequence.
 b. The element at that index is not part of the subsequence.


 f(n-1 , target) => means does the target exists upto the index (n-1).

 Tabulation will bottonm -up (Bottom up doesnt necessarily mean that it will start from 0). It means that we start from the base case.


 # Partition Equals Subset Sum
 Don't expand into leftSubsetSum & rightSubSetSum . If you have the leftSubSetSum , we already have the rightSubSetSum.
 Also the leftSum should be equal to (sum/2) => this reduces the question to subset sum equals to target.


 