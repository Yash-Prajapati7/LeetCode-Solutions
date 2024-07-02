// Leetcode Question : https://leetcode.com/problems/intersection-of-two-arrays/
#include <vector>
#include <algorithm>
#include <unordered_set>

using namespace std;

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        // Sort both arrays
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());

        int m = nums1.size();
        int n = nums2.size();
        int i = 0, j = 0;
        unordered_set<int> ans;

        // Find intersection
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ans.insert(nums1[i]);
                i++;
                j++;
            }
        }

        // Convert unordered_set to vector
        vector<int> result(ans.begin(), ans.end());
        return result;
    }
};
