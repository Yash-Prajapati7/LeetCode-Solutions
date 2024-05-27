/*
Leetcode Question :
https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/?envType=daily-question&envId=2024-05-27
 */

public class SpecialArray {
    public static int specialArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];

        // Step 1: Count frequencies
        for (int num : nums) {
            if (num >= n) {
                count[n]++;
            } else {
                count[num]++;
            }
        }

        // Step 2: Calculate the prefix sums in reverse
        int total = 0;
        for (int x = n; x >= 0; x--) {
            total += count[x];
            if (total == x) {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {100,200,300,400};
        System.out.println(specialArray(nums)); // Should print the correct result
    }
}

