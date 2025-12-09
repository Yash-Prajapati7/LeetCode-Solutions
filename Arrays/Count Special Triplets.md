Leetcode Question : [Count Special Triplets](https://leetcode.com/problems/count-special-triplets)

### Java

```java
class Solution {

    public int specialTriplets(int[] nums) {  
        final int MOD = 1000000007;  

        Map<Integer, Integer> totalFreq = new HashMap<>();  
        Map<Integer, Integer> seenFreq = new HashMap<>();  

        for (int value : nums) {  
            totalFreq.put(value, totalFreq.getOrDefault(value, 0) + 1);  
        }  

        long result = 0;  

        for (int value : nums) {  
            int doubledValue = value * 2;  

            int leftCount = seenFreq.getOrDefault(doubledValue, 0);  

            seenFreq.put(value, seenFreq.getOrDefault(value, 0) + 1);  

            int rightCount =  
                totalFreq.getOrDefault(doubledValue, 0) -  
                seenFreq.getOrDefault(doubledValue, 0);  

            result = (result + (long) leftCount * rightCount) % MOD;  
        }  

        return (int) result;  
    }

}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int specialTriplets(vector<int>& nums) {
        const int MOD = 1000000007;

        unordered_map<int, int> totalFreq;
        unordered_map<int, int> seenFreq;

        for (int value : nums) {
            totalFreq[value] = totalFreq[value] + 1;
        }

        long long result = 0;

        for (int value : nums) {
            int doubledValue = value * 2;

            int leftCount = 0;
            if (seenFreq.count(doubledValue)) {
                leftCount = seenFreq[doubledValue];
            }

            seenFreq[value] = seenFreq[value] + 1;

            int rightCount = 0;
            if (totalFreq.count(doubledValue)) {
                rightCount = totalFreq[doubledValue] - seenFreq[doubledValue];
            }

            result = (result + (long long)leftCount * rightCount) % MOD;
        }

        return (int)result;
    }
};
```
