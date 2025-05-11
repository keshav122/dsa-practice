public class ThreeConsecutiveOdds_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3)
            return false;
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count = 0;
            } else {
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
