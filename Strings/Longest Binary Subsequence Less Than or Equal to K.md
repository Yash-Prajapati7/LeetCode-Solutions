Leetcode Question : [Longest Binary Subsequence Less Than or Equal to K](https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/)

### Java

```java
class Solution {
    public int longestSubsequence(String s, int k) {
        int current = 0;
        int length = 0;
        int bits = (int)(Math.log(k) / Math.log(2)) + 1;    // no. of bits in k
        int n = s.length();

        for(int i = 0; i < n; i++) {
            if(s.charAt(n - 1 - i) == '1') {
                if(i < bits && current + (1 << i) <= k) {
                    current += (1 << i);
                    length++;
                }
            }
            else {
                length++;
            }
        }

        return length;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestSubsequence(string s, int k) {
        int current = 0;
        int length = 0;
        int bits = (int)(log(k) / log(2)) + 1; // no. of bits in k
        int n = s.length();

        for(int i = 0; i < n; i++) {
            if(s[n - 1 - i] == '1') {
                if(i < bits && current + (1 << i) <= k) {
                    current += (1 << i);
                    length++;
                }
            }
            else {
                length++;
            }
        }

        return length;
    }
};
```
