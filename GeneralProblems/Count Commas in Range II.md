### Leetcode Question : [Count Commas in Range II](https://leetcode.com/problems/count-commas-in-range-ii/description/)

### Java

```java
class Solution {
    public long countCommas(long n) {
        long p = 1000, res = 0;

        while (p <= n) {
            res += (n - p + 1);
            p *= 1000;
        }

        return res;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    long long countCommas(long long n) {
        long long p = 1000, res = 0;

        while (p <= n) {
            res += (n - p + 1);
            p *= 1000;
        }

        return res;
    }
};
```
