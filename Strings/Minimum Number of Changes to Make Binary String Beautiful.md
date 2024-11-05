Leetcode Question : [Minimum Number of Changes to Make Binary String Beautiful](https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/)

### Java
```java
class Solution {
    public int minChanges(String s) {
        int ans = 0;
        int n = s.length();

        for(int i = 0; i < n - 1; i += 2) {
            if(s.charAt(i) != s.charAt(i + 1)) {
                ++ans;
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
    int minChanges(string s) {
        int ans = 0;
        int n = s.length();

        for(int i = 0; i < n - 1; i += 2) {
            if(s[i] != s[i + 1]) {
                ++ans;
            }
        }

        return ans;
    }
};
```
