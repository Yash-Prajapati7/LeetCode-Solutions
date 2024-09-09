Leetcode Question: [Element Appearing More Than 25% in Sorted Array](https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/)

### Java
```java
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (count > n / 4) {
                    return arr[i];
                }
            } else {
                count = 1; // Reset count if a new number appears
            }
        }
        return arr[0];
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        int n = arr.size();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (count > n / 4) {
                    return arr[i];
                }
            } else {
                count = 1; // Reset count if a new number appears
            }
        }
        return arr[0];
    }
};
```
