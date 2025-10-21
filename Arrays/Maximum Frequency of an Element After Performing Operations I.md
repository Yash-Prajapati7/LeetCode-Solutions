Leetcode Question : [Maximum Frequency of an Element After Performing Operations I](https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/)

### Java

```java
class Solution {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        int ans = 0;
        Map<Integer, Integer> numCount = new HashMap<>();

        // count the max freq element
        int lastNumIndex = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[lastNumIndex]) {
                count = i - lastNumIndex;
                numCount.put(nums[lastNumIndex], count);
                ans = ans < count ? count : ans;
                lastNumIndex = i;
            }
        }

        count = nums.length - lastNumIndex;
        numCount.put(nums[lastNumIndex], count);
        ans = ans = ans < count ? count : ans;

        // consider each number in range (min, max) from nums as possible
        // target to convert nums[i] to target
        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            int l = leftBound(nums, i - k);
            int r = rightBound(nums, i + k);
            int tempAns;
            if (numCount.containsKey(i)) {
                tempAns = Math.min(r - l + 1, numCount.get(i) + numOperations);
            } else {
                tempAns = Math.min(r - l + 1, numOperations);
            }
            ans = ans = ans < tempAns ? tempAns : ans;
        }

        return ans;
    }

    private int leftBound(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int rightBound(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] > value) {
                right = mid - 1;
            } else {
                left = mid;
            }
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
    int maxFrequency(vector<int>& nums, int k, int numOperations) {
        sort(nums.begin(), nums.end());
        int ans = 0;
        unordered_map<int, int> numCount;

        int lastNumIndex = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] != nums[lastNumIndex]) {
                count = i - lastNumIndex;
                numCount[nums[lastNumIndex]] = count;
                ans = ans < count ? count : ans;
                lastNumIndex = i;
            }
        }

        count = nums.size() - lastNumIndex;
        numCount[nums[lastNumIndex]] = count;
        ans = ans < count ? count : ans;

        for (int i = nums[0]; i <= nums.back(); i++) {
            int l = leftBound(nums, i - k);
            int r = rightBound(nums, i + k);
            int tempAns;
            if (numCount.find(i) != numCount.end()) {
                tempAns = min(r - l + 1, numCount[i] + numOperations);
            } else {
                tempAns = min(r - l + 1, numOperations);
            }
            ans = ans < tempAns ? tempAns : ans;
        }

        return ans;
    }

private:
    int leftBound(vector<int>& nums, int value) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < value)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    int rightBound(vector<int>& nums, int value) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] > value)
                right = mid - 1;
            else
                left = mid;
        }
        return left;
    }
};
```
