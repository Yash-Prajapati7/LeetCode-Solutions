### Leetcode Question: [Candy](https://leetcode.com/problems/candy/)

```java
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for(int i = 0; i < n - 1; i++) {
            if(ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for(int i = n - 1; i > 0; i--) {
            if(ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }

        int totalcandies = 0;
        for(int i : candies) {
            totalcandies += (i + 1);
        }

        return totalcandies;
    }
}
```
