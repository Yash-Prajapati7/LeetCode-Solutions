Leetcode Question : [Minimum Operations to Convert All Elements to 0](https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero)
- Note : Because of synchronization overhead in Java, instead of `Stack` I used `ArrayDeque`
### Java

```java
class Solution {
    public int minOperations(int[] nums) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int count = 0;
        for (int num : nums) {
            while (!st.isEmpty() && st.peekLast() > num) st.removeLast();
            if (num != 0 && (st.isEmpty() || st.peekLast() < num)) {
                count++;
                st.addLast(num);
            }
        }
        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minOperations(vector<int>& nums) {
        deque<int> st;
        int count = 0;
        for (int num : nums) {
            while (!st.empty() && st.back() > num) st.pop_back();
            if (num != 0 && (st.empty() || st.back() < num)) {
                count++;
                st.push_back(num);
            }
        }
        return count;
    }
};
```
