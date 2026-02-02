Leetcode Question : [Decode Ways](https://leetcode.com/problems/decode-ways/)

### Java

```java
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        
        for(int i = n - 2; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
            }
            else {
                dp[i] = dp[i + 1];  // a single char is always valid
                if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numDecodings(string s) {
        if(s[0] == '0') {
            return 0;
        }

        int n = s.length();
        vector<int> dp(n + 1);
        dp[n] = 1;
        dp[n - 1] = s[n - 1] == '0' ? 0 : 1;
        
        for(int i = n - 2; i >= 0; i--) {
            if(s[i] == '0') {
                dp[i] = 0;
            }
            else {
                dp[i] = dp[i + 1];  // a single char is always valid
                if(s[i] == '1' || (s[i] == '2' && s[i + 1] <= '6')) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
};
```
