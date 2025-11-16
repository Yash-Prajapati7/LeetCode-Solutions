Leetcode Question : [Number of Substrings with only Ones](https://leetcode.com/problems/number-of-substrings-with-only-1s)

### Java

```java
class Solution {
    public int numSub(String s) {
        int mod = 1000000007;
        int result = 0;
        int onesStreak = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                onesStreak++;
                result = (result + onesStreak) % mod;
            }
            else {
                onesStreak = 0;
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
    int numSub(string s) {
        int mod = 1000000007;
        long long result = 0;
        long long onesStreak = 0;
        int n = s.size();

        for(int i = 0; i < n; i++) {
            if(s[i] == '1') {
                onesStreak++;
                result = (result + onesStreak) % mod;
            } else {
                onesStreak = 0;
            }
        }

        return (int)result;
    }
};
```
