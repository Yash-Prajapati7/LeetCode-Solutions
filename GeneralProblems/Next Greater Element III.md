Leetcode Question: [Next Greater Element III](https://leetcode.com/problems/next-greater-element-iii/)

```java
class Solution {
    public int nextGreaterElement(int n) {
        if (n == Integer.MAX_VALUE || n <= 9) return -1;

        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length, i = 0,  j = 0;

        for (i = len - 1; i >= 1; i--) {
            if (digits[i - 1] < digits[i]) {
                break;
            }
        }

        if (i == 0) return -1;
        char x = digits[i - 1];
        int smallest = i;
        for(j = i + 1; j < len; j++) {
            if((digits[j] > x) && (digits[j] <= digits[smallest])) {
                smallest = j;
            }
        }

        char temp = digits[i - 1];
        digits[i - 1] = digits[smallest];
        digits[smallest] = temp;

        // Sort the digits after (i-1) in ascending order
        Arrays.sort(digits, i, len);

        long ans = 0;
        for (char c : digits) {
            ans = (ans * 10) + (c - '0');
        }

        return (ans <= Integer.MAX_VALUE) ? (int) ans : -1;
    }
}
```
