Leetcode Question : [Reverse Odd Levels of Binary Tree](https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/)

### Method - 1 (Iterative approach)
```java
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        int level = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.poll();
                
                if (level % 2 != 0) {
                    q1.offer(temp);
                    s.push(temp.val);
                }
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            if (level % 2 != 0) {
                for (int i = 0; i < n; i++) {
                    q1.poll().val = s.pop();
                }
            }
            level++;
        }
        return root;
    }
}
```

### Method - 2 (Recursive approach)
```java
class Solution {
    private void reverse(TreeNode left, TreeNode right, int level) {
        if(left == null || right == null) {
            return;
        }
        if(level % 2 != 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        reverse(left.left, right.right, level + 1);
        reverse(left.right, right.left, level + 1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        reverse(root.left, root.right, 1);
        return root;
    }
}
```
