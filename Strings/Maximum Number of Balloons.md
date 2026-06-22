Leetcode Question : [Maximum Number of Balloons](https://leetcode.com/problems/maximum-number-of-balloons)

### Java

```java
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i) - 'a']++;
        }

        return Math.min(
                Math.min(freq['b' - 'a'], freq['a' - 'a']),
                Math.min(
                    freq['l' - 'a'] >> 1,
                    Math.min(freq['o' - 'a'] >> 1, freq['n' - 'a'])
                )
        );
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxNumberOfBalloons(string text) {
        int freq[26] = {0};

        for (char ch : text) {
            freq[ch - 'a']++;
        }

        return min(
            min(freq['b' - 'a'], freq['a' - 'a']),
            min(
                freq['l' - 'a'] >> 1,
                min(freq['o' - 'a'] >> 1, freq['n' - 'a'])
            )
        );
    }
};
```
