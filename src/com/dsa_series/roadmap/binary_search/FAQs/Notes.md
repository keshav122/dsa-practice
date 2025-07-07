# Median of Two Sorted Arrays

The BF approach is to take a third array and copy the elements from arr1 and arr2 in a sorted way and then return n/2 or ((n/2) + (n/2-1))/2 sum

The better approach is to not take a third array and maintain the count and the indices and then return the n/2 indice or sum of n/2 and n/2-1 indices values.

The optimal approach involves using binary search :
- We will try to create a valid symmetry and construct the accurate left half which might consist of x elements from the first array and the (leftSize - x) elements from the second array
- We ensure the valid symmetery by comparing the elements at cross
![symmetry_bs_median](src/com/dsa_series/roadmap/binary_search/FAQs/docs/symmetry_bs_median.png) 

- Then the median will be calculated using the average of the max(l1,l2) + min (r1,r2)
- For odd lengths we take the value to be max(l1,l2)
- The trick is to calculate the left half length to be (n1 + n2 + 1)/2

```
public double median(int[] arr1, int[] arr2) {
      int n1 = arr1.length;
      int n2 = arr2.length;
      if(n1 > n2){
        return median(arr2,arr1);
      }
      int n = n1 + n2;
      int left = (n1 + n2 + 1)/2;
      int low = 0, high = n1;
      while(low <= high){
        int mid1 = (low + high)/2;
        int mid2 = left - mid1;
        int l1 = (mid1- 1 >= 0) ? arr1[mid1-1] : Integer.MIN_VALUE;
        int l2 = (mid2- 1 >= 0) ? arr2[mid2-1] : Integer.MIN_VALUE;
        int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
        int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;
        if(l1 <= r2 && l2 <= r1){
            if(n % 2 == 0){
                double val = (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                return val;
            }else{
                return Math.max(l1,l2);
            }
        }else if(l1 > r2){
            high = mid1 -1;
        }else if(l2 > r1){
            low = mid1 + 1;
        }
      }
      return 0;

    }

```