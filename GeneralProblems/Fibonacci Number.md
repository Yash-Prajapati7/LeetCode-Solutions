Leetcode Question : [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)

### Method - 1 (iterative)
```java
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;
        int fib1 = 0, fib2 = 1;
        int temp = 0;

        for(int i = 2; i <= n; i++) {
            temp = fib2;
            fib2 = fib1 + fib2;
            fib1 = temp;
        }
        return fib2;
    }
}
```

### Method - 2 (Recursive)
```java
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
```
