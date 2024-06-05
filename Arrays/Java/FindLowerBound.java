//Problem Statement : In a sorted array return the lower bound of provided target
//A lowerbound is the smallest index which satisfies the condition : arr[index] >= target
public class FindingLowerBound {
    public static int lowerBoundIndex(int [] nums, int target) {
        //Consider an edge case that if the array is empty, then target < 0 will be present at its -1'th position
        //else it might be present at 0th position
        if(nums.length == 0 && target < 0) {
            return -1;
        }
        int answer = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                answer = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] nums = {};
        int target = -9;
        System.out.println(lowerBoundIndex(nums, target));
    }
}
