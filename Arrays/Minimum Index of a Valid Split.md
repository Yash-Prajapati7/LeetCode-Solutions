Leetcode Question : [Minimum Index of a Valid Split](https://leetcode.com/problems/minimum-index-of-a-valid-split/)  

### Method - 1 (Using HashMaps)  
**Time Complexity - O(n)**  
**Space Complexity - O(2n)**  
#### Java  
```java
class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        int n = nums.size();

        // Add all elements of nums to secondMap
        for (int num : nums) {
            secondMap.put(num, secondMap.getOrDefault(num, 0) + 1);
        }

        for (int index = 0; index < n; index++) {
            // Create split at current index
            int num = nums.get(index);
            secondMap.put(num, secondMap.get(num) - 1);
            firstMap.put(num, firstMap.getOrDefault(num, 0) + 1);

            // Check if valid split
            if (
                firstMap.get(num) * 2 > index + 1 &&
                secondMap.get(num) * 2 > n - index - 1
            ) {
                return index;
            }
        }

        // No valid split exists
        return -1;
    }
}
```

#### C++  
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumIndex(vector<int>& nums) {
        unordered_map<int, int> firstMap, secondMap;
        int n = nums.size();

        // Add all elements of nums to secondMap
        for (int num : nums) {
            secondMap[num]++;
        }

        for (int index = 0; index < n; index++) {
            // Create split at current index
            int num = nums[index];
            secondMap[num]--;
            firstMap[num]++;

            // Check if valid split
            if (firstMap[num] * 2 > index + 1 &&
                secondMap[num] * 2 > n - index - 1) {
                return index;
            }
        }

        // No valid split exists
        return -1;
    }
};
```

---

### Method - 2 (Boyer-Moore Majority Voting Algorithm)  
**Time Complexity - O(3N)**  
**Space Complexity - O(1)**  
#### Java  
```java
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int x = nums.get(0), count = 1, n = nums.size(), remaining = 0;

        for(int num : nums) {
            count = num == x ? count + 1 : count - 1;
            if(count == 0) {
                x = num;
                count = 1;
            }
        }

        int xCount = 0;
        for(int num : nums) if(num == x) xCount++;

        count = 0;
        for(int idx = 0; idx < n - 1; idx++) {
            if(nums.get(idx) == x) count++;
            remaining = xCount - count;
            if((count << 1) > idx + 1 && (remaining << 1) > n - idx - 1) return idx;
        }

        return -1;
    }
}
```

#### C++  
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minimumIndex(vector<int>& nums) {
        int x = nums[0], count = 1, n = nums.size(), remaining = 0;

        for (int num : nums) {
            count = (num == x) ? count + 1 : count - 1;
            if (count == 0) {
                x = num;
                count = 1;
            }
        }

        int xCount = count = 0;
        for (int num : nums) if (num == x) xCount++;

        for (int idx = 0; idx < n - 1; idx++) {
            if (nums[idx] == x) count++;
            remaining = xCount - count;
            if ((count << 1) > idx + 1 && (remaining << 1) > n - idx - 1) return idx;
        }

        return -1;
    }
};
```
