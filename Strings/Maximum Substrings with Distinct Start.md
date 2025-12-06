Leetcode Question : [Maximum Substrings with Distinct Start](https://leetcode.com/problems/maximum-substrings-with-distinct-start/)

Java
```java
class Solution {
    public int maxDistinct(String s) {
        boolean[] chars = new boolean[26];
        int result = 0;
        for(char c : s.toCharArray()) {
            if(!chars[c - 'a']) {
                chars[c - 'a'] = true;
                result++;
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
    int maxDistinct(string s) {
        bool chars[26] = {false};
        int result = 0;
        for(char c : s) {
            if(!chars[c - 'a']) {
                chars[c - 'a'] = true;
                result++;
            }
        }
        return result;
    }
};
```
