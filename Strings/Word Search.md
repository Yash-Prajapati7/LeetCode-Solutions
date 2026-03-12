Leetcode Question : [Word Search](https://leetcode.com/problems/word-search/)

### Java

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        int[] dir = {1, 0, -1, 0, 1};

        for (int d = 0; d < 4; d++) {
            int newRow = i + dir[d];
            int newCol = j + dir[d + 1];

            if (backtrack(board, word, newRow, newCol, index + 1)) {
                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size();
        int n = board[0].size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

private:
    bool backtrack(vector<vector<char>>& board, string& word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() 
            || board[i][j] != word[index]) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        int dir[5] = {1, 0, -1, 0, 1};

        for (int d = 0; d < 4; d++) {
            int newRow = i + dir[d];
            int newCol = j + dir[d + 1];

            if (backtrack(board, word, newRow, newCol, index + 1)) {
                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
};
```
