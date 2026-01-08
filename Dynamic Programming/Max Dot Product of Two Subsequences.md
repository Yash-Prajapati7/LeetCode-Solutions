Leetcode Question : [Max Dot Product of Two Subsequences](https://leetcode.com/problems/max-dot-product-of-two-subsequences/)

### Java

```java
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];

        for(int i = 0; i <= n1; i++) {
            for(int j = 0; j <= n2; j++) {
                dp[i][j] = Integer.MIN_VALUE;                
            }
        }

        int product = 0, r1 = 0, r2 = 0;

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                product = nums1[i - 1] * nums2[j - 1]; 

                r1 = (dp[i - 1][j - 1] > 0) ? dp[i - 1][j - 1] : 0;
                r1 = r1 + product;
                r2 = (dp[i - 1][j] > dp[i][j - 1]) ? dp[i - 1][j] : dp[i][j - 1];

                dp[i][j] = (r1 > r2) ? r1 : r2;          
            }
        }

        return dp[n1][n2];
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size(), n2 = nums2.size();
        vector<vector<int>> dp(n1 + 1, vector<int>(n2 + 1, INT_MIN));

        int product = 0, r1 = 0, r2 = 0;

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                product = nums1[i - 1] * nums2[j - 1];

                r1 = (dp[i - 1][j - 1] > 0) ? dp[i - 1][j - 1] : 0;
                r1 = r1 + product;
                r2 = (dp[i - 1][j] > dp[i][j - 1]) ? dp[i - 1][j] : dp[i][j - 1];

                dp[i][j] = (r1 > r2) ? r1 : r2;
            }
        }

        return dp[n1][n2];
    }
};
```
