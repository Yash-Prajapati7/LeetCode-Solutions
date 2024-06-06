/*
Leetcode Question :
https://leetcode.com/problems/koko-eating-bananas/
*/
public class KokoEatingBananas {
    public static int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        int n = piles.length;
        // Find the maximum value:
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public static int calculateTotalHours(int[] piles, int hourly) {
        int totalHours = 0;
        int n = piles.length;
        // Calculate total hours needed:
        for (int i = 0; i < n; i++) {
            totalHours += Math.ceil((double) piles[i] / (double) hourly);
        }
        return totalHours;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        // Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHours = calculateTotalHours(piles, mid);
            if (totalHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] piles = {312884470};
        int h = 968709470;
        System.out.println(minEatingSpeed(piles, h)); // Expected output: 1

        int[] piles2 = {805306368, 805306368, 805306368};
        int h2 = 1000000000;
        System.out.println(minEatingSpeed(piles2, h2)); // Expected output: 3
    }
}
