Leetcode Question : [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)

### Java
```java
class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] freq = new int[26];
        char[] ch = s.toCharArray(); 

        for(int i = 0; i < n; i++) {
            freq[ch[i] - 'a']++;           
        }

        for(int i = 0; i < n; i++) {
            if(freq[ch[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
```

### C++
```cpp
class Solution {
public:
    int firstUniqChar(string s) {
        int n = s.length();
        int freq[26] = {0};
        vector<char> ch(s.begin(), s.end());

        for(int i = 0; i < n; i++) {
            freq[ch[i] - 'a']++;
        }

        for(int i = 0; i < n; i++) {
            if(freq[ch[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
};
```
