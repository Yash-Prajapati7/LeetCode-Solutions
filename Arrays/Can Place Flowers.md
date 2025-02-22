Leetcode Question : [Can Place Flowers](https://leetcode.com/problems/can-place-flowers/)  

### Java
```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i = 0; i < len; i++) {
            boolean left = (i == 0) || flowerbed[i - 1] == 0;
            boolean right = (i == len - 1) || flowerbed[i + 1] == 0;
            if(left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    } 
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        int len = flowerbed.size();
        for(int i = 0; i < len; i++) {
            bool left = (i == 0) || flowerbed[i - 1] == 0;
            bool right = (i == len - 1) || flowerbed[i + 1] == 0;
            if(left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
};
```
