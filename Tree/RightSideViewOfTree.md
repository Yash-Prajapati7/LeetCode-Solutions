Leetcode Question : https://leetcode.com/problems/binary-tree-right-side-view/
```java
class Solution {
    public List<Integer> result = new ArrayList<>();
    public void helper(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(level == result.size()) {
            result.add(root.val);
        }
        helper(root.right, level+1);
        helper(root.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return result;
    }
}
```
