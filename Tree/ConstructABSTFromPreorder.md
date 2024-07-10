Leetcode Question : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
```java
class Solution {
    private TreeNode buildTree(int[] preorder, int[] i, int upperBound) {
        if(i[0] == preorder.length || preorder[i[0]] > upperBound) return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = buildTree(preorder, i, root.val);
        root.right = buildTree(preorder, i, upperBound);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, new int[1], Integer.MAX_VALUE);
    }
}
```
