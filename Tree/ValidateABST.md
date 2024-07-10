Leetcode Question : https://leetcode.com/problems/validate-binary-search-tree/description/
```java
class Solution {
    private boolean validate(TreeNode root, long lowerLimit, long upperLimit) {
        if(root == null) {
            return true;
        }
        // check whether the given node lies in the range (lowerLimit, upperLimit)
        if(root.val >= upperLimit || root.val <= lowerLimit) {
            return false;
        }
        return (validate(root.left, lowerLimit, root.val) && validate(root.right, root.val, upperLimit));
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
```

### Note - `long` is used due to the given constraints.
Constraints:
- The number of nodes in the tree is in the range [1, 104].
- 2^31 <= Node.val <= 2^31 - 1
