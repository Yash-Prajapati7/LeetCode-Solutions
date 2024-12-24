Leetcode Question : [Number of Common Factors](https://leetcode.com/problems/number-of-common-factors/)

```java
class Solution {
    public int commonFactors(int a, int b) {
        int count = 0;
        int x = 1;
        // Keep 'b' as the smallest number
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(x <= b) {
            if((a % x == 0) && (b % x == 0)) count++;
            x++;
        }

        return count;
    }
}
```
