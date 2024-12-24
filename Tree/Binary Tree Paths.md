Leetcode Question : [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)

```java
class Solution {
    private void binaryTreePaths(TreeNode root, List<String> ans, StringBuilder sb) {
        sb.append(root.val);

        if(root.left == null && root.right == null) {
            ans.add(sb.toString());
            return;
        }

        sb.append("->");
        int len = sb.length();

        if(root.left != null) binaryTreePaths(root.left, ans, sb);
        sb.setLength(len);
        if(root.right != null) binaryTreePaths(root.right, ans, sb);
        sb.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        binaryTreePaths(root, ans, sb);
        return ans;
    }
}
```
