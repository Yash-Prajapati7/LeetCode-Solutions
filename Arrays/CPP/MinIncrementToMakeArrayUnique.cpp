/*
Leetcode Question :
https://leetcode.com/problems/minimum-increment-to-make-array-unique/
*/
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int moves = 0;
        
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] - nums[i] + 1;
                moves += increment;
                nums[i] += increment;
            }
        }
        return moves;
    }
};
