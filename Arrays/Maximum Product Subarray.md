Leetcode Question : [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)

### Java

```java
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Use double to prevent intermediate integer overflow
        double maxSoFar = nums[0];
        double minSoFar = nums[0];
        double result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            double curr = nums[i];
            
            // If the current number is negative, our max becomes our min, and vice versa.
            // So, we swap them before multiplying.
            if (curr < 0) {
                double temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Calculate the new max and min. 
            // The Math.max(curr, ...) essentially handles the "Zero Trap" by resetting 
            // the sequence to start from the current number if the running product drops to 0.
            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            // Update the global result
            result = Math.max(result, maxSoFar);
        }

        return (int) result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if (nums.size() == 0) return 0;

        // Use double to prevent intermediate integer overflow
        double maxSoFar = nums[0];
        double minSoFar = nums[0];
        double result = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            double curr = nums[i];
            
            // If the current number is negative, our max becomes our min, and vice versa.
            // So, we swap them before multiplying.
            if (curr < 0) {
                double temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Calculate the new max and min. 
            // The max(curr, ...) essentially handles the "Zero Trap" by resetting 
            // the sequence to start from the current number if the running product drops to 0.
            maxSoFar = max(curr, maxSoFar * curr);
            minSoFar = min(curr, minSoFar * curr);

            // Update the global result
            result = max(result, maxSoFar);
        }

        return (int) result;
    }
};
```
