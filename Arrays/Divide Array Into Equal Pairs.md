Leetcode Question : [Divide Array Into Equal Pairs](https://leetcode.com/problems/divide-array-into-equal-pairs/)

### Java

```java
class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        for(int num : nums) {
            freq[num]++;
        }

        for(int f : freq) {
            if((f & 1) == 1) return false;
        }

        return true;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool divideArray(vector<int>& nums) {
        int freq[501] = {};
        for(int num : nums) {
            freq[num]++;
        }

        for(int f : freq) {
            if((f & 1) == 1) return false;
        }

        return true;
    }
};
```
