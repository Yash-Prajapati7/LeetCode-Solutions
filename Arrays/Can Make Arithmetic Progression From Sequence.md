Leetcode Question : [Can Make Arithmetic Progression From Sequence](https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/)
## Method - 1 (Only works if the array does not contain duplicates)
Time Complexity - O(n)<br>
Space Complexity - O(n)
### Java
```java
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if((max - min) % (n - 1) != 0) {
            return false;
        }
        int commonDiff = (max - min) / (n - 1);     

        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < n; i++) {
            hs.add(min + i * commonDiff);
        }

        for(int num : arr) {
            if(!hs.contains(num)) {
                return false;
            }
        }

        return true;

    }
}
```
## Method - 2 (Use Sorting)
### Java
```java
import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++) {
            if(arr[i + 1] - arr[i] != arr[i + 2] - arr[i + 1]) {
                return false;
            }
        } 
        return true;
    }
}
```

### C++
```cpp
#include <algorithm>

class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        for (int i = 0; i < arr.size() - 2; ++i) {
            if (arr[i + 1] - arr[i] != arr[i + 2] - arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
};
```
