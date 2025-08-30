Leetcode Question : [Alice and Bob Playing Flower Game](https://leetcode.com/problems/alice-and-bob-playing-flower-game/)

### Java

```java
class Solution {
    public long flowerGame(int n, int m) {
        return ((long) m * n) >> 1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long flowerGame(int n, int m) {
        return ((long long)m * n) >> 1;
    }
};
```
