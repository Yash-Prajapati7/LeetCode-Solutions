Leetcode Question :
https://leetcode.com/problems/balanced-binary-tree/

## Explaination of the checkerFunction
This function does the heavy lifting of checking the balance. It works by recursively going down the tree:
- If the current node is empty (null), it returns 0 (height of an empty tree is 0).
- It checks the height of the left and right subtrees using the same function (checkerFunction).
- If either subtree is already unbalanced (returns -1), the whole tree is unbalanced so it returns -1.
- Otherwise, it checks if the absolute difference between the left and right heights is greater than 1. A difference of more than 1 means the tree is unbalanced, so it returns -1.
- If all the above checks pass, it returns the height of the current tree.
- Then in the isBalanced function we simply check whether the returned value is -1 or not and return false or true accordingly.

## Below is the java code for the same
```java
class Solution {
    public static int checkerFunction(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = checkerFunction(root.left);
        if(leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkerFunction(root.right);
        if(rightHeight == -1) {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return - 1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public boolean isBalanced(TreeNode root) {
        if(checkerFunction(root) == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
```
