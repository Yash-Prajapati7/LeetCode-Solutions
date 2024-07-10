// Leetcode Question : https://leetcode.com/problems/missing-number/description/
#include <vector>
using namespace std;

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        
        for(int i = 0; i < n; i++) {
            actualSum += nums[i];
        }

        return (expectedSum - actualSum);
    }
};
