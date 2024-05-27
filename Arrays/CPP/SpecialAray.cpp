/*
Leetcode Question :
https://leetcode.com/problems/special-array-i/description/
*/

#include <iostream>
using namespace std;

bool isSpecialArray(int nums[], int length) {
        for (int i = 0; i < length - 1; i++) {
            // Check if adjacent elements have different parity
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false; // Not special if same parity
            }
        }
        return true; // Special if all pairs have different parity
    }

int main() {
    int nums[] = {4, 1};
    int length = sizeof(nums) / sizeof(nums[0]);
    cout << "Is the array special? " << (isSpecialArray(nums, length) ? "Yes" : "No") << endl;
    return 0;
}

