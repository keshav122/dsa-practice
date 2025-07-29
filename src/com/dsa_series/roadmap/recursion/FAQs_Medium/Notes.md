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