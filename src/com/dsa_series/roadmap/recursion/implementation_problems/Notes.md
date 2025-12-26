# Pow (x,n)

In this we have to generate x raise to power n . We can run a for loop for 1 to n. 
** For negative values of n ** , we can take x = 1/x and n = - 1 * n.

Optimal approach :
The main idea is to reduce the number of iteration so what we can do is reduce the n by 1 if it is odd and reduce it by half and change the x to x^2 if n is even.

```
    if (n < 0) {
      x = 1 / x;
      n = -1 * n;
    }
    
    double ans = 1;
    while (n > 0) {
      if (n % 2 == 0) {
        x = (x * x);
        n = n / 2;
      } else {
        ans = ans  * x;
        n = n - 1;
      }
    }

 ```
-- The logic remains the same for the recursive solution also , just the structure - making recursive calls change.


# Generate Well Formed Parentheses of size 2 * N

Whenever we are asked to fill n places think of going from 1st place to the last place and then 
think of what are the conditions we took care of to obtain the result and then think of how we can use recursion to achieve that.

Conditions for the well formed parenthesis :

if(open > N) return;
if(open + closing == 2 * N && open == closing) {
  // Add String to the final result
}
if(close > open) => not possible

func (ind, s, open , close , list, n){
    if(open > N) return;
    if(open + close == 2 * N && open == close){
      list.add(s);
      return;
    }
    func (ind + 1, s + "(", open + 1, close , list , n)
    if(open > close){
      func (ind + 1, s + ")", open, close + 1, list , n)
    }
}
# Author: keshav122
