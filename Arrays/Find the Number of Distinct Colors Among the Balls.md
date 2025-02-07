Leetcode Question : [Find the Number of Distinct Colors Among the Balls](https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/)

### Java
```java
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        HashMap<Integer, Integer> ballMap = new HashMap<>();
        int ball, color, prevColor;

        int uniques = 0;
        for(int i = 0; i < n; i++) {
            ball = queries[i][0];
            color = queries[i][1];

            if(ballMap.containsKey(ball)) {
                prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);
                if(colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }                
            }

            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            ans[i] = colorMap.size();
        }

        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        int n = queries.size();
        vector<int> ans(n);
        unordered_map<int, int> colorMap;
        unordered_map<int, int> ballMap;
        int ball, color, prevColor;

        for(int i = 0; i < n; i++) {
            ball = queries[i][0];
            color = queries[i][1];

            if(ballMap.count(ball)) {
                prevColor = ballMap[ball];
                colorMap[prevColor]--;
                if(colorMap[prevColor] == 0) {
                    colorMap.erase(prevColor);
                }                
            }

            ballMap[ball] = color;
            colorMap[color]++;
            ans[i] = colorMap.size();
        }

        return ans;
    }
};
```
