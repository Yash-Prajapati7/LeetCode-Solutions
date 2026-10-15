Leetcode Question : [Subarrays Distinct Element Sum of Squares I](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/)

### Java

```java
class Solution {
    public int sumCounts(List<Integer> nums) {
        int result = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean[] visited = new boolean[101];

            for (int j = i; j < n; j++) {
                int num = nums.get(j);

                if (!visited[num]) {
                    visited[num] = true;
                    count++;
                }

                result += count * count;
            }
        }

        return result;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int sumCounts(vector<int>& nums) {
        int result = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int count = 0;
            vector<bool> visited(101, false);

            for (int j = i; j < n; j++) {
                int num = nums[j];

                if (!visited[num]) {
                    visited[num] = true;
                    count++;
                }

                result += count * count;
            }
        }

        return result;
    }
};
```
