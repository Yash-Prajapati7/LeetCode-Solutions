Leetcode Question : [Zero Array Transformation I](https://leetcode.com/problems/zero-array-transformation-i/)

### Method - 1 (Brute Force)

#### Java
```java
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        for(int query[] : queries) {
            int l = query[0];
            int r = query[1];

            for(int i = l; i <= r; i++) {
                if(nums[i] != 0) nums[i]--;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) return false;
        }

        return true;
    }
}
```

#### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        for(auto& query : queries) {
            int l = query[0];
            int r = query[1];

            for(int i = l; i <= r; i++) {
                if(nums[i] != 0) nums[i]--;
            }
        }

        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] != 0) return false;
        }

        return true;
    }
};
```

### Method - 2 (Line sweep)

#### Java
```java
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int l = 0, r = 0;
        int[] sweep = new int[n + 1];
        
        for(int[] query : queries) {
            l = query[0];
            r = query[1];

            sweep[l] += 1;
            sweep[r + 1] -= 1;
        }

        for(int i = 1; i <= n; i++) {
            sweep[i] += sweep[i - 1];
        }

        for(int i = 0; i < n; i++) {
            if(sweep[i] < nums[i]) return false;
        }

        return true;
    }
}
```

#### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        vector<int> sweep(n + 1, 0);

        for(auto& query : queries) {
            int l = query[0];
            int r = query[1];

            sweep[l] += 1;
            sweep[r + 1] -= 1;
        }

        for(int i = 1; i <= n; i++) {
            sweep[i] += sweep[i - 1];
        }

        for(int i = 0; i < n; i++) {
            if(sweep[i] < nums[i]) return false;
        }

        return true;
    }
};
```
