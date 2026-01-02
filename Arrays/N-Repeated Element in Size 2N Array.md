Leetcode Question : [N-Repeated Element in Size 2N Array](https://leetcode.com/problems/n-repeated-element-in-size-2n-array/)

## Method - 1 (Sorting)

### Java

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length >> 1;
        
        if(nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
            return nums[mid - 1];
        }
        else {
            return nums[mid];
        }
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int mid = nums.size() >> 1;

        if(nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
            return nums[mid - 1];
        }
        else {
            return nums[mid];
        }
    }
};
```

## Method - 2 (Distance Method)

### Java

```java
class Solution {
    public int repeatedNTimes(int[] nums) {
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];   // Edge case for [x, y, z, x]
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int repeatedNTimes(vector<int>& nums) {
        for(int i = 0; i < nums.size() - 2; i++) {
            if(nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }

        return nums[nums.size() - 1];   // Edge case for [x, y, z, x]
    }
};
```
