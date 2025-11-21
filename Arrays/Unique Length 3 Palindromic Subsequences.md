Leetcode Question : [Unique Length 3 Palindromic Subsequences](https://leetcode.com/problems/unique-length-3-palindromic-subsequences/)

### Java

```java
class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] indexes = new int[26][2];

        for (int i = 0; i < 26; i++) {
            indexes[i][0] = -1;
            indexes[i][1] = -1;
        }

        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            k = s.charAt(i) - 'a';
            if (indexes[k][0] == -1) {
                indexes[k][0] = i;
                indexes[k][1] = i;
            } else {
                indexes[k][1] = i;
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            int first = indexes[i][0];
            int last = indexes[i][1];

            if (first != -1 && first != last) {
                Set<Character> uniqueMiddleChars = new HashSet<>(26);
                for (int j = first + 1; j < last; j++) {
                    uniqueMiddleChars.add(s.charAt(j));
                }
                count += uniqueMiddleChars.size();
            }
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int indexes[26][2];
        for (int i = 0; i < 26; i++) {
            indexes[i][0] = -1;
            indexes[i][1] = -1;
        }

        int k = 0;
        for (int i = 0; i < s.size(); i++) {
            k = s[i] - 'a';
            if (indexes[k][0] == -1) {
                indexes[k][0] = i;
                indexes[k][1] = i;
            } else {
                indexes[k][1] = i;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            int first = indexes[i][0];
            int last = indexes[i][1];

            if (first != -1 && first != last) {
                unordered_set<char> uniqueMiddleChars;
                for (int j = first + 1; j < last; j++) {
                    uniqueMiddleChars.insert(s[j]);
                }
                count += uniqueMiddleChars.size();
            }
        }

        return count;
    }
};
```
