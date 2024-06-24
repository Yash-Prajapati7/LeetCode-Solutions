## Iterative approach using a Stack
```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            
            stack.push(node1.right);
            stack.push(node2.right);
            stack.push(node1.left);
            stack.push(node2.left);
        }
        
        return true;
    }
}
```

## Recursive approach
```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;  // Both trees are empty, hence they are the same
        } else if (p == null || q == null) {
            return false; // One of the trees is empty, hence they are not the same
        } else if (p.val != q.val) {
            return false; // The values of the nodes do not match, hence they are not the same
        } else {
            // Recursively check both left and right subtrees
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}

```
