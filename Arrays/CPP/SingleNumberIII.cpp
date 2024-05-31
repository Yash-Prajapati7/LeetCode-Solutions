/*
Leetcode Question :
https://leetcode.com/problems/single-number-iii/description/

Although the question has asked that the solution must be of constant space complexity, 
but as per the given constraints this approach also has a constant space complexity 
as all the elements in the end will get removed and only the two unique elements will be left
*/
#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>

using namespace std;

vector<int> singleNumber(vector<int>& nums) {
    if (nums.size() == 2) {
        return nums;
    }
    
    unordered_set<int> seen;
    for (int num : nums) {
        if (seen.find(num) != seen.end()) {
            seen.erase(num);
        } else {
            seen.insert(num);
        }
    }

    vector<int> answer;
    for (int num : seen) {
        answer.push_back(num);
    }
    return answer;
}

int main() {
    vector<int> nums = {0, 1};
    vector<int> result = singleNumber(nums);
    cout << "[";
    for (int i = 0; i < result.size(); ++i) {
        cout << result[i];
        if (i != result.size() - 1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;
    return 0;
}
