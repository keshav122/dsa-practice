package com.roadmap.binary_search.FAQs;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double median_BF(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] temp = new int[m + n];
        int i = 0;
        while (i < m) {
            temp[i] = arr1[i];
            i++;
        }
        int j = 0;
        while (j < n) {
            temp[i] = arr2[j];
            i++;
            j++;
        }
        Arrays.sort(temp);
        if ((m + n) % 2 == 1) {
            return temp[(m + n) / 2];
        }
        return temp[(m + n) / 2] + temp[(m + n) / 2 - 1];
    }

    public double median_Better(int[] arr1, int[] arr2) {
        int leftPtr = 0;
        int rightPtr = 0;
        int firstVal = 0;
        int secondVal = 0;
        int m = arr1.length;
        int n = arr2.length;
        int len = m + n;
        int halfLen = (len) / 2;
        int count = 0;
        while (leftPtr < m && rightPtr < n) {
            if (arr1[leftPtr] <= arr2[rightPtr]) {
                if (count == halfLen - 1) {
                    firstVal = arr1[leftPtr];
                }
                if (count == halfLen) {
                    secondVal = arr1[leftPtr];
                }
                count++;
                leftPtr++;
            } else {
                if (count == halfLen - 1) {
                    firstVal = arr2[rightPtr];
                }
                if (count == halfLen) {
                    secondVal = arr2[rightPtr];
                }
                count++;
                rightPtr++;
            }
        }

        while (leftPtr < m) {
            if (count == halfLen - 1) {
                firstVal = arr1[leftPtr];
            }
            if (count == halfLen) {
                secondVal = arr1[leftPtr];
            }
            count++;
            leftPtr++;
        }

        while (rightPtr < n) {
            if (count == halfLen - 1) {
                firstVal = arr2[rightPtr];
            }
            if (count == halfLen) {
                secondVal = arr2[rightPtr];
            }
            count++;
            rightPtr++;
        }
        if (len % 2 == 1) {
            return secondVal;
        }
        return (firstVal + secondVal) / ((double) 2.0);
    }

    public double median_Optimal(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int leftArrLen = (m + n + 1) / 2;
        if (m > n) {
            return median_Optimal(arr2, arr1);
        }
        int low = 0;
        int high = m;
        while (low <= high) {
            // This represents the number of elements that will
            // go in the leftSide of the final sorted array from the first array.
            int mid = (low + high) / 2;
            int secArrLen = leftArrLen - mid;
            int l1 = (mid > 0) ? arr1[mid - 1] : Integer.MIN_VALUE;
            int l2 = (secArrLen > 0) ? arr2[secArrLen - 1] : Integer.MIN_VALUE;
            int r1 = (mid < m) ? arr1[mid] : Integer.MAX_VALUE;
            int r2 = (secArrLen < n) ? arr2[secArrLen] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
                }
            } else if (l1 > r2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = { -249, -131, 839 };
        int[] b = { -988 };
        MedianOfTwoSortedArrays sortArrays = new MedianOfTwoSortedArrays();
        System.out.println(sortArrays.median_Optimal(a, b));
    }
}
