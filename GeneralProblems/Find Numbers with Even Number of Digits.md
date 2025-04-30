Leetcode Question : [Find Numbers with Even Number of Digits](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/)

### Java
```java
class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            if(num == 100000 || (num > 999 && num < 10000) || (num > 9 && num < 100)) ans++;
        }
        return ans;
    }
}
```
