Leetcode Question : [Compare Version Numbers](https://leetcode.com/problems/compare-version-numbers)

### Java

```java
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int val1 = 0, val2 = 0;

        int i = 0;
        while (i < v1.length || i < v2.length) {
            val1 = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            val2 = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            }
            i++;
        }

        return 0;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int compareVersion(string version1, string version2) {
        vector<string> v1, v2;
        stringstream ss1(version1), ss2(version2);
        string token;

        while (getline(ss1, token, '.')) v1.push_back(token);
        while (getline(ss2, token, '.')) v2.push_back(token);

        int i = 0, n = v1.size(), m = v2.size();
        while (i < n || i < m) {
            int val1 = (i < n) ? stoi(v1[i]) : 0;
            int val2 = (i < m) ? stoi(v2[i]) : 0;
            if (val1 < val2) return -1;
            else if (val1 > val2) return 1;
            i++;
        }
        return 0;
    }
};
```
