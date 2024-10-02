Leetcode Question : [kth Smallest Element In BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        
        TreeNode current = root;
        int counter = 0;
        
        while (current != null) {
            if (current.left == null) {
                counter++;
                if (counter == k) {
                    return current.val;
                }
                current = current.right;
            } else {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    counter++;
                    if (counter == k) {
                        return current.val;
                    }
                    current = current.right;
                }
            }
        }
        return -1;
    }
}
```
