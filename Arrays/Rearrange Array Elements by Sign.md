Leetcode Question : [Rearrange Array Elements by Sign](https://leetcode.com/problems/rearrange-array-elements-by-sign/)

## Approach - 1

### Java
```java
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int size = n >> 1;
        int[] pos = new int[size];
        int[] neg = new int[size];
        int j = 0, k = 0;

        for(int num : nums) {
            if(num > 0) {
                pos[j++] = num;
            }
            else {
                neg[k++] = num;
            }
        }

        j = 0;
        k = 0;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                nums[i] = pos[j++];
            }
            else {
                nums[i] = neg[k++];
            }
        }

        return nums;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int n = nums.size();
        int size = n >> 1;
        vector<int> pos(size);
        vector<int> neg(size);
        int j = 0, k = 0;

        for(int num : nums) {
            if(num > 0) {
                pos[j++] = num;
            } else {
                neg[k++] = num;
            }
        }

        j = 0;
        k = 0;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                nums[i] = pos[j++];
            } else {
                nums[i] = neg[k++];
            }
        }

        return nums;
    }
};
```

## Approach - 2

### Java
```java
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
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
    vector<int> rearrangeArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n);

        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }
};
```
