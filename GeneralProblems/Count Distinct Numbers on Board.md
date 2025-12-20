Leetcode Question : [Count Distinct Numbers on Board](https://leetcode.com/problems/count-distinct-numbers-on-board/)

### Java

```java
class Solution {
    public int distinctIntegers(int n) {
        if (n == 1) {
            return 1;
        }
        return n - 1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int distinctIntegers(int n) {
        if (n == 1) {
            return 1;
        }
        return n - 1;
    }
};
```
