Leetcode Question: [Power of Four](https://leetcode.com/problems/power-of-four/)

### Method - 1 (Iterative Approach)  
```java
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }

        return true;
    }
}
```

### Method - 2 (Math Approach)  
```java
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        double logBase4 = Math.log(n) / Math.log(4);
        return (logBase4 == (int)logBase4);
    }
}
```
