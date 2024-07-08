Leetcode Question : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
## Method - 1
```java
class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
```
## Method - 2 (Eliminate the use of Global variable)
```java
class Solution {
    private void flattenTheTree(TreeNode root, TreeNode[] prev) {
        if (root == null) return;

        flattenTheTree(root.right, prev);
        flattenTheTree(root.left, prev);

        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }

    public void flatten(TreeNode root) {
        flattenTheTree(root, new TreeNode[1]);
    }
}
```
## Method - 3 (Using Stack)
```java
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()) {
            TreeNode current = s.pop();

            if(current.right != null) {
                s.push(current.right);
            }
            if(current.left != null) {
                s.push(current.left);
            }

            if(!s.isEmpty()) {
                current.right = s.peek();
            }
            current.left = null;
        }
    }
}
```
