Leetcode Question : [Sort Even and Odd Indices Independently](https://leetcode.com/problems/sort-even-and-odd-indices-independently/)

### Java

```java
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;

        List<Integer> evenList = new ArrayList<>(n >> 1);
        List<Integer> oddList = new ArrayList<>(n >> 1);

        // separate elements
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                evenList.add(nums[i]);
            } else {
                oddList.add(nums[i]);
            }
        }

        // sort
        Collections.sort(evenList); // ascending
        Collections.sort(oddList, Collections.reverseOrder()); // descending

        int idx1 = 0, idx2 = 0;

        // put back into original array
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = evenList.get(idx1++);
            } else {
                nums[i] = oddList.get(idx2++);
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
    vector<int> sortEvenOdd(vector<int>& nums) {
        int n = nums.size();

        vector<int> evenList;
        vector<int> oddList;

        // separate elements
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                evenList.push_back(nums[i]);
            } else {
                oddList.push_back(nums[i]);
            }
        }

        // sort
        sort(evenList.begin(), evenList.end()); // ascending
        sort(oddList.begin(), oddList.end(), greater<int>()); // descending

        int idx1 = 0, idx2 = 0;

        // put back into original array
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = evenList[idx1++];
            } else {
                nums[i] = oddList[idx2++];
            }
        }

        return nums;
    }
};
```
