Leetcode Question : [Total Characters in String After Transformations I](https://leetcode.com/problems/total-characters-in-string-after-transformations-i/)

### Java

```java
class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1_000_000_007;
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int lastFreq = 0;
        while(t-- > 0) {
            lastFreq = freq[25];
            for(int i = 25; i >= 1; i--) {
                freq[i] = freq[i - 1];
            }
            freq[0] = lastFreq;
            freq[1] = (freq[1] + lastFreq) % mod;
        }

        int len = 0;
        for(int i = 0; i < 26; i++) {
            len = (len + freq[i]) % mod;
        }

        return len;        
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lengthAfterTransformations(string s, int t) {
        int mod = 1'000'000'007;
        int freq[26] = {0};
        for(int i = 0; i < s.length(); i++) {
            freq[s[i] - 'a']++;
        }

        int lastFreq = 0;
        while(t-- > 0) {
            lastFreq = freq[25];
            for(int i = 25; i >= 1; i--) {
                freq[i] = freq[i - 1];
            }
            freq[0] = lastFreq;
            freq[1] = (freq[1] + lastFreq) % mod;
        }

        int len = 0;
        for(int i = 0; i < 26; i++) {
            len = (len + freq[i]) % mod;
        }

        return len;
    }
};
```
