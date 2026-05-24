Leetcode Question : [Jump Game V](https://leetcode.com/problems/jump-game-v/)

### Java

```java
class Solution {

    private int[] maxReachablePositions;

    private int dfs(int[] heights, int currentIndex, int maxJumpDistance) {

        if (maxReachablePositions[currentIndex] != 0) {
            return maxReachablePositions[currentIndex];
        }

        int maxJumpsFromCurrent = 1;

        for (int direction : new int[]{-1, 1}) {

            for (
                int nextIndex = currentIndex + direction;
                nextIndex >= 0 &&
                nextIndex < heights.length &&
                Math.abs(nextIndex - currentIndex) <= maxJumpDistance &&
                heights[currentIndex] > heights[nextIndex];
                nextIndex += direction
            ) {

                maxJumpsFromCurrent = Math.max(
                    maxJumpsFromCurrent,
                    1 + dfs(heights, nextIndex, maxJumpDistance)
                );
            }
        }

        return maxReachablePositions[currentIndex] = maxJumpsFromCurrent;
    }

    public int maxJumps(int[] heights, int maxJumpDistance) {

        int totalPositions = heights.length;

        maxReachablePositions = new int[totalPositions];

        int maximumPossibleJumps = 1;

        for (int currentIndex = 0; currentIndex < totalPositions; currentIndex++) {
            maximumPossibleJumps = Math.max(
                maximumPossibleJumps,
                dfs(heights, currentIndex, maxJumpDistance)
            );
        }

        return maximumPossibleJumps;
    }
}
```

### C++

```cpp
class Solution {

    vector<int> maxReachablePositions;

    int dfs(vector<int>& heights, int currentIndex, int maxJumpDistance) {

        if (maxReachablePositions[currentIndex] != 0) {
            return maxReachablePositions[currentIndex];
        }

        int maxJumpsFromCurrent = 1;

        for (int direction : {-1, 1}) {

            for (
                int nextIndex = currentIndex + direction;
                nextIndex >= 0 &&
                nextIndex < heights.size() &&
                abs(nextIndex - currentIndex) <= maxJumpDistance &&
                heights[currentIndex] > heights[nextIndex];
                nextIndex += direction
            ) {

                maxJumpsFromCurrent = max(
                    maxJumpsFromCurrent,
                    1 + dfs(heights, nextIndex, maxJumpDistance)
                );
            }
        }

        return maxReachablePositions[currentIndex] = maxJumpsFromCurrent;
    }

public:
    int maxJumps(vector<int>& heights, int maxJumpDistance) {

        int totalPositions = heights.size();

        maxReachablePositions.resize(totalPositions);

        int maximumPossibleJumps = 1;

        for (int currentIndex = 0; currentIndex < totalPositions; currentIndex++) {
            maximumPossibleJumps = max(
                maximumPossibleJumps,
                dfs(heights, currentIndex, maxJumpDistance)
            );
        }

        return maximumPossibleJumps;
    }
};
```
