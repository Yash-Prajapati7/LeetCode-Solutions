Leetcode Question : [To Lower Case](https://leetcode.com/problems/to-lower-case/)

### Java

```java
class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char)(chars[i] + 32);
            }
        }

        return new String(chars);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string toLowerCase(string s) {
        for(int i = 0; i < s.length(); i++) {
            if(s[i] >= 'A' && s[i] <= 'Z') {
                s[i] = char(s[i] + 32);
            }
        }
        return s;
    }
};
```
