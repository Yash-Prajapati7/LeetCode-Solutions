### Leetcode Question : [Maximum Product of Two Digits](https://leetcode.com/problems/maximum-product-of-two-digits/)

### Java

```java
class Solution {
    public int maxProduct(int n) {
        int firstMax = 0, secondMax = 0;
        int currentDigit = 0;

        while(n > 0) {
            currentDigit = n % 10;

            if(currentDigit > firstMax) {
                secondMax = firstMax;
                firstMax = currentDigit;
            } else if(currentDigit > secondMax) {
                secondMax = currentDigit;
            }

            n /= 10;
        }

        return firstMax * secondMax;
    }
}
```

### C++

```cpp
class Solution {
public:
    int maxProduct(int n) {
        int firstMax = 0, secondMax = 0;
        int currentDigit = 0;

        while (n > 0) {
            currentDigit = n % 10;

            if (currentDigit > firstMax) {
                secondMax = firstMax;
                firstMax = currentDigit;
            } else if (currentDigit > secondMax) {
                secondMax = currentDigit;
            }

            n /= 10;
        }

        return firstMax * secondMax;
    }
};
```
