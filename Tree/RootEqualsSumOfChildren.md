Leetcode Question : https://leetcode.com/problems/root-equals-sum-of-children/
```java
class Solution {
    public boolean checkTree(TreeNode root) {
        return (root.val == (root.left.val + root.right.val));
    }
}
```
