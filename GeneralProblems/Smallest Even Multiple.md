Leetcode Question : [Smallest Even Multiple](https://leetcode.com/problems/smallest-even-multiple/)  

```java
class Solution {
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public int smallestEvenMultiple(int n) {
        return (n << 1) / gcd(n , 2);   // returning the lcm
    }
}
```
