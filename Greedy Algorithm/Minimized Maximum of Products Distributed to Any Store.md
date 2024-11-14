Leetcode Question : [Minimized Maximum of Products Distributed to Any Store](https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/)

```java
class Solution {
    private boolean canDistribute(int n, int[] quantities, int x) {
        int m = quantities.length;
        int j = 0;
        int rem = quantities[j];
        for(int i = 0; i < n; i++) {
            if(rem <= x) {
                j++;
                if(j == m) {
                    return true;
                }
                else {
                    rem = quantities[j];
                }
            }
            else {
                rem -= x;
            }
        }
        return false;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int left = 0, right = 0;

        for(int quantity : quantities) {
            right = Math.max(quantity, right);
        }

        while(left < right) {
            int mid = (left + right) / 2;
            if(canDistribute(n, quantities, mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
```
