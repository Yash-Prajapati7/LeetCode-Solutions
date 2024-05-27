/*
Leetcode Question :
https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/
*/

#include <iostream>
#include <vector>
using namespace std;

class SpecialArray {
public:
    static int specialArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> count(n + 1, 0);

        // Step 1: Count frequencies
        for (int num : nums) {
            if (num >= n) {
                count[n]++;
            } else {
                count[num]++;
            }
        }

        // Step 2: Calculate the prefix sums in reverse
        int total = 0;
        for (int x = n; x >= 0; x--) {
            total += count[x];
            if (total == x) {
                return x;
            }
        }

        return -1;
    }
};

int main() {
    vector<int> nums = {100, 200, 300, 400};
    cout << "Special value is: " << SpecialArray::specialArray(nums) << endl;
    return 0;
}
