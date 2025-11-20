Leetcode Question : [Keep Multiplying Found Values by Two](https://leetcode.com/problems/keep-multiplying-found-values-by-two)

### Java

```java
class Solution {
    private boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(nums[mid] == target) {
                return true;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return false;
    }

    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        
        while(true) {
            if(binarySearch(nums, original)) {
                original <<= 1;
            }
            else {
                break;
            }
        }

        return original;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    bool binarySearch(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

public:
    int findFinalValue(vector<int>& nums, int original) {
        sort(nums.begin(), nums.end());

        while (true) {
            if (binarySearch(nums, original)) {
                original <<= 1;
            } else {
                break;
            }
        }

        return original;
    }
};
```
