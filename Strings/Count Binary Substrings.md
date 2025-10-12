Leetcode Question : [Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/)

### Java

```java
class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0, prev = 0, current = 1;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i - 1)) {
                result += Math.min(prev, current);
                prev = current;
                current = 1;
            }
            else {
                current++;
            }
        }

        return result + Math.min(prev, current);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countBinarySubstrings(string s) {
        int result = 0, prev = 0, current = 1;

        for(int i = 1; i < s.length(); i++) {
            if(s[i] != s[i - 1]) {
                result += min(prev, current);
                prev = current;
                current = 1;
            }
            else {
                current++;
            }
        }

        return result + min(prev, current);
    }
};
```
