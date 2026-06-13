Leetcode Question : [Remove Palindromic Subsequences](https://leetcode.com/problems/remove-palindromic-subsequences)

### Java

```java
class Solution {
    public int removePalindromeSub(String s) {
        return s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int removePalindromeSub(string s) {
        string reversed = s;
        reverse(reversed.begin(), reversed.end());

        return s == reversed ? 1 : 2;
    }
};
```
