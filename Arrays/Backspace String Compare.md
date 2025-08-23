Leetcode Question : [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare)

### Java

```java
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char c = 'a';

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '#') {
                if (sb1.length() > 0) {
                    sb1.setLength(sb1.length() - 1);
                }
            } else {
                sb1.append(c);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if (c == '#') {
                if (sb2.length() > 0) {
                    sb2.setLength(sb2.length() - 1);
                }
            } else {
                sb2.append(c);
            }
        }

        return sb1.toString().equals(sb2.toString());
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool backspaceCompare(string s, string t) {
        string sb1 = "";
        string sb2 = "";
        char c = 'a';

        for (int i = 0; i < s.size(); i++) {
            c = s[i];
            if (c == '#') {
                if (!sb1.empty()) {
                    sb1.pop_back();
                }
            } else {
                sb1.push_back(c);
            }
        }

        for (int i = 0; i < t.size(); i++) {
            c = t[i];
            if (c == '#') {
                if (!sb2.empty()) {
                    sb2.pop_back();
                }
            } else {
                sb2.push_back(c);
            }
        }

        return sb1 == sb2;
    }
};
```
