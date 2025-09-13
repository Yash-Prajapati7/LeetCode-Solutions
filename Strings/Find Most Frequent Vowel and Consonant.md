Leetcode Question : [Find Most Frequent Vowel and Consonant](https://leetcode.com/problems/find-most-frequent-vowel-and-consonant)

### Java

```java
class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int vowelCount = 0, consonantCount = 0;
        for(int i = 0; i < 26; i++) {
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                vowelCount = vowelCount < freq[i] ? freq[i] : vowelCount;                
            }
            else {
                consonantCount = consonantCount < freq[i] ? freq[i] : consonantCount;
            }
        }

        return vowelCount + consonantCount;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxFreqSum(string s) {
        int freq[26] = {0};
        for(int i = 0; i < s.size(); i++) {
            freq[s[i] - 'a']++;
        }

        int vowelCount = 0, consonantCount = 0;
        for(int i = 0; i < 26; i++) {
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                vowelCount = vowelCount < freq[i] ? freq[i] : vowelCount;                
            }
            else {
                consonantCount = consonantCount < freq[i] ? freq[i] : consonantCount;
            }
        }

        return vowelCount + consonantCount;
    }
};
```
