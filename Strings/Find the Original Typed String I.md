Leetcode Question : [Find the Original Typed String I](https://leetcode.com/problems/find-the-original-typed-string-i/)

### Java

```java
class Solution {
    public int possibleStringCount(String word) {
        int ans = 1;
        int i = 0;
        int n = word.length();

        while(i + 1 < n) {
            if(word.charAt(i) == word.charAt(i + 1)) ans++;
            i++;
        }

        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int possibleStringCount(string word) {
        int ans = 1;
        int i = 0;
        int n = word.length();

        while(i + 1 < n) {
            if(word[i] == word[i + 1]) ans++;
            i++;
        }

        return ans;
    }
};
```
