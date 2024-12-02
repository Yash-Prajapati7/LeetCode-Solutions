Leetcode Question : [Check If a Word Occurs as a Prefix of Any Word in a Sentence](https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/)

### Java
```java
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i = 0, j = 0;
        int word = 1;
        int l1 = sentence.length(), l2 = searchWord.length();

        while (i < l1) {
            while (i < l1 && sentence.charAt(i) != searchWord.charAt(0)) {
                if (sentence.charAt(i) == ' ')
                    word++;
                i++;
            }

            if (i == l1) {
                return -1;
            }

            if(i - 1 == -1 || sentence.charAt(i - 1) == ' ') {
                while(i < l1 && j < l2 && sentence.charAt(i) == searchWord.charAt(j)) {
                    i++;
                    j++;
                }
            }

            if(j == l2) {
                return word;
            }

            while(i < l1 && sentence.charAt(i++) != ' ');
            word++;

            j = 0;
        }
        
        return -1;
    }
}
```

### C++
```cpp
class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        int i = 0, j = 0;
        int word = 1;
        int l1 = sentence.length(), l2 = searchWord.length();

        while (i < l1) {
            while (i < l1 && sentence[i] != searchWord[0]) {
                if (sentence[i] == ' ')
                    word++;
                i++;
            }

            if (i == l1) {
                return -1;
            }

            if(i - 1 == -1 || sentence[i - 1] == ' ') {
                while(i < l1 && j < l2 && sentence[i] == searchWord[j]) {
                    i++;
                    j++;
                }
            }

            if(j == l2) {
                return word;
            }

            while(i < l1 && sentence[i++] != ' ');
            word++;

            j = 0;
        }
        
        return -1;
    }
};
```
