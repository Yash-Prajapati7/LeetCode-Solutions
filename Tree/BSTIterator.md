Leetcode Question : https://leetcode.com/problems/binary-search-tree-iterator/description/
```java
class BSTIterator {
    private Stack<TreeNode> s = new Stack<>();

    private void pushAllLeft(TreeNode root) {
        while(root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode node = s.pop();
        if(node.right != null) {
            pushAllLeft(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !(s.isEmpty());
    }
}

```
