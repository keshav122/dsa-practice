### Largest Consecutive Sequence In An Array:
-BF Approach : For each element , check if the element greater than that exist in the arr
and then keep doing it until you are able to find next greater elements.
'''
longest = 1
for(i = 0; i< n ;i++){
    x = arr[i]
    cnt = 1;
    while(linearSearch(arr,x  + 1) == true){
        x = x+1l
        cnt++;
    }
    longest = max(longest, cnt);
}
- Check what should be done if the diff is 0 => should the sequence be discontinued if there are duplicate numbers in between or it should be continued.

- Optimal : the idea is that we put all the elements into a set and then we traverse through the set
For any element if the previous element is present then we don't start sequence for it as it cannot be a potential starting point and therefore it would be time inefficient to look in both directions (will become similar to brute force).
So we only start checking if the previous element is not present and then we calculate the max seq length.