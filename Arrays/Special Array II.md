LeetCode Question: [Special Array II](https://leetcode.com/problems/special-array-ii/)

### Java
```java
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean[] result = new boolean[m];
        int[] pref = new int[n];
        pref[0] = 0;

        for(int i = 1; i < n; i++) {
            if((nums[i] + nums[i - 1]) % 2 == 0) {
                pref[i] = pref[i - 1] + 1;
            }
            else {
                pref[i] = pref[i - 1];
            }
        }

        for(int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = (pref[end] == pref[start]);
        }

        return result;
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<bool> isArraySpecial(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        int m = queries.size();
        vector<bool> result(m);
        vector<int> pref(n);
        pref[0] = 0;

        for(int i = 1; i < n; i++) {
            if((nums[i] + nums[i - 1]) % 2 == 0) {
                pref[i] = pref[i - 1] + 1;
            } else {
                pref[i] = pref[i - 1];
            }
        }

        for(int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = (pref[end] == pref[start]);
        }

        return result;
    }
};
```
