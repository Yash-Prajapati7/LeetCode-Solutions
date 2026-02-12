Leetcode Question : [Longest Balanced Substring I](https://leetcode.com/problems/longest-balanced-substring-i/)

### Java

```java
class Solution {
    public int longestBalanced(String s) {
        int[] freq = new int[26];
        int n = s.length();
        int max = 0, current = 0;

        for(int i = 0; i < n; i++) {
            Arrays.fill(freq, 0);
            for(int j = i; j < n; j++) {
                boolean flag = true;
                int idx = s.charAt(j) - 'a';
                freq[idx]++;

                for(int k = 0; k < 26; k++) {
                    if(freq[k] > 0 && freq[k] != freq[idx]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    current = j - i + 1;
                    max = (max < current) ? current : max;
                }
            }
        }

        return max;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestBalanced(string s) {
        int freq[26];
        int n = s.length();
        int maxVal = 0, current = 0;

        for(int i = 0; i < n; i++) {
            memset(freq, 0, sizeof(freq));
            for(int j = i; j < n; j++) {
                bool flag = true;
                int idx = s[j] - 'a';
                freq[idx]++;

                for(int k = 0; k < 26; k++) {
                    if(freq[k] > 0 && freq[k] != freq[idx]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    current = j - i + 1;
                    maxVal = (maxVal < current) ? current : maxVal;
                }
            }
        }

        return maxVal;
    }
};
```
