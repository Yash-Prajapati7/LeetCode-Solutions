Leetcode Question : [Find the Length of the Longest Common Prefix](https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/)

### Java

```java
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> pref1 = new HashSet<>(arr1.length);

        for(int val : arr1) {
            while(!pref1.contains(val) && val > 0) {
                pref1.add(val);
                val /= 10;
            }
        }

        int ans = 0, len = 0;

        for(int val : arr2) {
            while(!pref1.contains(val) && val > 0) {
                val /= 10;
            }

            if(val > 0) {
                len = (int) Math.log10(val) + 1;
                ans = ans < len ? len : ans;
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
    int longestCommonPrefix(vector<int>& arr1, vector<int>& arr2) {
        unordered_set<int> pref1;

        for(int val : arr1) {
            while(!pref1.count(val) && val > 0) {
                pref1.insert(val);
                val /= 10;
            }
        }

        int ans = 0, len = 0;

        for(int val : arr2) {
            while(!pref1.count(val) && val > 0) {
                val /= 10;
            }

            if(val > 0) {
                len = (int)log10(val) + 1;
                ans = ans < len ? len : ans;
            }
        }

        return ans;
    }
};
```
