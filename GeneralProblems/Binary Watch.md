LeetCode Question: [Binary Watch](https://leetcode.com/problems/binary-watch/)

```java
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount((h << 6) + m) == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return result;
    }
}
```

### Note:
The expression `h << 6` shifts the bits of `h` (hours) 6 places to the left, effectively multiplying it by \(2^6 = 64\). This ensures that the hour and minute values occupy distinct bit segments when added:
- **Bits 6-11**: Represent the hour (`h`).
- **Bits 0-5**: Represent the minutes (`m`).

This allows the combined number `(h << 6) + m` to be treated as a single binary value for calculating the total number of `1` bits.
