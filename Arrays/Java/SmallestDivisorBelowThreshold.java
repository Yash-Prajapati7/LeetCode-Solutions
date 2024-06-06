/*
Leetcode Question :
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
*/
public class SmallestDivisorBelowThreshold {
    //Find Maximum element in the array
    public static int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    // Calculate the sum of the ceiling of divisions of nums by divisor
    public static int calculateSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;  // Efficient ceiling of integer division
        }
        return sum;
    }

    // Find the smallest divisor such that the sum is less than or equal to the threshold
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = findMax(nums);
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Reduce the search space of binary search when the difference in high and low is large.
            int sum = calculateSum(nums, mid);
            if (sum <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int limit = 8;
        System.out.println(smallestDivisor(arr, limit));
    }
}
