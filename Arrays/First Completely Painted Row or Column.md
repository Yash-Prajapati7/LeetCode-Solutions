Leetcode Question: [First Completely Painted Row or Column](https://leetcode.com/problems/first-completely-painted-row-or-column/)

### Java
```java
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int len = arr.length;
        int m = mat.length, n = mat[0].length;

        int[] indexArr = new int[len + 1];
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indexArr[mat[i][j]] = (n * i) + j;
            }
        }

        int index = 0, row = 0, col = 0;
        for (int i = 0; i < len; i++) {
            index = indexArr[arr[i]];
            row = index / n;
            col = index % n;
            rows[row]++;
            cols[col]++;

            if (rows[row] == n || cols[col] == m) return i;
        }

        return len - 1;
    }
}
```

### C++
```cpp
class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        int len = arr.size();
        int m = mat.size(), n = mat[0].size();

        vector<int> indexArr(len + 1);
        vector<int> rows(m, 0);
        vector<int> cols(n, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indexArr[mat[i][j]] = (n * i) + j;
            }
        }

        int index = 0, row = 0, col = 0;
        for (int i = 0; i < len; i++) {
            index = indexArr[arr[i]];
            row = index / n;
            col = index % n;
            rows[row]++;
            cols[col]++;

            if (rows[row] == n || cols[col] == m) return i;
        }

        return len - 1;
    }
};
```
