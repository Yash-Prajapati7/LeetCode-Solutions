Leetcode Question : [Count Square Sum Triples](https://leetcode.com/problems/count-square-sum-triples)

### Java

```java
class Solution {
    public int countTriples(int n) {
        int result = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c = (int) Math.sqrt(a * a + b * b + 1.0);
                if (c <= n && c * c == a * a + b * b) {
                    result++;
                }
            }
        }
        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countTriples(int n) {
        int result = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c = (int) sqrt(a * a + b * b + 1.0);
                if (c <= n && c * c == a * a + b * b) {
                    result++;
                }
            }
        }
        return result;
    }
};
```
