Leetcode Question : [Maximum Candies You Can Get from Boxes](https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/)

### Java

```java
class Solution {
    public int maxCandies(
        int[] status, 
        int[] candies, 
        int[][] keys, 
        int[][] containedBoxes, 
        int[] initialBoxes
    ) {
        int n = status.length;
        boolean[] isBoxOpenable = new boolean[n];
        boolean[] isBoxAvailable = new boolean[n];
        boolean[] isBoxProcessed = new boolean[n];

        for (int i = 0; i < n; ++i) {
            isBoxOpenable[i] = (status[i] == 1);
        }

        Queue<Integer> processQueue = new LinkedList<>();
        int totalCandies = 0;

        for (int box : initialBoxes) {
            isBoxAvailable[box] = true;
            if (isBoxOpenable[box]) {
                processQueue.offer(box);
                isBoxProcessed[box] = true;
                totalCandies += candies[box];
            }
        }

        while (!processQueue.isEmpty()) {
            int currentBox = processQueue.poll();

            for (int key : keys[currentBox]) {
                isBoxOpenable[key] = true;
                if (!isBoxProcessed[key] && isBoxAvailable[key]) {
                    processQueue.offer(key);
                    isBoxProcessed[key] = true;
                    totalCandies += candies[key];
                }
            }

            for (int nextBox : containedBoxes[currentBox]) {
                isBoxAvailable[nextBox] = true;
                if (!isBoxProcessed[nextBox] && isBoxOpenable[nextBox]) {
                    processQueue.offer(nextBox);
                    isBoxProcessed[nextBox] = true;
                    totalCandies += candies[nextBox];
                }
            }
        }

        return totalCandies;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxCandies(
        vector<int>& status, 
        vector<int>& candies, 
        vector<vector<int>>& keys, 
        vector<vector<int>>& containedBoxes, 
        vector<int>& initialBoxes
    ) {
        int n = status.size();
        vector<bool> isBoxOpenable(n, false);
        vector<bool> isBoxAvailable(n, false);
        vector<bool> isBoxProcessed(n, false);

        for (int i = 0; i < n; ++i) {
            isBoxOpenable[i] = (status[i] == 1);
        }

        queue<int> processQueue;
        int totalCandies = 0;

        for (int box : initialBoxes) {
            isBoxAvailable[box] = true;
            if (isBoxOpenable[box]) {
                processQueue.push(box);
                isBoxProcessed[box] = true;
                totalCandies += candies[box];
            }
        }

        while (!processQueue.empty()) {
            int currentBox = processQueue.front();
            processQueue.pop();

            for (int key : keys[currentBox]) {
                isBoxOpenable[key] = true;
                if (!isBoxProcessed[key] && isBoxAvailable[key]) {
                    processQueue.push(key);
                    isBoxProcessed[key] = true;
                    totalCandies += candies[key];
                }
            }

            for (int nextBox : containedBoxes[currentBox]) {
                isBoxAvailable[nextBox] = true;
                if (!isBoxProcessed[nextBox] && isBoxOpenable[nextBox]) {
                    processQueue.push(nextBox);
                    isBoxProcessed[nextBox] = true;
                    totalCandies += candies[nextBox];
                }
            }
        }

        return totalCandies;
    }
};
```
