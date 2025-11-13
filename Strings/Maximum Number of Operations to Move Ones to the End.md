Leetcode Question : [Maximum Number of Operations to Move Ones to the End](https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/)

### Java

```java
public class Solution {
    public int maxOperations(String s) {
        int ones = 0;
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
                    i++;
                }
                ans += ones;
            } else {
                ones++;
            }
            i++;
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
    int maxOperations(string s) {
        int ones = 0;
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (s[i] == '0') {
                while (i + 1 < s.length() && s[i + 1] == '0') {
                    i++;
                }
                ans += ones;
            } else {
                ones++;
            }
            i++;
        }
        return ans;
    }
};
```
