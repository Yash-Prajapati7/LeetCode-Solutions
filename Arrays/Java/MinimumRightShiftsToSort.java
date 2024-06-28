// Leetcode Question : https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/
class Solution {
    private boolean checkSortedAndRotated(List<Integer> nums) {
        int size = nums.size();
        boolean hasFallen = false;
        for(int i = 1; i < size; i++) {
            if(nums.get(i) < nums.get(i - 1)) {
                if(hasFallen) {
                    return false;
                }
                hasFallen = true;
            }
        }

        //Check for the circular case
        if(hasFallen && (nums.get(size - 1) > nums.get(0))) {
            return false;
        }
        return true;
    }
  
    private int minIndex(List<Integer> nums) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int size = nums.size();
        for(int i = 0; i < size; i++) {
            if(nums.get(i) < min) {
                min = nums.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }
  
    public int minimumRightShifts(List<Integer> nums) {
        if(nums.size() == 1) {
            return 0;
        }
        if(!checkSortedAndRotated(nums)) {
            return -1;
        }
        if(checkSortedAndRotated(nums) && minIndex(nums) != 0) {
            return nums.size() - minIndex(nums);
        }
        else {
            return 0;
        } 
    }
}
