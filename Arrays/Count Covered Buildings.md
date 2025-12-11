Leetcode Question : [Count Covered Buildings](https://leetcode.com/problems/count-covered-buildings)

## Method - 1 (Brute Force)

### Java

```java
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int count = 0;
        int[] rows = new int[n + 1];
        int[] cols = new int[n + 1];
        Set<Integer> cordinates = new HashSet<>(1000);
        int x = 0, y = 0;

        for(int[] location : buildings) {
            x = location[0];
            y = location[1];
            rows[x]++;
            cols[y]++;
            cordinates.add((x * 10) + y);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(cordinates.contains((i * 10) + y)) {
                    if(rows[i] > 2 && cols[j] > 2) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countCoveredBuildings(int n, vector<vector<int>>& buildings) {
        int count = 0;
        vector<int> rows(n + 1), cols(n + 1);
        unordered_set<int> cordinates;
        int x = 0, y = 0;

        for (auto& location : buildings) {
            x = location[0];
            y = location[1];
            rows[x]++;
            cols[y]++;
            cordinates.insert((x * 10) + y);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (cordinates.count((i * 10) + y)) {
                    if (rows[i] > 2 && cols[j] > 2) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
};
```

## Method - 2 (Optimised)

### Java

```java
class Solution {

    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];

        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);

        int x = 0, y = 0;

        for (int[] p : buildings) {
            x = p[0];
            y = p[1];
            maxRow[y] = maxRow[y] > x ? maxRow[y] : x;
            minRow[y] = minRow[y] < x ? minRow[y] : x;
            maxCol[x] = maxCol[x] > y ? maxCol[x] : y;
            minCol[x] = minCol[x] < y ? minCol[x] : y;
        }

        int res = 0;
        for (int[] p : buildings) {
            x = p[0];
            y = p[1];
            if (x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]) {
                res++;
            }
        }

        return res;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countCoveredBuildings(int n, vector<vector<int>>& buildings) {
        vector<int> maxRow(n + 1), minRow(n + 1, n + 1);
        vector<int> maxCol(n + 1), minCol(n + 1, n + 1);

        int x = 0, y = 0;

        for (auto& p : buildings) {
            x = p[0];
            y = p[1];
            maxRow[y] = max(maxRow[y], x);
            minRow[y] = min(minRow[y], x);
            maxCol[x] = max(maxCol[x], y);
            minCol[x] = min(minCol[x], y);
        }

        int res = 0;
        for (auto& p : buildings) {
            x = p[0];
            y = p[1];
            if (x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]) {
                res++;
            }
        }

        return res;
    }
};
```
