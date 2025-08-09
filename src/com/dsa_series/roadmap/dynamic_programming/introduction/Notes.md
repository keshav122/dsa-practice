Memoization: Known as “top-down” dynamic programming, it usually solves the problem from the main problem to the base cases.
Tabulation: Known as “bottom-up” dynamic programming, it solves the problem from the base cases to the main problem.


# Steps to Memoize a Recursive Solution
Create a dp[n+1] array initialized to -1.
Check if the answer is already calculated using the dp array (dp[n] != -1). If yes, return the value.
If not, compute the value and store it in the dp array before returning.

```
import java.util.Arrays;

public class FibonacciMemoization {
    
    // Function to calculate Fibonacci number using memoization
    public static int f(int n, int[] dp) {
        // Base case: return n if n is 0 or 1
        if (n <= 1) return n;

        // If the value is already calculated, return it
        if (dp[n] != -1) return dp[n];

        // Calculate the value and store it in dp array
        dp[n] = f(n - 1, dp) + f(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5; // Fibonacci number to find
        int[] dp = new int[n + 1]; // Initialize dp array
        Arrays.fill(dp, -1); // Fill dp array with -1

        // Output the nth Fibonacci number
        System.out.println(f(n, dp));
    }
}

```

Time Complexity: O(N) Overlapping subproblems return answers in constant time O(1). Therefore, only 'n' new subproblems are solved, resulting in O(N) complexity.

Space Complexity: O(N) Using recursion stack space and an array, the total space complexity is O(N) + O(N) ≈ O(N).



# Solution: Tabulation
Tabulation, also known as "bottom-up" dynamic programming, involves solving the problem by iteratively solving all possible sub-problems, starting from the base cases and building up to the solution of the main problem. The results of sub-problems are stored in a table, and each entry in the table is filled based on previously computed entries.

** Steps to Convert Recursive Solution to Tabulation **
Declare a dp[] array of size n+1.
Initialize base condition values, i.e., i=0 and i=1 of the dp array as 0 and 1 respectively.
Use an iterative loop to traverse the array (from index 2 to n) and set each value as dp[i-1] + dp[i-2].

```
    fib_dp_tabulation(int n){
        int dp[] = new int[n + 1]; 
        dp[0] = 0, dp[1] = 1;

        // Fill the dp array using the tabulation method
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
```

Time Complexity: O(N): Running a simple iterative loop results in O(N) complexity.
Space Complexity: O(N): Using an external array of size n+1, the space complexity is O(N).

# Solution: Space Optimization
The relation dp[i] = dp[i-1] + dp[i-2] shows that only the last two values in the array are needed. By maintaining only two variables (prev and prev2), space can be optimized. This optimization reduces the space complexity from O(N) to O(1) since it eliminates the need for an entire array to store intermediate results.

In each iteration, compute the current Fibonacci number using the values of prev and prev2. Assign the value of prev to prev2 and the value of the current Fibonacci number to prev. This way, the variables are updated for the next iteration. After the loop completes, the variable prev holds the value of the nth Fibonacci number, which is then returned as the result.


```
    fib_tab_space_optimised(int n) {
        if (n <= 1) {
            return n;;
        }
        int prev2 = 0; // Fibonacci number for n-2
        int prev = 1;  // Fibonacci number for n-1

        // Iterate from 2 to n to find the nth Fibonacci number
        for (int i = 2; i <= n; i++) {
            int cur_i = prev2 + prev; // Current Fibonacci number
            prev2 = prev;             // Update prev2 to the previous Fibonacci number
            prev = cur_i;             // Update prev to the current Fibonacci number
        }
        return prev;
     }
     
```