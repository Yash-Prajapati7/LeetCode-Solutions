Leetcode Question : https://leetcode.com/problems/valid-palindrome/

## Method - 1 (Using a helper function for easy understanding)<br>
Time complexity : O(n)<br>
Space complexity : O(n)
```cpp
#include <string>
#include <cctype>
using namespace std;

class Solution {
public:
    string eliminator(string s) {
        string str;
        for (char c : s) {
            if (isalnum(c)) {
                if (isupper(c)) {
                    str += tolower(c); // Convert uppercase to lowercase
                } else {
                    str += c; // Keep lowercase letters as it is
                }
            }
        }
        return str;
    }

    bool isPalindrome(string s) {
        string str = eliminator(s);
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
};
```
## Method - 2 (Using two pointers)<br>
Time complexity : O(n)<br>
Space complexity : O(1)
```cpp
#include <string>
#include <cctype>
using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char c1 = tolower(s[left]);
            char c2 = tolower(s[right]);
            
            if (!isalnum(c1)) {
                left++;
            } else if (!isalnum(c2)) {
                right--;
            } else {
                if (c1 != c2) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
};
```
