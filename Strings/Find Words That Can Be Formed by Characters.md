LeetCode Question: [Find Words That Can Be Formed by Characters](https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/)

### Java
```java
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charFreq = new int[26];
        for (char c : chars.toCharArray()) {
            charFreq[c - 'a']++;
        }

        int finalLength = 0;

        for (String word : words) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }

            boolean canForm = true;
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] > charFreq[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                finalLength += word.length();
            }
        }

        return finalLength;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        int charFreq[26] = {0};
        for (char c : chars) {
            charFreq[c - 'a']++;
        }

        int finalLength = 0;

        for (const string& word : words) {
            int wordFreq[26] = {0};
            for (char c : word) {
                wordFreq[c - 'a']++;
            }

            bool canForm = true;
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] > charFreq[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                finalLength += word.length();
            }
        }

        return finalLength;
    }
};
```
