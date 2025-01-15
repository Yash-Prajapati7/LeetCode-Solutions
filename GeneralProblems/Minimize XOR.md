Leetcode Question : [Minimize XOR](https://leetcode.com/problems/minimize-xor/)

```java
class Solution {
    public int minimizeXor(int num1, int num2) {
        int temp1 = num1, temp2 = num2;
        int bitCount1 = 0, bitCount2 = 0;

        for(int i = 0; i < 32 && temp1 > 0; i++) {
            if((temp1 & 1) == 1) bitCount1++;
            temp1 >>= 1;
        }

        for(int i = 0; i < 32 && temp2 > 0; i++) {
            if((temp2 & 1) == 1) bitCount2++;
            temp2 >>= 1;
        }

        int diff = bitCount1 - bitCount2;
        if(diff == 0) return num1;

        if(diff > 0) {
            while(diff-- > 0) {
                num1 &= (num1 - 1);
            }
        }
        else {
            diff = -diff;
            while(diff-- > 0) {
                num1 |= (num1 + 1);
            }
        }

        return num1;
    }
}
```

### Key Points
1. If the set bits in both numbers are equal, the minimal value is `0`, so `num1` itself becomes the answer.
2. If the set bits in `num1` are greater than in `num2` (`diff > 0`), unset `diff` number of set bits from the least significant bit (LSB) of `num1` using the equation `n & (n - 1)`.
3. If `diff < 0`, add the required number of set bits to the LSB of `num1` using the equation `n | (n + 1)`.
