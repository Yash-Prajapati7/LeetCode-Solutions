Leetcode Question : [Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/)

## Approach - 1 (Brute Force)
### Java
```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>(n >> 1);
        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(int num : nums) {
            if(hm.get(num) == 1) return num;
        }

        return -1;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> hm(n >> 1);
        for(int num : nums) {
            hm[num]++;
        }

        for(int num : nums) {
            if(hm[num] == 1) return num;
        }

        return -1;
    }
};
```

## Modified Approach - 1
### Java
```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>(n >> 1);
        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        while(hm.get(nums[i]) != 1) {
            i += 2;
        }

        return nums[i];
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> hm(n >> 1);
        for(int num : nums) {
            hm[num]++;
        }

        int i = 0;
        while(hm[nums[i]] != 1) {
            i += 2;
        }

        return nums[i];
    }
};
```

## Approach - 2 (Optimized Approach)
### Java
```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = -1;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(mid % 2 == 0) {
                if(mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                }
                else if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    right = mid - 1;
                }
                else {
                    return nums[mid];
                }
            }
            else {
                if(mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    right = mid - 1;
                }
                else if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                }
                else {
                    return nums[mid];
                }
            }
        }
        return -1;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int n = nums.size();
        int left = 0, right = n - 1;
        int mid = -1;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(mid % 2 == 0) {
                if(mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                }
                else if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    right = mid - 1;
                }
                else {
                    return nums[mid];
                }
            }
            else {
                if(mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    right = mid - 1;
                }
                else if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                }
                else {
                    return nums[mid];
                }
            }
        }
        return -1;
    }
};
```
