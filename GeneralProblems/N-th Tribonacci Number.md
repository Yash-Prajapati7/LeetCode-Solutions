Leetcode Question : [N-th Tribonacci Number](https://leetcode.com/problems/n-th-tribonacci-number/)  

### Java  
```java
class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;
        int t1 = 0, t2 = 1, t3 = 1, number = 2;
        for(int i = 3; i <= n; i++) {
            number = t1 + t2 + t3;
            t1 = t2;
            t2 = t3;
            t3 = number;
        }
        return number;
    }
}
```
