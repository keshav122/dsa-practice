# Very Important Pattern

The idea is to generate all the subsequences and then check whether there exists a subsequence with the given sum. 
For every number in the array we decide whether to take that value in the sum or not.
And we reduce the sum , if we take the number else we keeep the sum as it is.

bool f(ind , sum):
        if(sum == 0) return true;
        if(sum < 0 || ind == n) return false;
        return f(ind + 1 , sum - arr[ind]) || f(ind + 1, sum)