Leetcode Question : [Adjacent Increasing Subarrays Detection I](https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/)

### Java

```java
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int a = 0, b = a + k;
        int n = nums.size();

        while(b + k - 1 < n) {
            boolean moveAForward = false;
            for(int i = a; i < a + k - 1; i++) {
                if(nums.get(i) >= nums.get(i + 1)) {
                    moveAForward = true;
                    break;
                }
            }

            if(moveAForward) {
                a++;
                b++;
                continue;
            }

            for(int i = b; i < b + k - 1; i++) {
                if(nums.get(i) >= nums.get(i + 1)) {
                    moveAForward = true;
                    break;
                }
            }

            if(moveAForward) {
                a++;
                b++;
                continue;
            }

            return true;
        }

        return false;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool hasIncreasingSubarrays(vector<int>& nums, int k) {
        int a = 0, b = a + k;
        int n = nums.size();

        while (b + k - 1 < n) {
            bool moveAForward = false;
            for (int i = a; i < a + k - 1; i++) {
                if (nums[i] >= nums[i + 1]) {
                    moveAForward = true;
                    break;
                }
            }

            if (moveAForward) {
                a++;
                b++;
                continue;
            }

            for (int i = b; i < b + k - 1; i++) {
                if (nums[i] >= nums[i + 1]) {
                    moveAForward = true;
                    break;
                }
            }

            if (moveAForward) {
                a++;
                b++;
                continue;
            }

            return true;
        }

        return false;
    }
};
```
