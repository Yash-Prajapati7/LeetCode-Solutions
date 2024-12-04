Leetcode Question: [Make String a Subsequence Using Cyclic Increments](https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/)

### Java
```java
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        
        // If str1 is shorter than str2, it's impossible to make str2 a subsequence
        if (n1 < n2) {
            return false;
        }
        
        int j = 0; // Pointer for str2
        
        for (int i = 0; i < n1 && j < n2; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            
            // Check if characters match or can match via cyclic increment
            if (c1 == c2 || (c1 + 1 - 'a') % 26 + 'a' == c2) {
                j++; // Move to next character in str2
            }
        }
        
        // If we were able to traverse all characters in str2, return true
        return j == n2;
    }
}
```

### C++
```cpp
class Solution {
public:
    bool canMakeSubsequence(string str1, string str2) {
        int n1 = str1.length(), n2 = str2.length();
        
        // If str1 is shorter than str2, it's impossible to make str2 a subsequence
        if (n1 < n2) {
            return false;
        }
        
        int j = 0; // Pointer for str2
        
        for (int i = 0; i < n1 && j < n2; i++) {
            char c1 = str1[i];
            char c2 = str2[j];
            
            // Check if characters match or can match via cyclic increment
            if (c1 == c2 || (c1 + 1 - 'a') % 26 + 'a' == c2) {
                j++; // Move to next character in str2
            }
        }
        
        // If we were able to traverse all characters in str2, return true
        return j == n2;
    }
};
```
