/*
Leetcode Question :
https://leetcode.com/problems/merge-sorted-array/description/
*/

#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
    int i = n - 1;  // Last index of the initialized part of nums1
    int j = n - 1;  // Last index of nums2
    int k = m - 1;  // Last index of nums1

    // Merge in reverse order
    while (i >= 0 && j >= 0) {
        if (nums1[i] < nums2[j]) {
            nums1[k--] = nums2[j--];
        } else {
            nums1[k--] = nums1[i--];
        }
    }
}

int main() {
    vector<int> nums1 = {1, 2, 3, 0, 0, 0};  // nums1 with enough space for nums2
    vector<int> nums2 = {2, 5, 6};
    merge(nums1, nums1.size(), nums2, nums2.size());

    // Print the merged array
    cout << "[";
    for (int i = 0; i < nums1.size(); i++) {
        cout << nums1[i];
        if (i < nums1.size() - 1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;

    return 0;
}
