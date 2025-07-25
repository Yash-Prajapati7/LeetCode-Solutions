Leetcode Question : [Maximum Unique Subarray Sum After Deletion](https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion)

### Java

```java
class Solution {
    public int maxSum(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int sum = 0, min = Integer.MIN_VALUE;
        boolean[] seen = new boolean[101];

        for(int num : nums) {
            if(num > 0 && !seen[num]) { // ignore negative numbers as they will decrease the sum
                sum += num;
                seen[num] = true;
            }
            else {
                if(num > min) min = num;
            }
        }

        return sum == 0 ? min : sum;    // in case all nums are negative, the maximum sum will be the minimum negative number
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSum(vector<int>& nums) {
        if(nums.size() == 1) {
            return nums[0];
        }

        int sum = 0, minVal = INT_MIN;
        bool seen[101] = {false};

        for(int num : nums) {
            if(num > 0 && !seen[num]) { // ignore negative numbers as they will decrease the sum
                sum += num;
                seen[num] = true;
            }
            else {
                if(num > minVal) minVal = num;
            }
        }

        return sum == 0 ? minVal : sum; // in case all nums are negative, the maximum sum will be the minimum negative number
    }
};
```
