Leetcode Question : [Find if Array Can Be Sorted](https://leetcode.com/problems/find-if-array-can-be-sorted/)
## Approach - 1 (Pre-Computing the bit count of numbers)
### Java
```java
class Solution {
    public boolean canSortArray(int[] nums) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int setBits = 0;
            int num = nums[i];
            if(!set.containsKey(num)) {
                while(num > 0) {
                    if((num & 1) == 1) setBits++;
                    num = num >> 1; 
                }
                set.put(nums[i], setBits);
            }
        }
        
        int prevBits = 0;
        int prevMax = Integer.MIN_VALUE;
        int currMax = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;

        for(int num : nums) {
            int bits = set.get(num);
            if(bits != prevBits) {
                if(prevMax > currMin) {
                    return false;
                }
                prevBits = bits;
                prevMax = currMax;
                currMax = currMin = num;
            } else {
                currMax = Math.max(currMax, num);
                currMin = Math.min(currMin, num);
            }
        }
        return prevMax <= currMin;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canSortArray(vector<int>& nums) {
        unordered_map<int, int> set;
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            int setBits = 0;
            int num = nums[i];
            if(set.find(nums[i]) == set.end()) {
                while(num > 0) {
                    if((num & 1) == 1) setBits++;
                    num = num >> 1; 
                }
                set[nums[i]] = setBits;
            }
        }
        
        int prevBits = 0;
        int prevMax = INT_MIN;
        int currMax = INT_MIN;
        int currMin = INT_MAX;

        for(int num : nums) {
            int bits = set[num];
            if(bits != prevBits) {
                if(prevMax > currMin) {
                    return false;
                }
                prevBits = bits;
                prevMax = currMax;
                currMax = currMin = num;
            } else {
                currMax = max(currMax, num);
                currMin = min(currMin, num);
            }
        }
        return prevMax <= currMin;
    }
};
```

---

## Approach - 2 (Using the inbuilt `bitCount` method)
### Java

```java
class Solution {
    public boolean canSortArray(int[] nums) {
        
        int prevBits = 0;
        int prevMax = Integer.MIN_VALUE;
        int currMax = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;

        for(int num : nums) {
            int bits = Integer.bitCount(num);
            if(bits != prevBits) {
                if(prevMax > currMin) {
                    return false;
                }
                prevBits = bits;
                prevMax = currMax;
                currMax = currMin = num;
            } else {
                currMax = Math.max(currMax, num);
                currMin = Math.min(currMin, num);
            }
        }
        return prevMax <= currMin;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canSortArray(vector<int>& nums) {
        
        int prevBits = 0;
        int prevMax = INT_MIN;
        int currMax = INT_MIN;
        int currMin = INT_MAX;

        for(int num : nums) {
            int bits = __builtin_popcount(num);
            if(bits != prevBits) {
                if(prevMax > currMin) {
                    return false;
                }
                prevBits = bits;
                prevMax = currMax;
                currMax = currMin = num;
            } else {
                currMax = max(currMax, num);
                currMin = min(currMin, num);
            }
        }
        return prevMax <= currMin;
    }
};
```
