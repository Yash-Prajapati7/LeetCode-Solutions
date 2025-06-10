Leetcode Question : [Maximum Difference Between Even and Odd Frequency I](https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/)

### Java

```java
class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int odd = -1, even = Integer.MAX_VALUE;
        // The difference will be maximum only if we take maximum out of odd freq's and minimum out of even freq's
        for(int f : freq) {
            if((f & 1) == 1) {
                if(f > odd) {
                    odd = f;
                }
            }
            else {
                if(f != 0 && f < even) {
                    even = f;
                }
            }
        }

        return odd - even;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxDifference(string s) {
        int freq[26] = {0};
        for(int i = 0; i < s.length(); i++) {
            freq[s[i] - 'a']++;
        }

        int odd = -1, even = INT_MAX;
        for(int f : freq) {
            if((f & 1) == 1) {
                if(f > odd) {
                    odd = f;
                }
            } else {
                if(f != 0 && f < even) {
                    even = f;
                }
            }
        }

        return odd - even;
    }
};
```
