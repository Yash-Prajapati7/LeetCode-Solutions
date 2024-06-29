Leetcode Question : https://leetcode.com/problems/valid-palindrome/

## Method - 1 (Using a helper function for easy understanding)<br>
Time complexity : O(n)<br>
Space complexity : O(n)
```java
class Solution {
    public String eliminator(String s) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                if (c >= 'A' && c <= 'Z') {
                    str.append((char) (c + 32)); // Convert uppercase to lowercase
                } else {
                    str.append(c); // Keep lowercase letters as it is
                }
            }
            i++;
        }
        return str.toString();
    }

    public boolean isPalindrome(String s) {
        String str = eliminator(s);
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

```
## Method - 2 (Using two pointers)<br>
Time complexity : O(n)<br>
Space complexity : O(1)
```java
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            
            if (!Character.isLetterOrDigit(c1)) {
                left++;
            } else if (!Character.isLetterOrDigit(c2)) {
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
}

```
