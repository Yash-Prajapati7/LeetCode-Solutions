Leetcode Question : [Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/)
### Java
```java
import java.util.HashMap;

class Solution {
    private int countSubarray(int [] nums, int k) {
        if(k < 0) {
            return 0;
        }
        int left = 0; 
        int right = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count1 = countSubarray(nums, k);
        int count2 = countSubarray(nums, k - 1);
        return count1 - count2;
    }
}
```
### C++
```cpp
#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
private:
    int countSubarray(vector<int>& nums, int k) {
        if (k < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        unordered_map<int, int> map;
        while (right < nums.size()) {
            map[nums[right]]++;
            while (map.size() > k) {
                map[nums[left]]--;
                if (map[nums[left]] == 0) {
                    map.erase(nums[left]);
                }
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        int count1 = countSubarray(nums, k);
        int count2 = countSubarray(nums, k - 1);
        return count1 - count2;
    }
};
```
