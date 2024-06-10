#include <vector>
using namespace std;

int findPeakElement(vector<int>& nums) {
    if (nums.size() == 1) {
        return 0;
    }
    int left = 1;
    int right = nums.size() - 2;
    if (nums[0] > nums[1]) {
        return 0;
    } else if (nums[nums.size() - 1] > nums[nums.size() - 2]) {
        return nums.size() - 1;
    }
    while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[mid] > nums[mid + 1]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return left;
}