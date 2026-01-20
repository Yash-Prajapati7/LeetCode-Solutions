Leetcode Question : [Construct the Minimum Bitwise Array I](https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/)

### Java

```java
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        int counter = 1, current = 0;

        for(int i = 0; i < n; i++) {
            current = nums.get(i);
            counter = 1;
            
            while(counter < current) {
                if((counter | counter + 1) == current) {
                    ans[i] = counter;
                    break;
                }
                counter++;
            }

            if(counter == current) {
                ans[i] = -1;
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
    vector<int> minBitwiseArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);
        int counter = 1, current = 0;

        for(int i = 0; i < n; i++) {
            current = nums[i];
            counter = 1;

            while(counter < current) {
                if((counter | counter + 1) == current) {
                    ans[i] = counter;
                    break;
                }
                counter++;
            }

            if(counter == current) {
                ans[i] = -1;
            }
        }

        return ans;
    }
};
```
