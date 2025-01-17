Leetcode Question: [Neighboring Bitwise XOR](https://leetcode.com/problems/neighboring-bitwise-xor)

```java
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for(int derivative : derived) xor ^= derivative;

        return xor == 0 ? true : false;
    }
}
```

**Note:** The idea behind this is- a valid solution only exists if the XOR sum of the derived array is zero. This is because all the values are occurring exactly twice, and (a ^ a) = 0.
