Leetcode Question : [Minimum Number of Flips to Make the Binary String Alternating](https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/)

### Java

```java
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;

        int alt1 = 0; // pattern starting with 0 -> 0101...
        int alt2 = 0; // pattern starting with 1 -> 1010...

        int left = 0;
        int ans = Integer.MAX_VALUE;

        int temp = 0;

        for (int right = 0; right < (n << 1); right++) {
            char expected1 = (right % 2 == 0) ? '0' : '1';
            char expected2 = (right % 2 == 0) ? '1' : '0';

            if (t.charAt(right) != expected1) alt1++;
            if (t.charAt(right) != expected2) alt2++;

            if ((right - left + 1) > n) {
                char leftExpected1 = (left % 2 == 0) ? '0' : '1';
                char leftExpected2 = (left % 2 == 0) ? '1' : '0';

                if (t.charAt(left) != leftExpected1) alt1--;
                if (t.charAt(left) != leftExpected2) alt2--;

                left++;
            }

            if ((right - left + 1) == n) {
                temp = (alt1 < alt2) ? alt1 : alt2;
                ans = (ans < temp) ? ans : temp;
            }
        }

        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minFlips(string s) {
        int n = s.length();
        string t = s + s;

        int alt1 = 0;
        int alt2 = 0;

        int left = 0;
        int ans = INT_MAX;

        int temp = 0;

        for (int right = 0; right < (n << 1); right++) {
            char expected1 = (right % 2 == 0) ? '0' : '1';
            char expected2 = (right % 2 == 0) ? '1' : '0';

            if (t[right] != expected1) alt1++;
            if (t[right] != expected2) alt2++;

            if ((right - left + 1) > n) {
                char leftExpected1 = (left % 2 == 0) ? '0' : '1';
                char leftExpected2 = (left % 2 == 0) ? '1' : '0';

                if (t[left] != leftExpected1) alt1--;
                if (t[left] != leftExpected2) alt2--;

                left++;
            }

            if ((right - left + 1) == n) {
                temp = (alt1 < alt2) ? alt1 : alt2;
                ans = (ans < temp) ? ans : temp;
            }
        }

        return ans;
    }
};
```
