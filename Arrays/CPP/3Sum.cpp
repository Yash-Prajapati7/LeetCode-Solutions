/*
Leetcode Question :
https://leetcode.com/problems/3sum/
*/
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class ThreeSum {
public:
    static vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> answer;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size() - 1; i++) {
            // Handle the case of duplicates:
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.size() - 1;
            while (j < k) {
                if ((nums[i] + nums[j] + nums[k]) > 0) {
                    k--;
                }
                else if ((nums[i] + nums[j] + nums[k]) < 0) {
                    j++;
                }
                else {
                    vector<int> temp = {nums[i], nums[j], nums[k]};
                    answer.push_back(temp);
                    j++;
                    k--;

                    // Handle the case of duplicates:
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return answer;
    }
};

int main() {
    vector<int> nums = {1, 2, -2, -1, 3};
    vector<vector<int>> result = ThreeSum::threeSum(nums);
    for (const auto& triplet : result) {
        for (int num : triplet) {
            cout << num << " ";
        }
        cout << endl;
    }
    return 0;
}
