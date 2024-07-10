Leetcode Question : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        int current = root.val;
        if(current < p.val && current < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if(current > p.val && current > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
```
### Explanation

The function `lowestCommonAncestor` finds the lowest common ancestor (LCA) of two nodes `p` and `q` in a Binary Search Tree (BST).

1. **Base Case**: If the `root` is `null`, return `null` because there are no nodes to process.
2. **Current Node Value**: Store the value of the current root node in the variable `current`.
3. **Both Nodes Greater**: If both `p` and `q` have values greater than `current`, then the LCA must be in the right subtree. Recursively call `lowestCommonAncestor` on the right child of the root.
4. **Both Nodes Smaller**: If both `p` and `q` have values smaller than `current`, then the LCA must be in the left subtree. Recursively call `lowestCommonAncestor` on the left child of the root.
5. **Split Point**: If neither of the above conditions is true, it means that the current node is the split point where `p` and `q` diverge in the tree. Hence, the current node is their lowest common ancestor.
