/*
Leetcode Question :
https://leetcode.com/problems/merge-sorted-array/description/
*/

import java.util.Arrays;

public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = n - 1;  // Last index of the initialized part of nums1
        int j = n - 1;  // Last index of nums2
        int k = m - 1;  // Last index of nums1

        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }

        // Copy remaining elements of nums2 if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};  // nums1 with enough space for nums2
        int[] nums2 = {2, 5, 6};
        merge(nums1, nums1.length, nums2, nums2.length);

        // Print the merged array
        System.out.println(Arrays.toString(nums1));
    }
}
