Leetcode Question : [Maximum Value of an Ordered Triplet I](https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/)

## Method - 1 (Brute Force)

### Java
```java
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long current = 0, max = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    current = (long)(nums[i] - nums[j]) * nums[k];
                    max = max < current ? current : max;
                }
            } 
        }
        return max < 0 ? 0 : max;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long maximumTripletValue(vector<int>& nums) {
        int n = nums.size();
        long long current = 0, maxVal = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    current = (long long)(nums[i] - nums[j]) * nums[k];
                    maxVal = max(maxVal, current);
                }
            } 
        }
        return maxVal < 0 ? 0 : maxVal;
    }
};
```

## Method - 2 (Greedy)

### Java
```java
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0, current = 0;
        for (int k = 2; k < n; k++) {
            int maxPrefix = nums[0];
            for (int j = 1; j < k; j++) {
                current = (long) (maxPrefix - nums[j]) * nums[k];
                res = res < current ? current : res;
                maxPrefix = maxPrefix < nums[j] ? nums[j] : maxPrefix;
            }
        }
        return res;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long maximumTripletValue(vector<int>& nums) {
        int n = nums.size();
        long long res = 0, current = 0;
        for (int k = 2; k < n; k++) {
            int maxPrefix = nums[0];
            for (int j = 1; j < k; j++) {
                current = (long long)(maxPrefix - nums[j]) * nums[k];
                res = max(res, current);
                maxPrefix = max(maxPrefix, nums[j]);
            }
        }
        return res;
    }
};
```

## Method - 3 (More Greedy)

### Java
```java
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0, imax = 0, dmax = 0;   // imax = max(nums[i]), dmax = max(nums[i] - nums[j])

        for(int k = 0; k < n; k++) {
            ans = ans < (dmax * nums[k]) ? (dmax * nums[k]) : ans;
            dmax = dmax < (imax - nums[k]) ? (imax - nums[k]) : dmax;
            imax = imax < nums[k] ? nums[k] : imax;
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
    long long maximumTripletValue(vector<int>& nums) {
        int n = nums.size();
        long long ans = 0, imax = 0, dmax = 0;  // imax = max(nums[i]), dmax = max(nums[i] - nums[j])

        for(int k = 0; k < n; k++) {
            ans = max(ans, dmax * nums[k]);
            dmax = max(dmax, imax - nums[k]);
            imax = max(imax, (long long)nums[k]);
        }

        return ans;
    }
};
```
