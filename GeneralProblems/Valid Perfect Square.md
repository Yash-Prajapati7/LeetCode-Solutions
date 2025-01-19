Leetcode Question: [Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)

### Method - 1
```java
class Solution {
    public boolean isPerfectSquare(int num) {
        int sqrtnum = (int)(Math.sqrt(num));
        return ((sqrtnum * sqrtnum) == num);
    }
}
```

### Method - 2
```java
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1, right = num, mid = 0;
        long squaredNum = 0;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            squaredNum = (long) mid * mid;

            if (squaredNum == num) return true;
            else if (squaredNum > num) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}
```
