Leetcode Question: [Maximum Swap](https://leetcode.com/problems/maximum-swap/)

```java
class Solution {
    public int maximumSwap(int num) {
        int res = num;
        int maxDigit = -1;
        int maxPosition = 1;    // Position of maxDigit in the given num
        int unit = 1;   // For units, tens, hundreds... place
        int diff = 0;

        while(num > 0) {
            int current = num % 10;
            if(current > maxDigit) {
                maxDigit = current;
                maxPosition = unit;
            }
            else {
                diff = Math.max(diff, (maxDigit - current) * (unit - maxPosition));
            }
            unit *= 10;
            num /= 10;
        }

        return res + diff;
    }
}
```
