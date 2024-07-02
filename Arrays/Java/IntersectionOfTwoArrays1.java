// Leetcode Question : https://leetcode.com/problems/intersection-of-two-arrays/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
      
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        HashSet<Integer> ans = new HashSet<>();
      
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }

        // Convert HashSet to an array of integers
        int[] result = new int[ans.size()];
        int index = 0;
        for (int num : ans) {
            result[index++] = num;
        }
        return result;
    }
}
