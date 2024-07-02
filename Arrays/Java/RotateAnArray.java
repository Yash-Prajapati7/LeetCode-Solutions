// Leetcode Question : https://leetcode.com/problems/rotate-array/
class Solution {
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        
        reverse(nums, 0, n - 1);   // Reverse the whole array
        reverse(nums, 0, k - 1);   // Reverse the first k elements
        reverse(nums, k, n - 1);   // Reverse the remaining elements
    }
}
