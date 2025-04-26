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
