Leetcode Question : [Check Divisibility by Digit Sum and Product](https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/)

### Java

```java
class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1;
        int num = n;
        int digit = 0;

        while (num > 0) {
            digit = num % 10;
            sum += digit;
            product *= digit;

            num /= 10;
        }

        return (n % (sum + product)) == 0;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    bool checkDivisibility(int n) {
        int sum = 0, product = 1;
        int num = n;
        int digit = 0;

        while (num > 0) {
            digit = num % 10;
            sum += digit;
            product *= digit;

            num /= 10;
        }

        return (n % (sum + product)) == 0;
    }
};
```
