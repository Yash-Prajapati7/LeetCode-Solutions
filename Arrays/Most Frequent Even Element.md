Leetcode Question : [Most Frequent Even Element](https://leetcode.com/problems/most-frequent-even-element/description/)
### Java
```java
class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        int maxFreqNum = -1;

        for (int num : nums) {
            if (num % 2 == 0) {
                // Update frequency using compute method
                int newFreq = freq.compute(num, (key, val) -> val == null ? 1 : val + 1);

                if (newFreq > maxFreq) {
                    maxFreq = newFreq;
                    maxFreqNum = num;
                } else if (newFreq == maxFreq) {
                    maxFreqNum = Math.min(maxFreqNum, num);
                }
            }
        }

        return maxFreqNum;
    }
}
```
### C++
```cpp
class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        unordered_map<int, int> freq;
        int maxFreq = 0;
        int maxFreqNum = -1;

        for (int num : nums) {
            if (num % 2 == 0) {
                // Update frequency
                int newFreq = ++freq[num];

                if (newFreq > maxFreq) {
                    maxFreq = newFreq;
                    maxFreqNum = num;
                } else if (newFreq == maxFreq) {
                    maxFreqNum = min(maxFreqNum, num);
                }
            }
        }
        return maxFreqNum;
    }
};
```
