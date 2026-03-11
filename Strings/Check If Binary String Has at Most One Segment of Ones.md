Leetcode Question : [Check If Binary String Has at Most One Segment of Ones](https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/)

### Java

```java
class Solution {
    public boolean checkOnesSegment(String s) {
        boolean contiguous = false;
        int i = 0, j = 0, n = s.length();
        
        while(i < n) {
            if(s.charAt(i) == '1') {
                if(contiguous) return false;
                contiguous = true;
                j = i + 1;

                while(j < n) {
                    if(s.charAt(j) == '0') {
                        break;
                    }
                    j++;
                }

                i = j + 1;                
            }
            else {
                i++;
            }
        }

        return contiguous;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool checkOnesSegment(string s) {
        bool contiguous = false;
        int i = 0, j = 0, n = s.length();
        
        while(i < n) {
            if(s[i] == '1') {
                if(contiguous) return false;
                contiguous = true;
                j = i + 1;

                while(j < n) {
                    if(s[j] == '0') {
                        break;
                    }
                    j++;
                }

                i = j + 1;                
            }
            else {
                i++;
            }
        }

        return contiguous;
    }
};
```
