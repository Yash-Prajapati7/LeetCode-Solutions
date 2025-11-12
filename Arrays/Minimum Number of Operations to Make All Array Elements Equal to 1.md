Leetcode Question : [Minimum Number of Operations to Make All Array Elements Equal to 1](https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1)
> Explaination for (minLen - 1) + (n - 1) in the end : <br>
> If neither of the above cases applies, we find the smallest interval where the gcd of all numbers in the interval equals 1. Suppose the length of this interval is minLen.<br> Then, the number of operations required to obtain a 1 from these numbers is minLen−1.<br> After obtaining a 1, the number of operations required to convert the remaining elements into 1s using this 1 is n−1. <br>Therefore, the total number of operations needed is (minLen - 1) + (n - 1).

### Java

```java
class Solution {
    private int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int num1 = 0;
        int g = 0;

        for (int x : nums) {
            if (x == 1) {
                num1++;
            }
            g = gcd(g, x);
        }

        if (num1 > 0) {
            return n - num1;
        }

        if (g > 1) {
            return -1;
        }

        int minLen = n;
        for (int i = 0; i < n; i++) {
            int currentGcd = 0;
            for (int j = i; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return (minLen - 1) + (n - 1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

public:
    int minOperations(vector<int>& nums) {
        int n = nums.size();
        int num1 = 0, g = 0;

        for (int x : nums) {
            if (x == 1) num1++;
            g = gcd(g, x);
        }

        if (num1 > 0) return n - num1;
        if (g > 1) return -1;

        int minLen = n;
        for (int i = 0; i < n; i++) {
            int currentGcd = 0;
            for (int j = i; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return (minLen - 1) + (n - 1);
    }
};
```
