Leetcode Question : [kth Smallest Element In BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
## Method - 1 (Recursive)
```java
class Solution {
    private TreeNode kthSmallest(TreeNode root, int k, int[] count) {
        if (root == null) {
            return null;
        }
        TreeNode left = kthSmallest(root.left, k, count);
        if (left != null) {
            return left;
        }
        if (++count[0] == k) {
            return root;
        }
        return kthSmallest(root.right, k, count);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[]{0};  // using an array to pass by reference
        TreeNode ans = kthSmallest(root, k, count);
        System.gc();
        return ans == null ? 0 : ans.val;
    }
    
}
```
## Method - 2 (Non - Recursive)
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
