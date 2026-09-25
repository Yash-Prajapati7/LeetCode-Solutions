### Leetcode Question : [Reformat The String](https://leetcode.com/problems/reformat-the-string/)

### Java

```java
class Solution {
    public String reformat(String s) {
        int n = s.length();
        int digitCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) <= '9') {
                digitCount++;
            }
        }

        int charCount = n - digitCount;

        if (Math.abs(digitCount - charCount) > 1) {
            return "";
        }

        // If digits are more, digit goes first.
        boolean digitFirst = digitCount > charCount;

        int digitPointer = 0;
        int charPointer = 0;

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            boolean placeDigit = (i % 2 == 0) == digitFirst;

            if (placeDigit) {
                while (digitPointer < n && !Character.isDigit(s.charAt(digitPointer))) {
                    digitPointer++;
                }
                sb.append(s.charAt(digitPointer++));
            } else {
                while (charPointer < n && !Character.isLetter(s.charAt(charPointer))) {
                    charPointer++;
                }
                sb.append(s.charAt(charPointer++));
            }
        }

        return sb.toString();
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    string reformat(string s) {
        int n = s.length();
        int digitCount = 0;

        for (int i = 0; i < n; i++) {
            if (s[i] <= '9') {
                digitCount++;
            }
        }

        int charCount = n - digitCount;

        if (abs(digitCount - charCount) > 1) {
            return "";
        }

        // If digits are more, digit goes first.
        bool digitFirst = digitCount > charCount;

        int digitPointer = 0;
        int charPointer = 0;

        string result;
        result.reserve(n);

        for (int i = 0; i < n; i++) {
            bool placeDigit = (i % 2 == 0) == digitFirst;

            if (placeDigit) {
                while (digitPointer < n && !isdigit(s[digitPointer])) {
                    digitPointer++;
                }
                result += s[digitPointer++];
            } else {
                while (charPointer < n && !isalpha(s[charPointer])) {
                    charPointer++;
                }
                result += s[charPointer++];
            }
        }

        return result;
    }
};
```
