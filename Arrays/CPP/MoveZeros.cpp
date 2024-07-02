// Leetcode Question : https://leetcode.com/problems/move-zeroes/
#include <vector>

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                if (i != nonZeroIndex) {
                    // Swap non-zero element to the left
                    int temp = nums[i];
                    nums[i] = nums[nonZeroIndex];
                    nums[nonZeroIndex] = temp;
                }
                nonZeroIndex++;
            }
        }
    }
};
