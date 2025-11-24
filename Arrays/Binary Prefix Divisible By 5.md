Leetcode Question : [Binary Prefix Divisible By 5](https://leetcode.com/problems/binary-prefix-divisible-by-5/)

### Java

```java
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int length = nums.length;
        List<Boolean> answer = new ArrayList<Boolean>(length);
        int prefix = 0;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        int length = nums.size();
        vector<bool> answer;
        answer.reserve(length);
        int prefix = 0;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            answer.push_back(prefix == 0);
        }
        return answer;
    }
};
```
