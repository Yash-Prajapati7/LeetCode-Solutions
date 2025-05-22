Leetcode Question : [Zero Array Transformation III](https://leetcode.com/problems/zero-array-transformation-iii/)

### Java

```java
class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length, m = queries.length;
        int[] sweep = new int[n + 1];

        int j = 0;  // pointer for queries
        int operations = 0;
        for(int i = 0; i < n; i++) {
            operations += sweep[i]; // add for 'L'
            // add the 'r' in the heap
            while(j < m && queries[j][0] == i) {
                heap.offer(queries[j][1]);
                j++;
            }

            while(operations < nums[i] && !heap.isEmpty() && heap.peek() >= i) {
                operations += 1;
                sweep[heap.poll() + 1] -= 1;   // do '-1' at (r + 1)
            }

            if(operations < nums[i]) return -1; // converting the element at index i to 0 is not possible
        }
        return heap.size();
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxRemoval(vector<int>& nums, vector<vector<int>>& queries) {
        sort(queries.begin(), queries.end());
        priority_queue<int> heap;
        int n = nums.size(), m = queries.size();
        vector<int> sweep(n + 1, 0);

        int j = 0;
        int operations = 0;
        for (int i = 0; i < n; i++) {
            operations += sweep[i];
            while (j < m && queries[j][0] == i) {
                heap.push(queries[j][1]);
                j++;
            }

            while (operations < nums[i] && !heap.empty() && heap.top() >= i) {
                operations++;
                sweep[heap.top() + 1] -= 1;
                heap.pop();
            }

            if (operations < nums[i]) return -1;
        }
        return heap.size();
    }
};
```
