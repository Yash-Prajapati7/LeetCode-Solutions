Leetcode Question : [Arranging Coins](https://leetcode.com/problems/arranging-coins/)

```java
class Solution {
    public int arrangeCoins(int n) {
        if(n == 1) return 1;

        int ans = 0;
        long left = 1, right = n;
        long mid = 0, sum = 0;

        while(left < right) {
            mid = (left + right) >> 1;
            sum = (mid * (mid + 1)) >> 1;

            if(sum <= n) {
                ans = (int)mid;
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return ans;
    }
}
```
