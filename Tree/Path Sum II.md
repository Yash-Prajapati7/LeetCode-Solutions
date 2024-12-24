Leetcode Question : [Path Sum II](https://leetcode.com/problems/path-sum-ii/)

```java
class Solution {
    private void pathSum(TreeNode root, List<List<Integer>> ans, List<Integer> current, int targetSum, int temp) {
        if (root == null) return; // Handle null node
        temp += root.val;
        current.add(root.val);

        if (root.left == null && root.right == null && temp == targetSum) {
            ans.add(new ArrayList<>(current));
        } else {
            if (root.left != null) pathSum(root.left, ans, current, targetSum, temp);
            if (root.right != null) pathSum(root.right, ans, current, targetSum, temp);
        }
        // Backtrack to explore other paths
        current.remove(current.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, ans, new ArrayList<>(), targetSum, 0);
        return ans;
    }
}
```
