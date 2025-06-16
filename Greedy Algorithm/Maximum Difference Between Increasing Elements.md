Leetcode Question : [Maximum Difference Between Increasing Elements](https://leetcode.com/problems/maximum-difference-between-increasing-elements/)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[j] > nums[i]) {
                    int current = nums[j] - nums[i];
                    ans = ans < current ? current : ans;
                }
            }
        }
        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        int n = nums.size();
        int ans = -1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[j] > nums[i]) {
                    int current = nums[j] - nums[i];
                    ans = ans < current ? current : ans;
                }
            }
        }
        return ans;
    }
};
```

## Method - 2 (Optimised Approach)

### Java

```java
class Solution {
    public int maximumDifference(int[] nums) {
        int ans = 0, min = Integer.MAX_VALUE;
        for(int num : nums) {
            min = min > num ? num : min;
            ans = ans < (num - min) ? (num - min) : ans;
        }
        return ans == 0 ? -1 : ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        int ans = 0, minVal = INT_MAX;
        for(int num : nums) {
            minVal = minVal > num ? num : minVal;
            ans = ans < (num - minVal) ? (num - minVal) : ans;
        }
        return ans == 0 ? -1 : ans;
    }
};
```
