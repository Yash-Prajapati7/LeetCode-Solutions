/*
Leetcode Question :
https://leetcode.com/problems/find-peak-element/
*/
public static int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int left = 1;
        int right = nums.length - 2;
        if(nums[0] > nums[1]) {
            return 0;
        }
        else if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if(nums[mid] > nums[mid+1]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
