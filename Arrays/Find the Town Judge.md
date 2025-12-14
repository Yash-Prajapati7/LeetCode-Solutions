Leetcode Question : [Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)

### Java

```java
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];

        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }

        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) {
                return i;
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
    int findJudge(int N, vector<vector<int>>& trust) {
        vector<int> count(N + 1, 0);

        for (auto &t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }

        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }
};
```
