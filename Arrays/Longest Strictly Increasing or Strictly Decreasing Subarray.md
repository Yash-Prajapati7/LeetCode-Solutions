Leetcode Question : [Longest Strictly Increasing or Strictly Decreasing Subarray](https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/)

## Method - 1
### Java
```java
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;
        int maxLen = 0, currentMaxLen = 1, currentMax = 0, currentMin = 0;

        for(int i = 0; i < n; i++) {
            currentMax = nums[i];
            currentMin = nums[i];

            // For strictly increasing order
            currentMaxLen = 1;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] <= currentMax) {
                    break;
                }
                currentMax = nums[j];
                currentMaxLen++;
            }
            maxLen = maxLen < currentMaxLen ? currentMaxLen : maxLen;

            // For strictly decreasing order
            currentMaxLen = 1;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] >= currentMin) {
                    break;
                }
                currentMin = nums[j];
                currentMaxLen++;
            }
            maxLen = maxLen < currentMaxLen ? currentMaxLen : maxLen;
        }

        return maxLen;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return 1;
        int maxLen = 0, currentMaxLen = 1, currentMax = 0, currentMin = 0;

        for (int i = 0; i < n; i++) {
            currentMax = nums[i];
            currentMin = nums[i];

            // For strictly increasing order
            currentMaxLen = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] <= currentMax) {
                    break;
                }
                currentMax = nums[j];
                currentMaxLen++;
            }
            maxLen = max(maxLen, currentMaxLen);

            // For strictly decreasing order
            currentMaxLen = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= currentMin) {
                    break;
                }
                currentMin = nums[j];
                currentMaxLen++;
            }
            maxLen = max(maxLen, currentMaxLen);
        }

        return maxLen;
    }
};
```

## Method - 2
### Java
```java
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incLen = 1, decLen = 1, maxLen = 1, tempMax = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] > nums[i]) {
                incLen++;
                decLen = 1;
            }
            else if(nums[i + 1] < nums[i]) {
                decLen++;
                incLen = 1;
            }
            else {
                incLen = 1;
                decLen = 1;
            }
            tempMax = incLen < decLen ? decLen : incLen;
            maxLen = maxLen < tempMax ? tempMax : maxLen;
        }

        return maxLen;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int incLen = 1, decLen = 1, maxLen = 1, tempMax = 0;

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                incLen++;
                decLen = 1;
            }
            else if (nums[i + 1] < nums[i]) {
                decLen++;
                incLen = 1;
            }
            else {
                incLen = 1;
                decLen = 1;
            }
            tempMax = max(incLen, decLen);
            maxLen = max(maxLen, tempMax);
        }

        return maxLen;
    }
};
```
