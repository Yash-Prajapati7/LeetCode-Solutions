LeetCode Question : [XOR Queries of a Subarray](https://leetcode.com/problems/xor-queries-of-a-subarray/)

```java
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int k = 0;
        int[] prefix = new int[arr.length];
        int[] ans = new int[n];
        prefix[0] = arr[0];

        for(int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        for(int i = 0; i < n; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            if(start == 0) {
                ans[i] = prefix[end];
            }
            else {
                ans[i] = prefix[end] ^ prefix[start - 1];
            }
        }

        return ans;
    }
}
```
