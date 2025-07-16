Leetcode Question : [Find the Maximum Length of a Valid Subsequence I](https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/)

### Java

```java
class Solution {
    public int maximumLength(int[] nums) {
        if(nums.length == 2) return 2;
        int even = 0, odd = 0, alternate = 1;
        int parity = nums[0] % 2;

        for(int num : nums) {
            if(num % 2 == 0) {
                even++;
                if(parity == 1) {
                    alternate++;
                }
            }
            else {
                odd++;
                if(parity == 0) {
                    alternate++;
                }
            }

            parity = num % 2;
        }

        int max = even > odd ? even : odd;
        max = max > alternate ? max : alternate;
        return max;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumLength(vector<int>& nums) {
        if(nums.size() == 2) return 2;
        int even = 0, odd = 0, alternate = 1;
        int parity = nums[0] % 2;

        for(int num : nums) {
            if(num % 2 == 0) {
                even++;
                if(parity == 1) {
                    alternate++;
                }
            }
            else {
                odd++;
                if(parity == 0) {
                    alternate++;
                }
            }

            parity = num % 2;
        }

        int maxVal = even > odd ? even : odd;
        maxVal = maxVal > alternate ? maxVal : alternate;
        return maxVal;
    }
};
```
