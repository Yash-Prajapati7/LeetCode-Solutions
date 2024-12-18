Leetcode Question : [Final Prices With a Special Discount in a Shop](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/)

### Java
```java
class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && prices[j] > prices[i]) {
                j++;
            }
            ans[i] = j == n ? prices[i] : prices[i] - prices[j];
        }

        return ans;
    }
}
```

### C++
```cpp
class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
        int n = prices.size();
        vector<int> ans(n);

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && prices[j] > prices[i]) {
                j++;
            }
            ans[i] = (j == n) ? prices[i] : prices[i] - prices[j];
        }

        return ans;
    }
};
```
