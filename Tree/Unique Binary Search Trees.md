Leetcode Question : [Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)

```java
class Solution {
    public int numTrees(int n) {
        // DP array to store the number of unique BSTs for each number of nodes
        int[] dp = new int[n + 1];

        // Base case: There is 1 unique BST with 0 nodes and 1 node
        dp[0] = 1;
        dp[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                // Left subtree has 'root-1' nodes, right subtree has 'nodes-root' nodes
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }

        return dp[n];
    }
}
```
