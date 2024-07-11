Leetcode Question : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
```java
class BSTIterator {
    private Stack<TreeNode> s = new Stack<>();
    private boolean reverse;

    private void pushAll(TreeNode node) {
        while (node != null) {
            s.push(node);
            if (reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode node = s.pop();
        if (reverse) {
            pushAll(node.left);
        } else {
            pushAll(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j > k) {
                j = right.next();
            } else {
                i = left.next();
            }
        }
        return false;
    }
}

```
