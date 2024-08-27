Leetcode Question: [Number of Good Pairs](https://leetcode.com/problems/number-of-good-pairs/)

### Java

**Method - 1**
```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

**Method - 2**
```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;
        for(int val : freq.values()) {
            ans += (val * (val - 1) / 2);
        }

        return ans;
    }
}
```

### C++

**Method - 1**
```cpp
class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        int count = 0;
        for(int i = 0; i < nums.size(); i++) {
            for(int j = i + 1; j < nums.size(); j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
};
```

**Method - 2**
```cpp
class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        unordered_map<int, int> freq;
        for(int i = 0; i < nums.size(); i++) {
            freq[nums[i]]++;
        }

        int ans = 0;
        for(auto& [key, val] : freq) {
            ans += (val * (val - 1) / 2);
        }

        return ans;
    }
};
```
