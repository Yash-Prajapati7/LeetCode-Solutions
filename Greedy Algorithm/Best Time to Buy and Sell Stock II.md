Leetcode Question : [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

### Java
```java
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int start = prices[0];
        int len = prices.length;
        for(int i = 1; i < len; i++){
            if(start < prices[i]) max += prices[i] - start;
            start = prices[i];
        }
        return max;
    }
}
```

### C++
```cpp
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max = 0;
        int start = prices[0];
        int len = prices.size();
        for(int i = 1; i < len; i++){
            if(start < prices[i]) max += prices[i] - start;
            start = prices[i];
        }
        return max;
    }
};
```
