# Combination Sum I
The tricky part here is that we can take a number multiple times and so it is not a straightforward yes or no for each of the numbers. To allow we don't move forward when we take a number but we do move forward when we chose to not take that number.

```
 private void combinations(int index,int[] candidates,int target, List<List<Integer>> res, List<Integer> currComb) {
        if(target < 0){
            return;
        }
        if(index == candidates.length){
          if(target == 0){
            res.add(new ArrayList<>(currComb));
          }
          return;
        }

        currComb.add(candidates[index]);
        combinations(index,candidates, target - candidates[index], res, currComb);
        currComb.remove(currComb.size() - 1);
        combinations(index + 1,candidates, target, res, currComb);
     }
```


# Combination Sum II 
The trick/ important stuff is to avoid generating duplicate sequences - to do that in the case where
we choose to not take a number , we must ignore all the same numbers For eg : [1, 2, 2, 2, 3, 4]
In the case where we not take the 1st index i.e. 2 we must move forward to the 4th index i.e. 3 ignoring all other 2s.

We can also use binary search to find the index quickly (upper_bound(2)).


# Subsets II
Apart from ignoring the duplicates , we also need to make sure that for eg [1 , 2, 2, 2]
if we reach the index == nums.length (and we have not taken 2) , then we should make a function call
at index == nums.length to include the sequence for [1] .

# Combination Sum III
The key is that we want to always take the numbers ahead of the current number selected as we do not want duplicate sequences , for e.g. we do not want sequences like [3,1] as [1,3] would have 
already covered this. To make sure that we calculate the last element which is either 1 (if no element is selected) or the last element selected in the current list + 1 so if we already have
[1,3] , then we want to go from 4 to 9 . It is not a 2 branched recursion rather a mutiple branched recursion as for each place we have almost 10 options(10, 9,....).