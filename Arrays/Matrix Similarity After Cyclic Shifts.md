Leetcode Question : [Matrix Similarity After Cyclic Shifts](https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/)
### Java
```java
class Solution {
  public boolean areSimilar(int[][] mat, int k) {
    int n = mat[0].length;
    for (int[] row : mat){
        for (int j = 0; j < n; j++){
            if (row[j] != row[(j + k) % n]){
                return false;
            }
        }
    }  
    return true;
  }
}
```
### C++
```cpp
class Solution {
public:
    bool areSimilar(vector<vector<int>>& mat, int k) {
        int n = mat[0].size();
        for (const auto& row : mat) {
            for (int j = 0; j < n; ++j) {
                if (row[j] != row[(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
};
```

**Dry Run**

1. **Initialization:**
   - `n` (number of columns) = 3
   - `mat` = `[[1, 2, 3], [2, 3, 1], [3, 1, 2]]`
   - `k` = 1

2. **Iterate over each row:**

   - **Row 1:** `[1, 2, 3]`
     - Check if `row[j]` matches `row[(j + k) % n]`:
       - `j = 0`: (row[0] = `1`) == (row[(j + k) % n] = `2`) (Index `(0 + 1) % 3 = 1`), Not equal. Therefore, return `false`.

3. **Result:**
   - The function returns `false` immediately because the condition fails for the first row.

**Conclusion**

Since the first row fails the similarity check, the function returns `false`. The rows of the matrix are not all similar after cyclic shifts by `k = 1`.
