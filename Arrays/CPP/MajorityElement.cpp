/*
Leetcode Question :
https://leetcode.com/problems/majority-element/submissions/1267495668/
*/

#include <iostream>
#include <vector>
using namespace std;

int majorityElement(vector<int>& nums) {
    int candidate = nums[0];
    int count = 1;
    
    for (int i = 1; i < nums.size(); i++) {
        if (nums[i] == candidate) {
            count++;
        } else if (count == 0) {
            candidate = nums[i];
            count = 1;
        } else {
            count--;
        }
    }
    
    // Second pass to verify the candidate
    count = 0;
    for (int num : nums) {
        if (num == candidate) {
            count++;
        }
    }
    
    if (count > nums.size() / 2) {
        return candidate;
    } else {
        return -1;
    }
}

int main() {
    vector<int> vec = {1,1,1,1};
    cout << majorityElement(vec);
    return 0;
}
