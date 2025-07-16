Leetcode Question : [Shuffle an Array](https://leetcode.com/problems/shuffle-an-array/)
Reference: [Fisher–Yates Shuffle - Wikipedia](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle)

### Java

```java
import java.util.Random;

class Solution {
    int[] original;
    Random rand;

    public Solution(int[] nums) {
        original = nums;
        rand = new Random();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        int[] shuffled = original.clone();
        for (int i = shuffled.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap shuffled[i] with shuffled[j]
            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }
        return shuffled;
    }
}
```
