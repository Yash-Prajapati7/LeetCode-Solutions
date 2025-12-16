Leetcode Question : [Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

### Java

```java
class Solution {
    public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] result = s.toCharArray();

        for (int j = 0; j < n; ++j, ++i) {
            result[i] = result[j];
            if (i > 0 && result[i - 1] == result[i]) {
                i -= 2;
            }
        }

        return new String(result, 0, i);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string removeDuplicates(string s) {
        int i = 0, n = s.length();
        vector<char> result(s.begin(), s.end());

        for (int j = 0; j < n; ++j, ++i) {
            result[i] = result[j];
            if (i > 0 && result[i - 1] == result[i]) {
                i -= 2;
            }
        }

        return string(result.begin(), result.begin() + i);
    }
};
```
