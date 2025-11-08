Leetcode Question : [Partition Array Into Three Parts With Equal Sum](https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/)

### Java

```java
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;
        
        if (totalSum % 3 != 0) return false;
        
        int target = totalSum / 3;
        int currentSum = 0;
        int partsFound = 0;
        
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            
            if (currentSum == target) {
                partsFound++;
                currentSum = 0;
            }
            
            // If we found 2 parts and still have elements left, return true
            if (partsFound == 2 && i < arr.length - 1) {
                return true;
            }
        }
        
        return false;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        int totalSum = accumulate(arr.begin(), arr.end(), 0);
        
        if (totalSum % 3 != 0) return false;
        
        int target = totalSum / 3;
        int currentSum = 0;
        int partsFound = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            currentSum += arr[i];
            
            if (currentSum == target) {
                partsFound++;
                currentSum = 0;
            }
            
            // If we found 2 parts and still have elements left, return true
            if (partsFound == 2 && i < arr.size() - 1) {
                return true;
            }
        }
        
        return false;
    }
};
```
