Leetcode Question : [Decode the Slanted Ciphertext](https://leetcode.com/problems/decode-the-slanted-ciphertext/)

### Java

```java
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) {
            return encodedText;
        }

        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder result = new StringBuilder(n);

        for (int c = 0; c < cols; c++) {
            int r = 0, j = c;
            while (r < rows && j < cols) {
                result.append(encodedText.charAt(r * cols + j));
                r++;
                j++;
            }
        }

        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        if (rows == 1) {
            return encodedText;
        }

        int n = encodedText.length();
        int cols = n / rows;

        string result;
        result.reserve(n);

        for (int c = 0; c < cols; c++) {
            int r = 0, j = c;
            while (r < rows && j < cols) {
                result.push_back(encodedText[r * cols + j]);
                r++;
                j++;
            }
        }

        int end = result.length() - 1;
        while (end >= 0 && result[end] == ' ') {
            end--;
        }

        return result.substr(0, end + 1);
    }
};
```
