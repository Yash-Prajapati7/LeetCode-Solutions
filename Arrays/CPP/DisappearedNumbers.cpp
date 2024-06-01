/*
Leetcode Questiion :
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
*/
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

vector<int> findDisappearedNumbers(vector<int>& nums) {
    vector<int> answer;

    for (int i = 0; i < nums.size(); i++) {
        int index = abs(nums[i]) - 1;
        if (nums[index] > 0) {
            nums[index] = -nums[index];
        }
    }

    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] > 0) {
            answer.push_back(i + 1);
        }
    }

    return answer;
}

int main() {
    vector<int> nums = {1,1,1,1};
    vector<int> result = findDisappearedNumbers(nums);

    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << "  ";
       
    }
    cout << endl;

    return 0;
}
