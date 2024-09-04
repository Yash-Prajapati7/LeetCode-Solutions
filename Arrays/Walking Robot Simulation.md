Leetcode Question: [Walking Robot Simulation](https://leetcode.com/problems/walking-robot-simulation/)

### Java
```java
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0;
        int result = 0;
        HashSet<String> hs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            hs.add(obstacle[0] + " " + obstacle[1]);
        }

        for (int cmd : commands) {
            if (cmd == -1) {
                d = (d + 1) % 4;
            } else if (cmd == -2) {
                d = d == 0 ? 3 : (d - 1) % 4;
            } else {
                int dx = direction[d][0];
                int dy = direction[d][1];
                for (int i = 0; i < cmd; i++) {
                    if (hs.contains((x + dx) + " " + (y + dy))) {
                        break;
                    }
                    x = x + dx;
                    y = y + dy;
                }
                result = Math.max(result, x * x + y * y);
            }
        }
        return result;
    }
}
```

### C++
```cpp
#include <vector>
#include <unordered_set>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        vector<vector<int>> direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0;
        int result = 0;
        unordered_set<string> hs;
        for (auto& obstacle : obstacles) {
            hs.insert(to_string(obstacle[0]) + " " + to_string(obstacle[1]));
        }

        for (int cmd : commands) {
            if (cmd == -1) {
                d = (d + 1) % 4;
            } else if (cmd == -2) {
                d = d == 0 ? 3 : (d - 1) % 4;
            } else {
                int dx = direction[d][0];
                int dy = direction[d][1];
                for (int i = 0; i < cmd; i++) {
                    if (hs.count(to_string(x + dx) + " " + to_string(y + dy))) {
                        break;
                    }
                    x = x + dx;
                    y = y + dy;
                }
                result = max(result, x * x + y * y);
            }
        }
        return result;
    }
};
```
