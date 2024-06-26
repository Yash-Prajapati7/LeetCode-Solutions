// Leetcode Question : https://leetcode.com/problems/find-pivot-index/

#include <vector>

using namespace std;

class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
};

// Sample usage
int main() {
    Solution sol;
    vector<int> nums = {1, 7, 3, 6, 5, 6};
    int result = sol.pivotIndex(nums);

    cout << "Pivot Index: " << result << endl;

    return 0;
}
