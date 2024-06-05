//Problem Statement : In a sorted array return the lower bound of provided target
//A lowerbound is the smallest index which satisfies the condition : arr[index] >= target
#include <iostream>
#include <vector>

using namespace std;

int lowerBoundIndex(const vector<int>& nums, int target) {
    // Consider a hypothetical edge case that if the array is empty, the target < 0 will be present at its -1'th position
    // else it might be present at 0th position
    if(nums.empty() && target < 0) {
        return -1;
    }
    int answer = nums.size();
    int left = 0;
    int right = nums.size() - 1;
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] == target) {
            answer = mid;
            right = mid - 1;
        }
        else if(nums[mid] < target) {
            left = mid + 1;
        }
        else if (nums[mid] > target) {
            answer = mid;
            right = mid - 1;
        }
    }
    return answer;
}

int main() {
    vector<int> nums = {1,2,3,5,5,8,8,10,11};
    int target = 9;
    cout << lowerBoundIndex(nums, target) << endl;
    return 0;
}
