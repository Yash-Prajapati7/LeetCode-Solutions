Leetcode Question: [Maximum Distance in Arrays](https://leetcode.com/problems/maximum-distance-in-arrays/)

### Java
```java
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = 0;

        for(int i = 1; i < arrays.size(); i++) {
            int currentMin = arrays.get(i).get(0);
            int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);

            result = Math.max(result, Math.abs(currentMax - min));
            result = Math.max(result, Math.abs(currentMin - max));

            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
        }
        return result;
    }
}
```

### C++
```cpp
class Solution {
public:
    int maxDistance(vector<vector<int>>& arrays) {
        int minVal = arrays[0][0];
        int maxVal = arrays[0].back();
        int result = 0;

        for(int i = 1; i < arrays.size(); i++) {
            int currentMin = arrays[i][0];
            int currentMax = arrays[i].back();

            result = max(result, abs(currentMax - minVal));
            result = max(result, abs(currentMin - maxVal));

            minVal = min(minVal, currentMin);
            maxVal = max(maxVal, currentMax);
        }
        return result;
    }
};
```
