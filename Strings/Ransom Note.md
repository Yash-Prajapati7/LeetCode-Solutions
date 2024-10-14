Leetcode Question: [Ransom Note](https://leetcode.com/problems/ransom-note/)

### Java
```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            int c = magazine.charAt(i) - 'a';
            freq[c]++;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            int c = ransomNote.charAt(i) - 'a';
            if(freq[c] == 0) {
                return false;
            }
            freq[c]--;
        }
        return true;
    }
}
```

### C++
```cpp
class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int freq[26] = {0};
        for(int i = 0; i < magazine.length(); i++) {
            int c = magazine[i] - 'a';
            freq[c]++;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            int c = ransomNote[i] - 'a';
            if(freq[c] == 0) {
                return false;
            }
            freq[c]--;
        }
        return true;
    }
};
```
