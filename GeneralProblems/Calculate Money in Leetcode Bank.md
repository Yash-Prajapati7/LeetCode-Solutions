Leetcode Question : [Calculate Money in Leetcode Bank](https://leetcode.com/problems/calculate-money-in-leetcode-bank)

### Java

```java
class Solution {
    public int totalMoney(int n) {
        if (n < 8) {
            return (n * (n + 1)) >> 1; // Sum of first n natural numbers
        }

        int completeWeeks = n / 7;      // Number of full weeks
        int remainingDays = n % 7;      // Remaining days in the last partial week

        int lastWeekSum = 28 + (completeWeeks - 1) * 7; // Sum of deposits for the last full week
        int totalFullWeeksSum = (completeWeeks * (28 + lastWeekSum)) >> 1; // Sum of all full weeks

        int nextWeekStartAmount = completeWeeks + 1; // Starting amount for the next week
        int partialWeekSum = 0;
        for (int day = 0; day < remainingDays; day++) {
            partialWeekSum += (nextWeekStartAmount + day);
        }

        return totalFullWeeksSum + partialWeekSum;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int totalMoney(int n) {
        if (n < 8) {
            return (n * (n + 1)) >> 1;
        }

        int completeWeeks = n / 7;
        int remainingDays = n % 7;

        int lastWeekSum = 28 + (completeWeeks - 1) * 7;
        int totalFullWeeksSum = (completeWeeks * (28 + lastWeekSum)) >> 1;

        int nextWeekStartAmount = completeWeeks + 1;
        int partialWeekSum = 0;
        for (int day = 0; day < remainingDays; day++) {
            partialWeekSum += (nextWeekStartAmount + day);
        }

        return totalFullWeeksSum + partialWeekSum;
    }
};
```
