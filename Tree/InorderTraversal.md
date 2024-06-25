Leetcode Question : https://leetcode.com/problems/binary-tree-inorder-traversal/
## Method - 1 (Modifying the recursive inorder traversal method)
```java
class Solution {
    public List<Integer> result = new ArrayList<>();
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }
}
```
## Method - 2 (Modifying the Morris's Inorder Traversal method)
```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while(current != null) {
            if(current.left == null) {
                result.add(current.val);
                current = current.right;
            }
            else {
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = current;
                    current = current.left;
                }
                else {
                    prev.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}
```
