Leetcode Question : [Minimum Difference Between Highest and Lowest of K Scores](https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/)
### Java
```java
class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1) {
            return 0;
        }

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(diff, minDiff);
        }

        return minDiff;        
    }
}
```
### C++
```cpp
#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        if (k == 1) return 0;
        sort(nums.begin(), nums.end());
        int minDiff = INT_MAX;
        for (int i = 0; i <= nums.size() - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minDiff = min(minDiff, diff);
        }
        return minDiff;
    }
};

int main() {
    Solution sol;
    vector<int> nums = {9, 4, 1, 7};
    int k = 2;
    cout << sol.minimumDifference(nums, k) << endl; // Output: 2
    return 0;
}
```
