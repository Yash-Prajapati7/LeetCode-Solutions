Leetcode Question: [Buy Two Chocolates](https://leetcode.com/problems/buy-two-chocolates/)

### Java
```java
class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int price = prices[0] + prices[1];
        if(price <= money) {
            return money - price;
        }
        else {
            return money;
        }
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int buyChoco(vector<int>& prices, int money) {
        sort(prices.begin(), prices.end());
        int price = prices[0] + prices[1];
        if(price <= money) {
            return money - price;
        }
        else {
            return money;
        }
    }
};
```
