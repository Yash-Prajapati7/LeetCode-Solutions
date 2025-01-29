Leetcode Question : [Largest Substring Between Two Equal Characters](https://leetcode.com/problems/largest-substring-between-two-equal-characters/)

### Java
```java
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        if(n == 1) return -1;
        int[][] locations = new int[26][2];

        for(int i = 0; i < 26; i++) {
            locations[i][0] = -1; // Start index of a particular alphabet
            locations[i][1] = -1;
        }

        int ind = 0, start = 0, end = 0;
        for(int i = 0; i < n; i++) {
            ind = s.charAt(i) - 'a';

            if(locations[ind][0] == -1) {
                locations[ind][0] = i;
            }
            else {
                locations[ind][1] = i;
            }
        }

        int max = -1, current = 0;
        for(int i = 0; i < 26; i++) {
            if(locations[i][1] != -1) {
                current = locations[i][1] - locations[i][0] - 1;
                max = max < current ? current : max;
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
    int maxLengthBetweenEqualCharacters(string s) {
        int n = s.length();
        if(n == 1) return -1;
        vector<vector<int>> locations(26, vector<int>(2, -1));

        for(int i = 0; i < 26; i++) {
            locations[i][0] = -1; // Start index of a particular alphabet
            locations[i][1] = -1;
        }

        int ind = 0, start = 0, end = 0;
        for(int i = 0; i < n; i++) {
            ind = s[i] - 'a';

            if(locations[ind][0] == -1) {
                locations[ind][0] = i;
            }
            else {
                locations[ind][1] = i;
            }
        }

        int maxVal = -1, current = 0;
        for(int i = 0; i < 26; i++) {
            if(locations[i][1] != -1) {
                current = locations[i][1] - locations[i][0] - 1;
                maxVal = max(maxVal, current);
            }
        }

        return maxVal; 
    }
};
```
