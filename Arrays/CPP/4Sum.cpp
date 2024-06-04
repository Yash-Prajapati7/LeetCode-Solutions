/*
Leetcode Question :
https://leetcode.com/problems/4sum
*/
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> fourSum(vector<int>& nums, int target) {
    int n = nums.size(); // size of the array
    vector<vector<int>> ans;

    // sort the given array:
    sort(nums.begin(), nums.end());

    // calculating the quadruplets:
    for (int i = 0; i < n; i++) {
        //Handle the case for duplicates
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        for (int j = i + 1; j < n; j++) {
            //Handle the case for duplicates
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;

            // 2 pointers:
            int k = j + 1;
            int l = n - 1;
            while (k < l) {
                long long sum = nums[i];
                sum += nums[j];
                sum += nums[k];
                sum += nums[l];
                if (sum == target) {
                    vector<int> temp = {nums[i], nums[j], nums[k], nums[l]};
                    ans.push_back(temp);
                    k++;
                    l--;

                    // skip the duplicates:
                    while (k < l && nums[k] == nums[k - 1]) k++;
                    while (k < l && nums[l] == nums[l + 1]) l--;
                } else if (sum < target) k++;
                else l--;
            }
        }
    }
    return ans;
}

int main() {
    vector<int> nums = {2, 2, 2, 2, 2};
    int target = 8;
    vector<vector<int>> result = fourSum(nums, target);
    for (auto& quadruplet : result) {
        for (auto& num : quadruplet) {
            cout << num << " ";
        }
        cout << endl;
    }
    return 0;
}
