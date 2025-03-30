Leetcode Question : [Strictly Palindromic Number](https://leetcode.com/problems/strictly-palindromic-number/)
## Method - 1
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
## Method - 2
```java
class Solution {
    public boolean isStrictlyPalindromic(int n) {
        return false;
    }
}
```
- For any number n, its representation in base (n-2) will always be "12", which is not palindromic. Hence, the answer is always false for every possible input. Lol!
