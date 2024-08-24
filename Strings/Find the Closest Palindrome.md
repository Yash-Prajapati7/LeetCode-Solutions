Leetcode Question : [Find the Closest Palindrome](https://leetcode.com/problems/find-the-closest-palindrome/)

### Java
```java
import java.math.BigInteger;

class Solution {
    private long convertToPalindrome(long num) {
        String n = Long.toString(num);
        StringBuilder sb = new StringBuilder(n);
        int length = sb.length();

        for (int i = 0; i < length / 2; i++) {
            sb.setCharAt(length - i - 1, sb.charAt(i));
        }

        String palindromeStr = sb.toString();
        return Long.parseLong(palindromeStr);
    }

    private long prevPalindrome(long num) {
        long left = 0, right = num - 1;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long palindrome = convertToPalindrome(mid);
            if (palindrome < num) {
                ans = palindrome;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private long nextPalindrome(long num) {
        long left = num + 1, right = Long.MAX_VALUE;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long palindrome = convertToPalindrome(mid);
            if (palindrome > num) {
                ans = palindrome;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public String nearestPalindromic(String n) {
        long num = new BigInteger(n).longValue();
        long prev = prevPalindrome(num);
        long next = nextPalindrome(num);

        if (num - prev <= next - num) {
            return Long.toString(prev);
        } else {
            return Long.toString(next);
        }
    }
}
```

### C++
```cpp
#include <string>
#include <climits>

class Solution {
private:
    long convertToPalindrome(long num) {
        std::string n = std::to_string(num);
        int length = n.length();
        for (int i = 0; i < length / 2; i++) {
            n[length - i - 1] = n[i];
        }
        return std::stol(n);
    }

    long prevPalindrome(long num) {
        long left = 0, right = num - 1;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long palindrome = convertToPalindrome(mid);
            if (palindrome < num) {
                ans = palindrome;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    long nextPalindrome(long num) {
        long left = num + 1, right = LLONG_MAX;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long palindrome = convertToPalindrome(mid);
            if (palindrome > num) {
                ans = palindrome;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

public:
    std::string nearestPalindromic(std::string n) {
        long num = std::stol(n);
        long prev = prevPalindrome(num);
        long next = nextPalindrome(num);

        if (num - prev <= next - num) {
            return std::to_string(prev);
        } else {
            return std::to_string(next);
        }
    }
};
```
