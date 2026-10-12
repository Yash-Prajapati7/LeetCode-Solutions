Leetcode Question : [Apply Operations on Array to Maximize Sum of Squares](https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/)

### Java

```
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int mod = 1000000007;
        long result = 0, current = 0;
        int[] bitCount = new int[30];

        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            current = 0;

            for (int j = 29; j >= 0; j--) {
                if (bitCount[j] > 0) {
                    current |= (1L << j);
                    bitCount[j]--;
                }
            }

            result = (result + current * current) % mod;
        }

        return (int) result;
    }
}
```

### C++

```
class Solution {
public:
    int maxSum(vector<int>& nums, int k) {
        const int mod = 1000000007;
        long long result = 0, current = 0;
        int bitCount[30] = {};

        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            current = 0;

            for (int j = 29; j >= 0; j--) {
                if (bitCount[j] > 0) {
                    current |= (1LL << j);
                    bitCount[j]--;
                }
            }

            result = (result + current * current) % mod;
        }

        return (int) result;
    }
};
```
