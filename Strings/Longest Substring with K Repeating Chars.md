Leetcode Question : [Longest SUbstring with atleast K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/)
### Java
```java
class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstring(s, k, 0, s.length());
    }

    private int longestSubstring(String s, int k, int start, int end) {
        if (end - start < k) return 0;

        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                while (j < end && count[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                return Math.max(longestSubstring(s, k, start, i), longestSubstring(s, k, j, end));
            }
        }

        return end - start;
    }
}
```
### C++
```cpp
class Solution {
public:
    int longestSubstring(string s, int k) {
        return longestSubstring(s, k, 0, s.length());
    }

private:
    int longestSubstring(const string& s, int k, int start, int end) {
        if (end - start < k) return 0;

        vector<int> count(26, 0);
        for (int i = start; i < end; i++) {
            count[s[i] - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (count[s[i] - 'a'] < k) {
                int j = i + 1;
                while (j < end && count[s[j] - 'a'] < k) {
                    j++;
                }
                return max(longestSubstring(s, k, start, i), longestSubstring(s, k, j, end));
            }
        }

        return end - start;
    }
};
```
