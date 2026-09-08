### Leetcode Question : [Count Commas in Range](https://leetcode.com/problems/count-commas-in-range/)

### Java

```java
class Solution {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }

        return n - 1000 + 1;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }

        return n - 1000 + 1;
    }
};
```
