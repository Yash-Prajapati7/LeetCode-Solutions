Leetcode Question : [Rearrange Characters to Make Target String](https://leetcode.com/problems/rearrange-characters-to-make-target-string/)

### Java
```java
class Solution {
    public int rearrangeCharacters(String s, String target) {
        if(s.length() < target.length()) return 0;
        int[] targetFreq = new int[26];
        int[] stringFreq = new int[26];
        int count = 0;

        for(int i = 0; i < target.length(); i++) {
            targetFreq[target.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            stringFreq[s.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(targetFreq[i] != 0) {
                count = stringFreq[i] / targetFreq[i];
                min = min > count ? count : min;
            }
        }

        return min;
    }
}
```

### C++
```cpp
class Solution {
public:
    int rearrangeCharacters(string s, string target) {
        if (s.length() < target.length()) return 0;
        vector<int> targetFreq(26, 0);
        vector<int> stringFreq(26, 0);
        int count = 0;

        for (char c : target) {
            targetFreq[c - 'a']++;
        }
        for (char c : s) {
            stringFreq[c - 'a']++;
        }

        int min = INT_MAX;
        for (int i = 0; i < 26; i++) {
            if (targetFreq[i] != 0) {
                count = stringFreq[i] / targetFreq[i];
                min = min > count ? count : min;
            }
        }

        return min;
    }
};
```
