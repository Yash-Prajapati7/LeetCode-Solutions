Leetcode Question : https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/
```java
class Solution {
    public int minimumSum(int num) {
        // Extract digits
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        // Sort the digits
        Arrays.sort(digits);
        // Form two new numbers and return their sum
        return ((digits[0] * 10 + digits[2]) + (digits[1] * 10 + digits[3]));
    }
}
```
