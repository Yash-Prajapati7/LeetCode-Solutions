Leetcode Question : [Number Complement](https://leetcode.com/problems/number-complement/)

### Java
```java
class Solution {
    public int findComplement(int num) {
        if(num == 1) {
            return 0;
        }
        int length = Integer.toBinaryString(num).length();
        int ans = num ^ ((1 << length) - 1);
        return ans;
    }
}
```
