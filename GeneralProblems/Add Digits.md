Leetcode Question : [Add Digits](https://leetcode.com/problems/add-digits/)

```java
class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        int ans = num % 9;
        return ans == 0 ? 9 : ans;
    }
}
```
