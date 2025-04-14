Leetcode Question : [Count Good Triplets](https://leetcode.com/problems/count-good-triplets/description/)
## Method - 1
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
## Method - 2 (A little optimised)
```java
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int val1 = 0, val2 = 0, val3 = 0;
        int ans = 0;

        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                val1 = arr[i] - arr[j];
                val1 = val1 < 0 ? -val1 : val1;

                if(val1 <= a) {
                    for(int k = j + 1; k < n; k++) {
                        val2 = arr[j] - arr[k];
                        val3 = arr[i] - arr[k];
                        val2 = val2 < 0 ? -val2 : val2;
                        val3 = val3 < 0 ? -val3 : val3;

                        if(val2 <= b && val3 <= c) ans++;
                    }
                }
            }
        }
        return ans;
    }
}
```
