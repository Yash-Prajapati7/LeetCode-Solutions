Leetcode Question : [Maximum Candies Allocated to K Children](https://leetcode.com/problems/maximum-candies-allocated-to-k-children/)

### Java
```java
class Solution {
    public int maximumCandies(int[] candies, long k) {
        long maxChildren = 0, total = 0;
        int left = 0, right = Integer.MIN_VALUE, mid = 0;
        int n = candies.length;

        for(int candy : candies) {
            total += candy;
            right = right < candy ? candy : right;
        }

        if(k > total) return 0;
        
        while(left < right) {
            mid = left + ((right - left + 1) >> 1);
            maxChildren = 0;
            for(int candy : candies) maxChildren += (candy / mid);

            if(maxChildren >= k) left = mid;
            else right = mid - 1;
        }

        return left;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximumCandies(vector<int>& candies, long long k) {
        long long maxChildren = 0, total = 0;
        int left = 0, right = INT_MIN, mid = 0;
        int n = candies.size();

        for(int candy : candies) {
            total += candy;
            right = max(right, candy);
        }

        if(k > total) return 0;
        
        while(left < right) {
            mid = left + ((right - left + 1) >> 1);
            maxChildren = 0;
            for(int candy : candies) maxChildren += (candy / mid);

            if(maxChildren >= k) left = mid;
            else right = mid - 1;
        }

        return left;
    }
};
```
