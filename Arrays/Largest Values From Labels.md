Leetcode Question : [Largest Values From Labels](https://leetcode.com/problems/largest-values-from-labels/)

### Java

```java
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] mappings = new int[n][2];

        for (int i = 0; i < n; i++) {
            mappings[i][0] = values[i];
            mappings[i][1] = labels[i];
        }

        Arrays.sort(mappings, (a, b) -> b[0] - a[0]);

        HashMap<Integer, Integer> labelFreq = new HashMap<>();
        int result = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (count < numWanted) {
                if (!labelFreq.containsKey(mappings[i][1])) {
                    result += mappings[i][0];
                    labelFreq.put(mappings[i][1], 1);
                    count++;
                } else if (labelFreq.get(mappings[i][1]) < useLimit) {
                    result += mappings[i][0];
                    labelFreq.put(mappings[i][1], labelFreq.get(mappings[i][1]) + 1);
                    count++;
                }
            } else {
                break;  // early exit
            }
        }

        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        int n = values.size();
        vector<vector<int>> mappings(n, vector<int>(2));

        for (int i = 0; i < n; i++) {
            mappings[i][0] = values[i];
            mappings[i][1] = labels[i];
        }

        sort(mappings.begin(), mappings.end(), [](vector<int>& a, vector<int>& b) {
            return b[0] < a[0];
        });

        unordered_map<int, int> labelFreq;
        int result = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (count < numWanted) {
                if (labelFreq.find(mappings[i][1]) == labelFreq.end()) {
                    result += mappings[i][0];
                    labelFreq[mappings[i][1]] = 1;
                    count++;
                } else if (labelFreq[mappings[i][1]] < useLimit) {
                    result += mappings[i][0];
                    labelFreq[mappings[i][1]] = labelFreq[mappings[i][1]] + 1;
                    count++;
                }
            } else {
                break;  // early exit
            }
        }

        return result;
    }
};
```
