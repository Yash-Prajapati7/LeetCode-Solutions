/*
Leetcode Question :
https://leetcode.com/problems/contains-duplicate
*/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool containsDuplicate(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    for (size_t i = 0; i < nums.size() - 1; ++i) {
        if (nums[i] == nums[i + 1]) {
            return true;
        }
    }
    return false;
}

int main() {
    vector<int> nums = {1};
    cout << boolalpha << containsDuplicate(nums) << endl;
    return 0;
}
