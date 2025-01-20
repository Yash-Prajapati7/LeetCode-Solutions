Leetcode Question : [Check if Every Row and Column Contains All Numbers](https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/)

### Java
```java
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length, index = 0;
        if(n == 1) return true;
        
        for(int i = 0; i < n; i++) {
            int[] freq = new int[n + 1];
            for(int j = 0; j < n; j++) {
                index = matrix[i][j];
                freq[index]++;
                if(freq[index] > 1) return false;
            }
        }

        for(int i = 0; i < n; i++) {
            int[] freq = new int[n + 1];
            for(int j = 0; j < n; j++) {
                index = matrix[j][i];
                freq[index]++;
                if(freq[index] > 1) return false;
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
    bool checkValid(vector<vector<int>>& matrix) {
        int n = matrix.size(), index = 0;
        if (n == 1) return true;
        
        for (int i = 0; i < n; i++) {
            vector<int> freq(n + 1, 0);
            for (int j = 0; j < n; j++) {
                index = matrix[i][j];
                freq[index]++;
                if (freq[index] > 1) return false;
            }
        }

        for (int i = 0; i < n; i++) {
            vector<int> freq(n + 1, 0);
            for (int j = 0; j < n; j++) {
                index = matrix[j][i];
                freq[index]++;
                if (freq[index] > 1) return false;
            }
        }

        return true;
    }
};
```
