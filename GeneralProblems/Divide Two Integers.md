Leetcode Question : [Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)
- Note : Here the Java solution will give TLE hence I took help of C++ for this problem
### C++
```cpp
class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        bool isPositive = (dividend < 0) && (divisor < 0) || (dividend > 0) && (divisor > 0);
        unsigned int a = abs(dividend);
        unsigned int b = abs(divisor);
        unsigned int ans = 0;

        while (a >= b) {
            int i = 0;
            while (a > (b << (i + 1))) {
                i++;
            }
            ans += (1 << i);
            a -= (b << i);
        }

        if (ans == (1 << 31) && isPositive) {
            return INT_MAX;
        }

        return isPositive ? ans : -ans;
    }
};
```
### Java
```java
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) {
            return 1;
        }
        boolean isPositive = (dividend < 0) && (divisor < 0) || (dividend > 0) && (divisor > 0);
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int ans = 0;

        while(a >= b) {
            int i = 0;
            while(a > (b << (i + 1))) {
                i++;
            }
            ans += (1 << i);
            a -= (b << i);
        }

        if(ans == (1 << 31) && isPositive) {
            return Integer.MAX_VALUE;
        }
        else {
            return isPositive ? ans : -ans;
        }
    }
}
```
