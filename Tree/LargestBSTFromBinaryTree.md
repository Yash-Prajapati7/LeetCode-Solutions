Leetcode Question : https://leetcode.com/problems/largest-bst-subtree/
```java
class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Result {
        int size;
        int min;
        int max;

        Result(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Result result = largestBST(root);
        return result != null ? result.size : 0; // Check if result is null before accessing size
    }

    private Result largestBST(TreeNode node) {
        if (node == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = largestBST(node.left);
        Result right = largestBST(node.right);

        if (left != null && right != null && node.val > left.max && node.val < right.min) {
            int size = 1 + left.size + right.size;
            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);
            return new Result(size, min, max);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(12);
        root.left.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);

        int largestBSTSize = solution.largestBSTSubtree(root);
        System.out.println("Size of the largest BST subtree: " + largestBSTSize);
    }
}

```

### Note
- While submitting the solution for LeetCode, **just comment out the `main` method** and the code will work correctly.
