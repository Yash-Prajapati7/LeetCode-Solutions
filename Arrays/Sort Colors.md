Leetcode Question : [Sort Colors](https://leetcode.com/problems/sort-colors/)

## Method - 1

### Java

```java
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return;
        int[] freq = new int[3];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        int i = 0, k = 0;
        while (i < n) {
            if (freq[k] == 0)
                k++;
            else {
                nums[i++] = k;
                freq[k]--;
            }
        }
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        if (n == 1)
            return;
        vector<int> freq(3, 0);
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        int i = 0, k = 0;
        while (i < n) {
            if (freq[k] == 0)
                k++;
            else {
                nums[i++] = k;
                freq[k]--;
            }
        }
    }
};
```

## Method - 2

### Java

```java
class Solution {
    public void sortColors(int[] nums) {
        public void sortColors(int[] nums) {
            int low = 0, mid = 0, high = nums.length - 1;
            while (mid <= high) {
                if (nums[mid] == 0) {
                    int tmp = nums[low];
                    nums[low++] = nums[mid];
                    nums[mid++] = tmp;
                } else if (nums[mid] == 1) {
                    mid++;
                } else {
                    int tmp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high--] = tmp;
                }
            }
        }
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int low = 0, mid = 0, high = nums.size() - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums[low++], nums[mid++]);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums[mid], nums[high--]);
            }
        }
    }
};

```
