LeetCode Question: [Number of Bit Changes to Make Two Integers Equal](https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/)

```java
class Solution {
    public int minChanges(int n, int k) {
        // Check if it's possible to make n equal to k
        if ((n & k) != k) {
            return -1;
        }
        // Count the number of bit changes needed
        return Integer.bitCount(n ^ k);
    }
}
```
