// Leetcode Question : https://leetcode.com/problems/left-and-right-sum-differences/

#include <vector>
#include <cmath>

using namespace std;

class Solution {
public:
    vector<int> leftRightDifference(vector<int>& nums) {
        int n = nums.size();
        vector<int> answer(n);
        int totalSum = 0;
        
        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        // Calculate differences
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            answer[i] = abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        
        return answer;
    }
};

// Sample usage
int main() {
    Solution sol;
    vector<int> nums = {10, 4, 8, 3};
    vector<int> result = sol.leftRightDifference(nums);

    cout << "Result: ";
    for (int value : result) {
        cout << value << " ";
    }
    cout << endl;
    return 0;
}
