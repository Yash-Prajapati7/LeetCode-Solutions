Leetcode Question : [Minimum Deletions to Make String Balanced](https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/)

### Java

```java
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int result = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'b') {
                count++;
            }
            else if(count > 0) {
                result++;
                count--;
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
    int minimumDeletions(string s) {
        int n = s.length();
        int result = 0;
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(s[i] == 'b') {
                count++;
            }
            else if(count > 0) {
                result++;
                count--;
            }
        }

        return result;
    }
};
```
