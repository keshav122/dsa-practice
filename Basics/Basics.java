import java.util.Scanner;

public class Basics {
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
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = s.nextInt();
        }
        Basics median = new Basics();
        System.out.println(median.median_Optimal(a, b));
    }
}
