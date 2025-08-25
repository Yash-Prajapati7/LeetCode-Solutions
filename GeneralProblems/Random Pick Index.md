Leetcode Question : [Random Pick Index](https://leetcode.com/problems/random-pick-index/)

### Java

```java
class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int current = 0;
    
    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int length = map.get(target).size();
        return map.get(target).get(current++ % length);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
    unordered_map<int, vector<int>> map;
    int current = 0;
    
public:
    Solution(vector<int>& nums) {
        for(int i = 0; i < nums.size(); i++) {
            map[nums[i]].push_back(i);
        }
    }
    
    int pick(int target) {
        int length = map[target].size();
        return map[target][current++ % length];
    }
};
```
