
### Leetcode Question: [Shortest Subarray to be Removed to Make Array Sorted](https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/)

### Java
```java
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int right = arr.length - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        int min = right;
        int left = 0;
        while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
            // find next valid number after arr[left]
            while (right < arr.length && arr[left] > arr[right]) {
                right++;
            }
            // save length of removed subarray
            min = Math.min(min, right - left - 1);
            left++;
        }
        return min;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findLengthOfShortestSubarray(vector<int>& arr) {
        int right = arr.size() - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        int minLength = right;
        int left = 0;
        while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
            // Find the next valid number after arr[left]
            while (right < arr.size() && arr[left] > arr[right]) {
                right++;
            }
            // Save the length of the removed subarray
            minLength = min(minLength, right - left - 1);
            left++;
        }
        return minLength;
    }
};
```
