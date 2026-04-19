Leetcode Question : [Maximum Distance Between a Pair of Values](https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/)

## Approach - 1 (Brute Force)

### Java

```java
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int result = 0;

        for(int j = 0; j < nums2.length; j++) {
            for(int i = 0; i < nums1.length; i++) {
                if(i > j) break;

                if(nums1[i] <= nums2[j]) {
                    result = (j - i) > result ? (j - i) : result;
                }
            }
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
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        int result = 0;

        for(int j = 0; j < nums2.size(); j++) {
            for(int i = 0; i < nums1.size(); i++) {
                if(i > j) break;

                if(nums1[i] <= nums2[j]) {
                    result = (j - i) > result ? (j - i) : result;
                }
            }
        }

        return result;
    }
};
```

## Approach - 2 (Optimised)

### Java

```java
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int result = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                result = Math.max(result, j - i);
                j++;
            } else {
                i++;
            }
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
    int maxDistance(vector<int>& nums1, vector<int>& nums2) {
        int i = 0, j = 0;
        int result = 0;

        while(i < nums1.size() && j < nums2.size()) {
            if(nums1[i] <= nums2[j]) {
                result = max(result, j - i);
                j++;
            } else {
                i++;
            }
        }

        return result;
    }
};
```
