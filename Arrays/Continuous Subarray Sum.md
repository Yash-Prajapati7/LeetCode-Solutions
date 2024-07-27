Leetcode Question : [Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/)
## Brute Force
### Java
```java
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            sum = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(sum % k == 0) return true;
            }
        }
        return false;
    }
}
```

### C++
```cpp
#include <vector>
using namespace std;

class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.size() - 1; i++) {
            sum = nums[i];
            for(int j = i + 1; j < nums.size(); j++) {
                sum += nums[j];
                if(sum % k == 0) return true;
            }
        }
        return false;
    }
};
```
## Optimal Approach
### Java
```java
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        
        return false;
    }
}
```

### C++
```cpp
#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        map[0] = -1;
        int sum = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            int mod = sum % k;
            
            if (map.find(mod) != map.end()) {
                if (i - map[mod] > 1) {
                    return true;
                }
            } else {
                map[mod] = i;
            }
        }
        
        return false;
    }
};
```
