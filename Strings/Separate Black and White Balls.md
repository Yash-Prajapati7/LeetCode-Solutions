Leetcode Question : [Separate Black and White Balls](https://leetcode.com/problems/separate-black-and-white-balls/)

### Java

```java
class Solution {
    public long minimumSteps(String s) {
        int whitePos = 0;
        long ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                ans += i - whitePos;
                whitePos++;
            }
        }
        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long minimumSteps(string s) {
        int whitePos = 0;
        long ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s[i] == '0') {
                ans += i - whitePos;
                whitePos++;
            }
        }
        return ans;
    }
};
```
