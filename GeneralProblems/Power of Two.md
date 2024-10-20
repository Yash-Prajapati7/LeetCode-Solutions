Leetcode Question : [Power of Two](https://leetcode.com/problems/power-of-two/)

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        for(int i = 0; i < 31; i++) {
            if(1 << i == n) {
                return true;
            }
        }
        return false;
    }
}
```
