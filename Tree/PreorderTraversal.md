```java
class Solution {
    public List<Integer> result = new ArrayList<>();
    public void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }
}
```
