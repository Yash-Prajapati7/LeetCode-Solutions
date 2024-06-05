/*
Leetcode Question :
https://leetcode.com/problems/search-insert-position/
*/
#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }
        return left;
    }
};

int main() {
    Solution solution;
    vector<int> nums = {1, 3, 5, 6};
    int target = 5;
    cout << solution.searchInsert(nums, target) << endl;  // Output: 2
    return 0;
}
