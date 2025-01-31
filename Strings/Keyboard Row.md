Leetcode Question : [Keyboard Row](https://leetcode.com/problems/keyboard-row/)

### Java
```java
class Solution {
    public String[] findWords(String[] words) {
        int[] rowsOfAlphabets = { 2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3 };
        int row = 0, ind = 0, i = 1;
        char c = 'a';
        boolean isAns = true;
        List<String> ans = new ArrayList<>();

        for(String word : words) {
            isAns = true;
            c = word.charAt(0);
            ind = c >= 'A' && c <= 'Z' ? c - 'A' : c - 'a';
            row = rowsOfAlphabets[ind];

            for(i = 1; i < word.length(); i++) {
                c = word.charAt(i);
                ind = c >= 'A' && c <= 'Z' ? c - 'A' : c - 'a';
                if(rowsOfAlphabets[ind] != row) {
                    isAns = false;
                    break;
                }
            }

            if(isAns) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[0]);
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        vector<int> rowsOfAlphabets = { 2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3 };
        int row = 0, ind = 0, i = 1;
        char c = 'a';
        bool isAns = true;
        vector<string> ans;

        for(const string& word : words) {
            isAns = true;
            c = word[0];
            ind = (c >= 'A' && c <= 'Z') ? c - 'A' : c - 'a';
            row = rowsOfAlphabets[ind];

            for(i = 1; i < word.length(); i++) {
                c = word[i];
                ind = (c >= 'A' && c <= 'Z') ? c - 'A' : c - 'a';
                if(rowsOfAlphabets[ind] != row) {
                    isAns = false;
                    break;
                }
            }

            if(isAns) {
                ans.push_back(word);
            }
        }

        return ans;
    }
};
```
