Leetcode Question : [Minimum ASCII Delete Sum for Two Strings](https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/)

### Java

```java
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        int totalASCII = 0;

        for(int j = 0; j < n2; j++) {
            totalASCII += (int)s2.charAt(j);
        }

        int c1 = 0, c2 = 0;

        for(int i = 1; i <= n1; i++) {
            c1 = (int)s1.charAt(i - 1);
            totalASCII += c1;
            
            for(int j = 1; j <= n2; j++) {
                c2 = (int)s2.charAt(j - 1);
                if(c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + c1;
                }
                else {
                    dp[i][j] = (dp[i - 1][j] > dp[i][j - 1]) ? dp[i - 1][j] : dp[i][j - 1];
                }         
            }
        }

        return totalASCII - (dp[n1][n2] << 1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumDeleteSum(string s1, string s2) {
        int n1 = s1.length(), n2 = s2.length();
        vector<vector<int>> dp(n1 + 1, vector<int>(n2 + 1, 0));
        int totalASCII = 0;

        for(int j = 0; j < n2; j++) {
            totalASCII += (int)s2[j];
        }

        int c1 = 0, c2 = 0;

        for(int i = 1; i <= n1; i++) {
            c1 = (int)s1[i - 1];
            totalASCII += c1;

            for(int j = 1; j <= n2; j++) {
                c2 = (int)s2[j - 1];
                if(c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + c1;
                } else {
                    dp[i][j] = (dp[i - 1][j] > dp[i][j - 1]) ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }

        return totalASCII - (dp[n1][n2] << 1);
    }
};
```
