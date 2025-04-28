Leetcode Question : [Longest Uncommon Subsequence I](https://leetcode.com/problems/longest-uncommon-subsequence-i/)

### Java
```java
class Solution {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)) return -1;
        int m = a.length(), n = b.length();
        return m < n ? n : m;        
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findLUSlength(string a, string b) {
        if(a == b) return -1;
        int m = a.length(), n = b.length();
        return m < n ? n : m;        
    }
};
```
