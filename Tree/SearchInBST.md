Leetcode Question : https://leetcode.com/problems/search-in-a-binary-search-tree/
```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val) {
            root = (val > root.val) ? root.right : root.left;
        }
        return root;
    }
}
```
