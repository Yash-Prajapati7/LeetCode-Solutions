Leetcode Question : [Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)


### Java

```java
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, mid = 0;
        int ans = -1;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(letters[mid] <= target) {
                left = mid + 1;
            }
            else {
                ans = mid;
                right = mid - 1;                
            }
        }

        return ans == -1 ? letters[0] : letters[ans];
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        int left = 0, right = letters.size() - 1, mid = 0;
        int ans = -1;

        while(left <= right) {
            mid = (left + right) >> 1;
            if(letters[mid] <= target) {
                left = mid + 1;
            }
            else {
                ans = mid;
                right = mid - 1;                
            }
        }

        return ans == -1 ? letters[0] : letters[ans];
    }
};
```
