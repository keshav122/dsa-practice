package com.roadmap.binary_search.FAQs;

import java.util.Arrays;

public class KthElementOfTwoSortedArrays {
    public int kthElement_BF(int[] a, int[] b, int k) {
        int[] temp = new int[a.length + b.length];
        int tempIndexPtr = 0;
        for (int i = 0; i < a.length; i++, tempIndexPtr++) {
            temp[tempIndexPtr] = a[i];
        }
        for (int i = 0; i < b.length; i++, tempIndexPtr++) {
            temp[tempIndexPtr] = b[i];
        }
        Arrays.sort(temp);
        return temp[k - 1];
    }

    public int kthElement_Better(int[] a, int[] b, int k) {
        int left = 0;
        int right = 0;
        int elementCount = 0;
        int currElem = 0;
        while (left < a.length && right < b.length) {
            if (a[left] <= b[right]) {
                currElem = a[left];
                left++;
            } else {
                currElem = a[right];
                right++;
            }
            elementCount++;
            if (elementCount == k) {
                return currElem;
            }
        }

        while (left < a.length) {
            currElem = a[left];
            left++;
            elementCount++;
            if (elementCount == k) {
                return currElem;
            }
        }

        while (right < b.length) {
            currElem = b[right];
            right++;
            elementCount++;
            if (elementCount == k) {
                return currElem;
            }
        }
        return 0;
    }

    public int kthElement(int[] a, int[] b, int k) {
        int n1 = a.length;
        int n2 = b.length;
        // We calculate the number of elements in the left half of the final
        // sorted array
        if (n1 > n2)
            return kthElement(b, a, k);
        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;
            // Giving them default values in case no values exist for them
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];
            if (mid1 < n1)
                r1 = a[mid1];
            if (mid2 < n2)
                r2 = b[mid2];
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;

        }
        return 0;
    }
}
