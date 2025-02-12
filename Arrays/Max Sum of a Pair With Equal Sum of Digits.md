Leetcode Question : [Max Sum of a Pair With Equal Sum of Digits](https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/)  

### Java
```java
class Solution {
    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        int[] map = new int[82]; // Since max sum of digits for the constraints can be 81
        int digitsSum = 0, max = -1, currentMax = 0;

        for (int num : nums) {
            digitsSum = sumOfDigits(num);

            if (map[digitsSum] != 0) {
                currentMax = num + map[digitsSum];
                max = max < currentMax ? currentMax : max;
            }

            map[digitsSum] = map[digitsSum] < num ? num : map[digitsSum];
        }

        return max;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

public:
    int maximumSum(vector<int>& nums) {
        vector<int> map(82, 0); // Since max sum of digits for the constraints can be 81
        int digitsSum = 0, max = -1, currentMax = 0;

        for (int num : nums) {
            digitsSum = sumOfDigits(num);

            if (map[digitsSum] != 0) {
                currentMax = num + map[digitsSum];
                max = max < currentMax ? currentMax : max;
            }

            map[digitsSum] = map[digitsSum] < num ? num : map[digitsSum];
        }

        return max;
    }
};
```
