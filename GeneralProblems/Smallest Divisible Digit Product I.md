## Leetcode Question : [Smallest Divisible Digit Product I](https://leetcode.com/problems/smallest-divisible-digit-product-i/)

### Java

```java
class Solution {
    public int smallestNumber(int n, int t) {
        while (n <= 100) {
            int product = 1;
            int current = n;

            while (current > 0) {
                product *= (current % 10);
                current /= 10;
            }

            if (product % t == 0) {
                return n;
            }
            n++;
        }

        return 0;
    }
}
```

### C++

```cpp
class Solution {
public:
    int smallestNumber(int n, int t) {
        while (n <= 100) {
            int product = 1;
            int current = n;

            while (current > 0) {
                product *= (current % 10);
                current /= 10;
            }

            if (product % t == 0) {
                return n;
            }
            n++;
        }

        return 0;
    }
};
```
