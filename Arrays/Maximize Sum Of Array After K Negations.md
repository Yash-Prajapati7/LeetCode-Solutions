Leetcode Question : [Maximize Sum Of Array After K Negations](https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/)

### Java

```java
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;

        // Step 1: Flip all negative numbers
        while (i < nums.length && nums[i] < 0 && k > 0) {
            nums[i] = -nums[i];
            i++;
            k--;
        }

        // Step 2: Find minimum element
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }

        // Step 3: If k is still odd, flip the smallest element
        if (k % 2 == 1) {
            sum -= 2 * min;
        }

        return sum;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());

        int i = 0;

        // Step 1: Flip all negative numbers
        while (i < nums.size() && nums[i] < 0 && k > 0) {
            nums[i] = -nums[i];
            i++;
            k--;
        }

        // Step 2: Find minimum element
        int minVal = INT_MAX;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            minVal = min(minVal, num);
        }

        // Step 3: If k is still odd, flip the smallest element
        if (k % 2 == 1) {
            sum -= 2 * minVal;
        }

        return sum;
    }
};
```
