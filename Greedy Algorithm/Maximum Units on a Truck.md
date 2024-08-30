Leetcode Question: [Maximum Units on a Truck](https://leetcode.com/problems/maximum-units-on-a-truck/)

### Java
```java
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort the array using a custom comparator in descending order based on units per box
        Arrays.sort(boxTypes, (val1, val2) -> val2[1] - val1[1]);

        int total = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] <= truckSize) {
                total += (boxTypes[i][0] * boxTypes[i][1]); 
                truckSize -= boxTypes[i][0];       
            } else {
                total += truckSize * boxTypes[i][1];    
                break;                                    
            }
        }

        return total;
    }
}
```

### C++
```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        // Sort the array using a custom comparator in descending order based on units per box
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& val1, const vector<int>& val2) {
            return val2[1] < val1[1];
        });

        int total = 0;

        for (int i = 0; i < boxTypes.size(); i++) {
            if (boxTypes[i][0] <= truckSize) {
                total += (boxTypes[i][0] * boxTypes[i][1]); 
                truckSize -= boxTypes[i][0];       
            } else {
                total += truckSize * boxTypes[i][1];    
                break;                                    
            }
        }

        return total;
    }
};
```
