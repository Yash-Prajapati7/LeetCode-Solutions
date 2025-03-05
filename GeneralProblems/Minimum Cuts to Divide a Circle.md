Leetcode Question : [Minimum Cuts to Divide a Circle](https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/)

```java
class Solution {
    public int numberOfCuts(int n) {
        if(n == 1) return 0;
        if(n % 2 == 0) return n >> 1;
        else return n;
    }
}
```
