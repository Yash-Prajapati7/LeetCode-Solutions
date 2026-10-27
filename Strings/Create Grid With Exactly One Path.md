Leetcode Question : [Create Grid With Exactly One Path](https://leetcode.com/problems/create-grid-with-exactly-one-path/)

### Java

```
class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        StringBuilder row = new StringBuilder(n);
        for (int i = 0; i < m; i++) {
            row = new StringBuilder(n);

            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    row.append('.');
                }
            } else {
                for (int j = 0; j < n - 1; j++) {
                    row.append('#');
                }
                row.append('.');
            }

            grid[i] = row.toString();
        }

        return grid;
    }
}
```

### C++

```
using namespace std;

class Solution {
public:
    vector<string> createGrid(int m, int n) {
        vector<string> grid(m);

        string row;
        row.reserve(n);

        for (int i = 0; i < m; i++) {
            row = "";

            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    row.append(".");
                }
            } else {
                for (int j = 0; j < n - 1; j++) {
                    row.append("#");
                }
                row.append(".");
            }

            grid[i] = row;
        }

        return grid;
    }
};
```
