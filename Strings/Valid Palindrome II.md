Leetcode Question : [Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

### Java

```java
class Solution {
    private static boolean isPalindrome(char[] chars, int left, int right) {
        while(left < right) {
            if(chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0, right = n - 1;

        while(left < right) {
            if(chars[left] != chars[right]) {
                return isPalindrome(chars, left + 1, right) || isPalindrome(chars, left, right - 1);
            }
            left++;
            right--;
        }

        return true;                
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    static bool isPalindrome(string s, int left, int right) {
        while(left < right) {
            if(s[left] != s[right]) return false;
            left++;
            right--;
        }
        return true;
    }

public:
    bool validPalindrome(string s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            if(s[left] != s[right]) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }
};

```
