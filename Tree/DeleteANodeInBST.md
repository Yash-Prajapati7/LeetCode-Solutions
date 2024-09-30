Leetcode Question : [Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/)
```java
class Solution {
    private TreeNode returnLastRight(TreeNode root) {
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }

    private TreeNode helper(TreeNode root) {
        if(root.left == null) {
            return root.right;
        }
        else if (root.right == null) {
            return root.left;
        }
        else {
            TreeNode rightChild = root.right;
            TreeNode lastRightOnLeft = returnLastRight(root.left);
            lastRightOnLeft.right = rightChild;
        }
        return root.left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val == key) {
            return helper(root);
        }

        TreeNode current = root;
        while(current != null) {
            if(current.val > key) {
                if(current.left != null && current.left.val == key) {
                    current.left = helper(current.left);
                    break;
                }
                else {
                    current = current.left;
                }
            }
            else {
                if(current.right != null && current.right.val == key) {
                    current.right = helper(current.right);
                    break;
                }
                else {
                    current = current.right;
                }
            }
        }
        return root;
    }
}
```
## Diagramatic explaination
![image](https://github.com/Yash-Prajapati7/LeetCode-Solutions/assets/157267869/1d4b9751-22f2-4abc-86a3-7595401de7ab)

