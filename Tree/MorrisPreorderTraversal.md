Leetcode Question : https://leetcode.com/problems/binary-tree-preorder-traversal/description/
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
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
                    result.add(current.val);
                    current = current.left;
                }
                else {
                    prev.right = null;
                    current = current.right;
                }

            }
        }
        return result;
    }
}
```
