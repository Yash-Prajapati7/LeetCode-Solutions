Leetcode Question : [Group the People Given the Group Size They Belong To](https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/)

### Java
```java
import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            groups.computeIfAbsent(size, k -> new ArrayList<>()).add(i);

            if (groups.get(size).size() == size) { // If we've reached the group size
                ans.add(new ArrayList<>(groups.get(size))); // Create a new group
                groups.remove(size); // Clear the group for this size
            }
        }
        return ans;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        unordered_map<int, vector<int>> groups;
        vector<vector<int>> ans;

        for (int i = 0; i < groupSizes.size(); i++) {
            int size = groupSizes[i];
            groups[size].push_back(i);

            if (groups[size].size() == size) {
                ans.push_back(groups[size]);
                groups.erase(size);
            }
        }
        return ans;
    }
};
```
