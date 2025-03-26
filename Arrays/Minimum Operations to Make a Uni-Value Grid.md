Leetcode Question : [Minimum Operations to Make a Uni-Value Grid](https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/)

### Java
```java
class Solution {
    public int minOperations(int[][] grid, int x) {
        int numberOfElements = grid.length * grid[0].length;
        if(numberOfElements == 1) return 0;
        
        List<Integer> elements = new ArrayList<>(numberOfElements);
        int finalRemainder = grid[0][0] % x;
        for(int[] rows : grid) {
            for(int ele : rows) {
                if(ele % x != finalRemainder) return -1;
                elements.add(ele);
            }
        }
        Collections.sort(elements);
        int median = elements.get(numberOfElements >> 1);
        int operations = 0;

        for(int[] rows : grid) {
            for(int ele : rows) {
                operations += (ele < median) ? (median - ele) / x : (ele - median) / x ;
            }
        }

        return operations;
    }
}
```

### C++
```cpp
class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        int numberOfElements = grid.size() * grid[0].size();
        if (numberOfElements == 1) return 0;

        vector<int> elements;
        elements.reserve(numberOfElements);
        int finalRemainder = grid[0][0] % x;
        
        for (auto& rows : grid) {
            for (int ele : rows) {
                if (ele % x != finalRemainder) return -1;
                elements.push_back(ele);
            }
        }
        sort(elements.begin(), elements.end());
        int median = elements[numberOfElements >> 1];
        int operations = 0;

        for (auto& rows : grid) {
            for (int ele : rows) {
                operations += (ele < median) ? (median - ele) / x : (ele - median) / x;
            }
        }

        return operations;
    }
};
```
