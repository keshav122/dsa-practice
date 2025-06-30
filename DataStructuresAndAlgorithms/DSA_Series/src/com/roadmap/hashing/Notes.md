### Largest Consecutive Sequence In An Array:
-BF Approach : For each element , check if the element greater than that exist in the arr
and then keep doing it until you are able to find next greater elements.
'''
longest = 1
for(i = 0; i< n ;i++){
    x = arr[i]
    cnt = 1;
    while(linearSearch(arr,x  + 1) == true){
        x = x+1
        cnt++;
    }
    longest = max(longest, cnt);
}
- Check what should be done if the diff is 0 => should the sequence be discontinued if there are duplicate numbers in between or it should be continued.

- Optimal : the idea is that we put all the elements into a set and then we traverse through the set
For any element if the previous element is present then we don't start sequence for it as it cannot be a potential starting point and therefore it would be time inefficient to look in both directions (will become similar to brute force).
So we only start checking if the previous element is not present and then we calculate the max seq length

# Count subarrays with given sum 
The most optimal relies on the approach of prefix sum that if upto a particular index
the sum is x and there is a subarray within it with sum (x-k) then there will be the other 
subarray with sum k. So rather than looking for subarrays with sum k directly , we will 
look for the subarrays with sum => (x-k) and add their freq to the total count.
Tip : Make sure to add (0,1) to the map first . For importance of this : try out the 
example (3,-3,1,1)

```
public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> sumFreqMap = new HashMap<>();
        sumFreqMap.put(0,1);
        int sum = 0, count = 0;
        for(int i = 0; i< n; i++){
          sum += nums[i];
          if(sumFreqMap.containsKey(sum-k)){
            count += sumFreqMap.get(sum-k);
          }
          sumFreqMap.merge(sum,1,Integer::sum);
        }
        return count;
    }
```

### Count subarrays with given XOR K
the logic is that lets say for array : {4,2,2,6,4} the xor upto 6 is xr and we assume that 
the xor of 2 2 6 is k . And lets say the xor of 4 is x
So we can x ^ k = xr
XOR by K on both sided
x = xr ^ k 
So for 2 2 6 to have a xor k we must have x equal to xr ^ k (where xr is the xor of all the
elements upto that ending point)
So we can count and track the same using a hashmap.
Make sure to add (0,1) for a subarray with no elements will be having xor as 0.
# Author: keshav122
