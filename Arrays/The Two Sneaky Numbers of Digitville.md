Leetcode Question : [The Two Sneaky Numbers of Digitville](https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/)

### Java

```java
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] seen = new int[n];
        int[] ans = new int[2];
        int k = 0;

        for(int num : nums) {
            if(seen[num] == 1) {
                ans[k++] = num;
            }
            else {
                seen[num]++;
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
    vector<int> getSneakyNumbers(vector<int>& nums) {
        int n = nums.size();
        vector<int> seen(n, 0);
        vector<int> ans(2);
        int k = 0;

        for(int num : nums) {
            if(seen[num] == 1) {
                ans[k++] = num;
            }
            else {
                seen[num]++;
            }
        }

        return ans;
    }
};
```
