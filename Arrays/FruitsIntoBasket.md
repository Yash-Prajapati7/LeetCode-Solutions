Leetcode Question : https://leetcode.com/problems/fruit-into-baskets/description/
### Java
```java
import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0; 
        int right = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        while (right < fruits.length) {
            hm.put(fruits[right], hm.getOrDefault(fruits[right], 0) + 1);
            if (hm.size() > 2) {
                hm.put(fruits[left], hm.get(fruits[left]) - 1);
                if (hm.get(fruits[left]) == 0) {
                    hm.remove(fruits[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
```
### C++
```cpp
#include <unordered_map>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        unordered_map<int, int> hm;

        while (right < fruits.size()) {
            hm[fruits[right]]++;
            if (hm.size() > 2) {
                hm[fruits[left]]--;
                if (hm[fruits[left]] == 0) {
                    hm.erase(fruits[left]);
                }
                left++;
            }
            maxLength = max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
};
```
