Leetcode Question : [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)

### Java

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int currentArea = 0, max = -1, width;

        Deque<Integer> st = new ArrayDeque<>(n);
        int left = 0, right = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || heights[st.peek()] > heights[i])) {
                right = st.pop();
                left = st.isEmpty() ? -1 : st.peek();
                width = i - left - 1;
                currentArea = heights[right] * width;
                max = (max < currentArea) ? currentArea : max;
            }
            st.push(i);
        }

        return max;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        int currentArea = 0, max = -1, width;

        deque<int> st;
        int left = 0, right = 0;

        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || heights[st.back()] > heights[i])) {
                right = st.back();
                st.pop_back();
                left = st.empty() ? -1 : st.back();
                width = i - left - 1;
                currentArea = heights[right] * width;
                max = (max < currentArea) ? currentArea : max;
            }
            st.push_back(i);
        }

        return max;
    }
};
```
