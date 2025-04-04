Leetcode Question : [Lowest Common Ancestor of Deepest Leaves](https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/)

### Java
```java
class Solution {
    private Pair<TreeNode, Integer> dfs(TreeNode root) {
        if(root == null) return new Pair<>(null, 0);
        Pair<TreeNode, Integer> left = dfs(root.left);
        Pair<TreeNode, Integer> right = dfs(root.right);

        int leftHeight = left.getValue();
        int rightHeight = right.getValue();

        if(leftHeight > rightHeight) return new Pair<>(left.getKey(), leftHeight + 1);
        if(rightHeight > leftHeight) return new Pair<>(right.getKey(), rightHeight + 1);
        return new Pair<>(root, leftHeight + 1);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }
}
```
