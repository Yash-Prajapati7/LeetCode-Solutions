Leetcode Question : [Delete Characters to Make Fancy String](https://leetcode.com/problems/delete-characters-to-make-fancy-string)

### Java

```java
class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if(n < 3) return s;
        
        StringBuilder sb = new StringBuilder(n);
        char[] chars = s.toCharArray();
        for(int i = 0; i < n - 2; i++) {
            if(chars[i] != chars[i + 2]) sb.append(chars[i]);
            else if(chars[i] != chars[i + 1]) sb.append(chars[i]);
        }
        sb.append(chars[n - 2]);
        sb.append(chars[n - 1]);

        return new String(sb);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string makeFancyString(string s) {
        int n = s.length();
        if(n < 3) return s;

        string result;
        for(int i = 0; i < n - 2; i++) {
            if(s[i] != s[i + 2]) result.push_back(s[i]);
            else if(s[i] != s[i + 1]) result.push_back(s[i]);
        }
        result.push_back(s[n - 2]);
        result.push_back(s[n - 1]);

        return result;
    }
};
```
