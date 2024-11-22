Leetcode Question: [Consecutive Characters](https://leetcode.com/problems/consecutive-characters/)

### Java
```java
class Solution {
    public int maxPower(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int count = 0, max = 0;

        while(r < n && l <= r) {
            if(s.charAt(l) == s.charAt(r)) {
                count = r - l + 1;
            }
            else {
                max = Math.max(count, max);
                count = 0;
                l = r;
            }
            r++;
        }

        return Math.max(count, max);
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxPower(string s) {
        int n = s.length();
        int l = 0, r = 0;
        int count = 0, maxVal = 0;

        while(r < n && l <= r) {
            if(s[l] == s[r]) {
                count = r - l + 1;
            }
            else {
                maxVal = max(count, maxVal);
                count = 0;
                l = r;
            }
            r++;
        }

        return max(count, maxVal);
    }
};

```
