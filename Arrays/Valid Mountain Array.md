Leetcode Question : [Valid Mountain Array](https://leetcode.com/problems/valid-mountain-array/)

### Java

```java
class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, i = 0, j = n - 1;
        while(i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        while(j > 0 && arr[j - 1] > arr[j]) {
            j--;
        }

        return j > 0 && i == j && j < n - 1;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool validMountainArray(vector<int>& arr) {
        int n = arr.size(), i = 0, j = n - 1;
        while(i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        while(j > 0 && arr[j - 1] > arr[j]) {
            j--;
        }

        return j > 0 && i == j && j < n - 1;
    }
};
```
