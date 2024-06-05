// Problem Statement: Upper Bound in a Sorted Array

// Given:
// - A sorted array of integers `arr`.
// - A target value `target`.

// Find:
// The smallest index `i` in the array `arr` such that `arr[i] > target`. 
// This is called the upper bound of `target` in the array.

// Constraints:
// - The array `arr` is guaranteed to be sorted in ascending order.

// Return Value:
// - If there exists an element in `arr` greater than `target`, return the index `i` where `arr[i] > target`.
// - If no element in `arr` is greater than `target`, return the length of the array `len(arr)`.
#include <iostream>
#include <vector>

using namespace std;

int upperBound(const vector<int>& nums, int target) {
    int answer = nums.size();
    int left = 0;
    int right = nums.size() - 1;
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] > target) {
            answer = mid;
            right = mid - 1;
        }
        else if (nums[mid] <= target) {
            left = mid + 1;
        }
    }
    return answer;
}

int main() {
    vector<int> nums = {3, 5, 8, 9, 15, 19};
    int target = 9;
    cout << upperBound(nums, target) << endl;
    return 0;
}
