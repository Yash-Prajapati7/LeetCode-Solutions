// Problem Statement: Upper Bound in a Sorted Array

// Given:
// - A sorted array of integers `arr`.
// - A target value `target`.

// Find:
// The smallest index `i` in the array `arr` such that `arr[i] > target`. 
// This is called the upper bound of `target` in the array.

// Constraints:
// - The array `arr` is guaranteed to be sorted in ascending order.

// Return Value:
// - If there exists an element in `arr` greater than `target`, return the index `i` where `arr[i] > target`.
// - If no element in `arr` is greater than `target`, return the length of the array `len(arr)`.
public class FindingUpperBound {
    public static int upperBound(int [] nums, int target) {
        int answer = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] > target) {
                answer = mid;
                right = mid - 1;
            }
            else if (nums[mid] <= target) {
                left = mid + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] nums = {5,5,5,5};
        int target = 5;
        System.out.println(upperBound(nums, target));
    }
}
