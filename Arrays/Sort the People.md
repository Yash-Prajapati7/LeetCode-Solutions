Leetcode Question: [Sort the People](https://leetcode.com/problems/sort-the-people/)
### Java
```java
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on the corresponding heights in descending order
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);

        String[] sortedPeople = new String[n];
        for (int i = 0; i < n; i++) {
            sortedPeople[i] = names[indices[i]];
        }

        return sortedPeople;
    }
}
```
### C++
```cpp
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<string> sortPeople(vector<string>& names, vector<int>& heights) {
        int n = names.size();
        vector<int> indices(n);
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on the corresponding heights in descending order
        sort(indices.begin(), indices.end(), [&](int a, int b) {
            return heights[b] - heights[a];
        });

        vector<string> sortedPeople(n);
        for (int i = 0; i < n; i++) {
            sortedPeople[i] = names[indices[i]];
        }

        return sortedPeople;
    }
};
```
