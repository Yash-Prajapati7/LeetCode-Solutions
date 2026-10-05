Leetcode Question : [Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/)

### Java
```java
class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num--;
            }

            steps++;
        }

        return steps;
    }
}
```

### C++
```cpp
using namespace std;

class Solution {
public:
    int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num--;
            }

            steps++;
        }

        return steps;
    }
};
```
