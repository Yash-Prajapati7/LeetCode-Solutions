/*
Leetcode Question :
https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
*/

#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

class SmallestDivisorBelowThreshold {
public:
    // Find Maximum element in the array
    static int findMax(const vector<int>& nums) {
        int maxVal = INT_MIN;
        for (int num : nums) {
            maxVal = max(maxVal, num);
        }
        return maxVal;
    }

    // Calculate the sum of the ceiling of divisions of nums by divisor
    static int calculateSum(const vector<int>& nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;  // Efficient ceiling of integer division
        }
        return sum;
    }

    // Find the smallest divisor such that the sum is less than or equal to the threshold
    static int smallestDivisor(const vector<int>& nums, int threshold) {
        int low = 1, high = findMax(nums);
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Reduce the search space of binary search when the difference in high and low is large.
            int sum = calculateSum(nums, mid);
            if (sum <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};

int main() {
    vector<int> arr = {1, 2, 3, 4, 5};
    int limit = 8;
    cout << SmallestDivisorBelowThreshold::smallestDivisor(arr, limit) << endl;  // Expected output: 2
    return 0;
}
