/*
Leetcode Question :
https://leetcode.com/problems/special-array-i/description/
 */

public class OddEvenParity {
        public static boolean isSpecialArray(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                // Check if adjacent elements have different parity
                if (nums[i] % 2 == nums[i + 1] % 2) {
                    return false; // Not special if same parity
                }
            }
            return true; // Special if all pairs have different parity
        }

    public static void main(String[] args) {
        int [] nums = {4,1};
        System.out.println(isSpecialArray(nums));
    }
}
