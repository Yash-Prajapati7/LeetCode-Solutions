Leetcode Question : [Count of Interesting Subarrays](https://leetcode.com/problems/count-of-interesting-subarrays/)

## Method - 1 (Brute Force)
### Java
```java
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int cnt = 0, ans = 0;
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            cnt = 0;
            for(int j = i; j < n; j++) {
                if(nums.get(j) % modulo == k) cnt++;
                if(cnt % modulo == k) ans++;
            }
        }
        return ans;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long countInterestingSubarrays(vector<int>& nums, int modulo, int k) {
        int cnt = 0;
        long long ans = 0;
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            cnt = 0;
            for(int j = i; j < n; j++) {
                if(nums[j] % modulo == k) cnt++;
                if(cnt % modulo == k) ans++;
            }
        }
        return ans;
    }
};
```

## Method - 2 (Optimized)
### Java
```java
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        Map<Integer, Integer> prefixRemainderCount = new HashMap<>();
        long result = 0;
        int specialCount = 0;
        prefixRemainderCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k) {
                specialCount++;
            }
            int requiredRemainder = (specialCount - k + modulo) % modulo;
            result += prefixRemainderCount.getOrDefault(requiredRemainder, 0);
            int currentRemainder = specialCount % modulo;
            prefixRemainderCount.put(
                currentRemainder,
                prefixRemainderCount.getOrDefault(currentRemainder, 0) + 1
            );
        }

        return result;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long countInterestingSubarrays(vector<int>& nums, int modulo, int k) {
        int n = nums.size();
        unordered_map<int, int> prefixRemainderCount;
        long long result = 0;
        int specialCount = 0;
        prefixRemainderCount[0] = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] % modulo == k) {
                specialCount++;
            }
            int requiredRemainder = (specialCount - k + modulo) % modulo;
            result += prefixRemainderCount[requiredRemainder];
            int currentRemainder = specialCount % modulo;
            prefixRemainderCount[currentRemainder]++;
        }

        return result;
    }
};
```
