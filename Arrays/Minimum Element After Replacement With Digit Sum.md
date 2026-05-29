Leetcode Question : [Minimum Element After Replacement With Digit Sum](https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum)

### Java

```java
class Solution {
    public int minElement(int[] nums) {
        int min = nums[0];
        int sum = 0;

        for(int num : nums) {
            sum = 0;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
            min = (sum < min) ? sum : min;
        }

        return min;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minElement(vector<int>& nums) {
        int min = nums[0];
        int sum = 0;

        for(int num : nums) {
            sum = 0;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }
            min = (sum < min) ? sum : min;
        }

        return min;
    }
};
```
