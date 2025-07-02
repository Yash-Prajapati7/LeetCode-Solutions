Leetcode Question : [Degree of an Array](https://leetcode.com/problems/degree-of-an-array/)

### Java

```java
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] firstOccurence = new int[50000];
        int[] lastOccurence = new int[50000];
        int n = nums.length;
        int max = 1, current = 0, num = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            num = nums[i];
            if (freq.containsKey(num)) {
                current = freq.get(num) + 1;
                freq.put(num, current);
                max = max < current ? current : max;
                lastOccurence[num] = i;
            } else {
                freq.put(num, 1);
                firstOccurence[num] = i;
            }
        }

        if(max == 1) return 1;

        for (int i = 0; i < n; i++) {
            num = nums[i];
            if (freq.get(num) == max) {
                current = lastOccurence[num] - firstOccurence[num] + 1;
                ans = ans > current ? current : ans;
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
    int findShortestSubArray(vector<int>& nums) {
        unordered_map<int, int> freq;
        int firstOccurence[50000] = {0};
        int lastOccurence[50000] = {0};
        int n = nums.size();
        int max = 1, current = 0, num = -1;
        int ans = INT_MAX;

        for (int i = 0; i < n; i++) {
            num = nums[i];
            if (freq.count(num)) {
                current = freq[num] + 1;
                freq[num] = current;
                max = max < current ? current : max;
                lastOccurence[num] = i;
            } else {
                freq[num] = 1;
                firstOccurence[num] = i;
            }
        }

        if (max == 1) return 1;

        for (int i = 0; i < n; i++) {
            num = nums[i];
            if (freq[num] == max) {
                current = lastOccurence[num] - firstOccurence[num] + 1;
                ans = ans > current ? current : ans;
            }
        }

        return ans;
    }
};
```
