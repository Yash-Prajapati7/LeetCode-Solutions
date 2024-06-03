/*
Leetcode Question :
https://leetcode.com/problems/sort-colors/description/
*/

public class SortZeorsOnesAndTwos {
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;

                /*
                When nums[mid] == 2, we swap nums[mid] with nums[high] and then decrement high.
                We do not increment mid in this case because the element at high that we just
                swapped into mid could be a 0 or a 1, and we need to check it again.
                */
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0};
        sortColors(arr);
    }
}
