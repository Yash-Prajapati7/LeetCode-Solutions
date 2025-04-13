Leetcode Question : [Pow(x, n)](https://leetcode.com/problems/powx-n/)

### Java
```java
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 0) return 0;
        if(x == 1) return 1;

        double result = 1;
        long power = n;
        if(n < 0) {
            x = 1/x;
            power = -power;
        }

        while(power > 0) {
            if((power & 1) == 1) result = result * x;
            x *= x;
            power >>= 1;
        }        

        return result;
    }
}
```
