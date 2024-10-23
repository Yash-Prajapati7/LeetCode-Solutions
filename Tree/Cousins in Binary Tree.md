LeetCode Question: [Cousins in Binary Tree](https://leetcode.com/problems/cousins-in-binary-tree/)

```java
class Solution {
    int depthX = -1, depthY = -1;
    TreeNode parentX = null, parentY = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return depthX == depthY && parentX != parentY;
    }
    
    private void dfs(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            depthX = depth;
            parentX = parent;
        }
        if (node.val == y) {
            depthY = depth;
            parentY = parent;
        }
        dfs(node.left, node, x, y, depth + 1);
        dfs(node.right, node, x, y, depth + 1);
    }
}
```
