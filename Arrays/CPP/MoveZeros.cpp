/*
Leetcode Question :
https://leetcode.com/problems/move-zeroes/description/
*/

#include <iostream>
#include <vector>

using namespace std;

vector<int> shiftZerosToEnd(vector<int>& nums) {
    int nonZeroIndex = 0;
    for (int i = 0; i < nums.size(); i++) {
        if (nums[i] != 0) {
            if (i != nonZeroIndex) {
                // Swap non-zero element to the left
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
            }
            nonZeroIndex++;
        }
    }
    return nums;
}

int main() {
    vector<int> nums;
    int val;
    cout << "Keep Entering Integers (Enter -1 to exit)" << endl;
    while (true) {
        cin >> val;
        if (val == -1) {
            break;
        }
        nums.push_back(val);
    }

    cout << "Your modified array is: " << endl;
    vector<int> modifiedArray = shiftZerosToEnd(nums);
    for (int num : modifiedArray) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
