Leetcode Question: [Path Sum](https://leetcode.com/problems/path-sum/)

```java
class Solution {
    private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            return true;
        } else if (root.left == null && root.right == null && sum != targetSum) {
            sum -= root.val;
        }
        return hasPathSum(root.left, targetSum, sum) || hasPathSum(root.right, targetSum, sum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return hasPathSum(root, targetSum, sum);
    }
}
```
