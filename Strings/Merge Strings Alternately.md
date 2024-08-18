Leetcode Question: [Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/)

### Java
```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0, k = 0;
        int m = word1.length();
        int n = word2.length();
        StringBuilder sb = new StringBuilder();
        while(i < m && j < n) {
            if(k % 2 == 0) {
                sb.append(word1.charAt(i++));
            }
            else {
                sb.append(word2.charAt(j++));
            }
            k++;
        }

        if(i < m) {
            sb.append(word1.substring(i, m));
        }
        else {
            sb.append(word2.substring(j, n));
        }

        return sb.toString();
    }
}
```

### C++
```cpp
class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int i = 0, j = 0, k = 0;
        int m = word1.length();
        int n = word2.length();
        string result;
        
        while(i < m && j < n) {
            if(k % 2 == 0) {
                result.push_back(word1[i++]);
            }
            else {
                result.push_back(word2[j++]);
            }
            k++;
        }
        
        if(i < m) {
            result.append(word1.substr(i, m - i));
        }
        else {
            result.append(word2.substr(j, n - j));
        }
        
        return result;
    }
};
```
