** To convert from Memoization to Tabulation **
1. Declare base case
2. Express all states in for loop
3. Copy the recurrence relation.


** Space Optimization **
If there is a prev row and prev col , we can space optimise it.

Rule of thumb : 
Recursive calls: always expand top-down.
Whatever we follow in recursion , we follow the opposite in tabulation

# Cherry Pickup II
We have a fix starting point ((0,0) , (0,m-1)) and a variable ending point (can end anywhere in the last column).
Whenever we have a fix starting point and a variable ending point we start our recursion from the fix starting point.



