// Leetcode Question : https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/
#include <vector>
#include <climits>

using namespace std;

class Solution {
private:
    bool checkSortedAndRotated(const vector<int>& nums) {
        int size = nums.size();
        bool hasFallen = false;
        for (int i = 1; i < size; ++i) {
            if (nums[i] < nums[i - 1]) {
                if (hasFallen) {
                    return false;
                }
                hasFallen = true;
            }
        }

        // Check for the circular case
        if (hasFallen && (nums[size - 1] > nums[0])) {
            return false;
        }
        return true;
    }

    int minIndex(const vector<int>& nums) {
        int min = INT_MAX;
        int minIndex = 0;
        int size = nums.size();
        for (int i = 0; i < size; ++i) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

public:
    int minimumRightShifts(vector<int>& nums) {
        if (nums.size() == 1) {
            return 0;
        }
        if (!checkSortedAndRotated(nums)) {
            return -1;
        }
        int minIdx = minIndex(nums);
        if (checkSortedAndRotated(nums) && minIdx != 0) {
            return nums.size() - minIdx;
        } else {
            return 0;
        }
    }
};
