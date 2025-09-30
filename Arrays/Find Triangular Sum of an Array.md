Leetcode Question : [Find Triangular Sum of an Array](https://leetcode.com/problems/find-triangular-sum-of-an-array)

### Java

```java
class Solution {

    public int triangularSum(int[] nums) {
        List<Integer> current = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());

        while (current.size() > 1) {
            List<Integer> newNums = new ArrayList<>(current.size());
            for (int i = 0; i < current.size() - 1; ++i) {
                newNums.add((current.get(i) + current.get(i + 1)) % 10);
            }
            current = newNums;
        }
        
        return current.get(0);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int triangularSum(vector<int>& nums) {
        vector<int> current = nums;
        while (current.size() > 1) {
            vector<int> newNums;
            newNums.reserve(current.size() - 1);
            for (int i = 0; i < current.size() - 1; ++i) {
                newNums.push_back((current[i] + current[i + 1]) % 10);
            }
            current = newNums;
        }
        return current[0];
    }
};
```
