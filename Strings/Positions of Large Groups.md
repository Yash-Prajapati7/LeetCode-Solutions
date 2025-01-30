Leetcode Question : [Positions of Large Groups](https://leetcode.com/problems/positions-of-large-groups/)  

### Java  
```java
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length();
        if(n < 3) return ans;
        int start = 0, end = 0;

        for(int i = 0; i < n; i = end) {
            start = i;
            end = i + 1;

            while(end < n && s.charAt(end) == s.charAt(start)) {
                end++;
            }

            if(end - start > 2) {
                ans.add(Arrays.asList(start, end - 1));
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
    vector<vector<int>> largeGroupPositions(string s) {
        vector<vector<int>> ans;
        int n = s.length();
        if(n < 3) return ans;
        int start = 0, end = 0;

        for(int i = 0; i < n; i = end) {
            start = i;
            end = i + 1;

            while(end < n && s[end] == s[start]) {
                end++;
            }

            if(end - start > 2) {
                ans.push_back({start, end - 1});
            }
        }

        return ans;
    }
};
```
