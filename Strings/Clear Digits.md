Leetcode Question : [Clear Digits](https://leetcode.com/problems/clear-digits/)  

### Java
```java
class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        char c = 'a';
        for(int charIndex = 0; charIndex < s.length(); charIndex++) {
            len = sb.length();
            c = s.charAt(charIndex);
            if(len > 0 && c >= '0' && c <= '9') {
                sb.setLength(len - 1);
            }
            else {
                sb.append(c);
            }
        }
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
    string clearDigits(string s) {
        string sb;
        int len = 0;
        char c = 'a';
        for(int charIndex = 0; charIndex < s.length(); charIndex++) {
            len = sb.length();
            c = s[charIndex];
            if(len > 0 && c >= '0' && c <= '9') {
                sb.pop_back();
            }
            else {
                sb.push_back(c);
            }
        }
        return sb;
    }
};
```
