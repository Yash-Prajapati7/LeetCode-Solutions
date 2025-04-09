Leetcode Question : [Minimum Operations to Make Array Values Equal to K](https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/)

### Java
```java
class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> uniques = new HashSet<>();
        for(int num : nums) {
            if (num < k) return -1;
            if (num > k) uniques.add(num);
        }

        return uniques.size();
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        set<int> uniques;
        for (int num : nums) {
            if (num < k) return -1;
            if (num > k) uniques.insert(num);
        }

        return uniques.size();
    }
};
```
