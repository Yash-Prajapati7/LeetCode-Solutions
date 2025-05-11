Leetcode Question : [Three Consecutive Odds](https://leetcode.com/problems/three-consecutive-odds/)

### Java

```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if(n < 3) return false;
        for(int i = 0; i <= n - 3; i++) {
            if(((arr[i] & 1) == 1) && ((arr[i + 1] & 1) == 1) && ((arr[i + 2] & 1) == 1)) return true;
        }

        return false;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        int n = arr.size();
        if(n < 3) return false;
        for(int i = 0; i <= n - 3; i++) {
            if(((arr[i] & 1) == 1) && ((arr[i + 1] & 1) == 1) && ((arr[i + 2] & 1) == 1)) return true;
        }

        return false;
    }
};
```
