Leetcode Question : [Range Sum of Sorted Subarray Sum](https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/description/)
### Java
```java
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1000000007;
        int newSize = (n * (n + 1)) / 2;
        int[] newArray = new int[newSize];
        int k = 0;
        int sum;

        for(int i = 0; i < n; i++) {
            sum = 0;
            for(int j = i; j < n; j++, k++) {
                sum = (sum + nums[j]) % mod;
                newArray[k] = sum;
            }
        }

        Arrays.sort(newArray);
        --left; // Converting to 0-indexed pointer
        sum = 0;
        for(int i = left; i < right; i++) {
            sum = (sum + newArray[i]) % mod;
        }

        return sum;
    }
}
```
### C++
```cpp
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int rangeSum(vector<int>& nums, int n, int left, int right) {
        int mod = 1000000007;
        int newSize = (n * (n + 1)) / 2;
        vector<int> newArray(newSize);
        int k = 0;
        int sum;

        for(int i = 0; i < n; i++) {
            sum = 0;
            for(int j = i; j < n; j++, k++) {
                sum = (sum + nums[j]) % mod;
                newArray[k] = sum;
            }
        }

        sort(newArray.begin(), newArray.end());
        --left; // Converting to 0-indexed pointer
        sum = 0;
        for(int i = left; i < right; i++) {
            sum = (sum + newArray[i]) % mod;
        }

        return sum;
    }
};
```
