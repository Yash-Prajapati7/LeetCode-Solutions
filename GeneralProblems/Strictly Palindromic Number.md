Leetcode Question : [Strictly Palindromic Number](https://leetcode.com/problems/strictly-palindromic-number/)
### Java
```java
class Solution {
    public boolean isStrictlyPalindromic(int n) {
        if(n == 4) return false;
        int radix = 2;
        String num = "";
        
        while(radix <= n - 2) {
            num = Integer.toString(n, radix);
            int l = 0, r = num.length() - 1;
            while(l < r) {
                if(num.charAt(l) != num.charAt(r)) return false;
                l++;
                r--;
            }
            radix++;
        }

        return true;
    }
}
```
