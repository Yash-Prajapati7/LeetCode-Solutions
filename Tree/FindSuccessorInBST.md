Leetcode Question : https://leetcode.com/problems/inorder-successor-in-bst/description/
```java
class Solution {
    public TreeNode successor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        
        while(root != null) {
            if(p.val >= root.val) {
                root = root.right;
            }
            else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
```
