Leetcode Question : [Make Sum Divisible by P](https://leetcode.com/problems/make-sum-divisible-by-p/)

### Java
```java
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        int rem = (int)(totalSum % p);
        if(rem == 0) {
            return 0;
        }

        long prefixSum = 0;
        int minLen = n;

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int currentMod = (int)(prefixSum % p);
            int targetMod = (currentMod - rem + p) % p;
            if(hm.containsKey(targetMod)) {
                minLen = Math.min(minLen, i - hm.get(targetMod));
            }
            hm.put(currentMod, i);
        }
        return minLen == n ? -1 : minLen;
    }
}
```

### C++
```cpp
class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        int n = nums.size();
        long totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        int rem = (int)(totalSum % p);
        if(rem == 0) {
            return 0;
        }

        long prefixSum = 0;
        int minLen = n;

        unordered_map<int, int> hm;
        hm[0] = -1;

        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int currentMod = (int)(prefixSum % p);
            int targetMod = (currentMod - rem + p) % p;
            if(hm.find(targetMod) != hm.end()) {
                minLen = min(minLen, i - hm[targetMod]);
            }
            hm[currentMod] = i;
        }
        return minLen == n ? -1 : minLen;
    }
};
```
