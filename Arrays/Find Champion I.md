Leetcode Question : [Find Champion I](https://leetcode.com/problems/find-champion-i/)
## Method 1 (Brute Force)
### Java
```java
class Solution {
    public int findChampion(int[][] grid) {
        int count = 0, max = 0;
        int maxRow = 0;
        int n = grid.length;
        
        for(int i = 0; i < n; i++) {
            count = 0;
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    if(grid[i][j] == 1) {
                        count++;
                    }
                }
            }

            if(count > max) {
                max = count;
                maxRow = i;
            }
        }

        return maxRow;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findChampion(vector<vector<int>>& grid) {
        int count = 0, max = 0;
        int maxRow = 0;
        int n = grid.size();
        
        for(int i = 0; i < n; i++) {
            count = 0;
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    if(grid[i][j] == 1) {
                        count++;
                    }
                }
            }

            if(count > max) {
                max = count;
                maxRow = i;
            }
        }

        return maxRow;
    }
};
```
## Method 2 (Optimized Approach)
### Java
```java
class Solution {
    public int findChampion(int[][] grid) {
        int team = 0;
        int n = grid.length;
        
        for(int i = 0; i < n; i++) {
            if(grid[i][team] == 1) {
                team = i;
            }
        }

        return team;
    }
}
```

### C++ 
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findChampion(vector<vector<int>>& grid) {
        int team = 0;
        int n = grid.size();
        
        for(int i = 0; i < n; i++) {
            if(grid[i][team] == 1) {
                team = i;
            }
        }

        return team;
    }
};
```
