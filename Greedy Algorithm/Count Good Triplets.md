Leetcode Question : [Count Good Triplets](https://leetcode.com/problems/count-good-triplets/description/)

```java
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[k] - arr[j]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
```
