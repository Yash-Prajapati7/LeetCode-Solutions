### Leetcode Question: [Make Two Arrays Equal by Reversing Subarrays](https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/)

### Java
```java
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != target[i]) {
                return false;
            }
        }
        return true;
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
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        sort(target.begin(), target.end());
        sort(arr.begin(), arr.end());
        for(int i = 0; i < arr.size(); i++) {
            if(arr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
};
```
