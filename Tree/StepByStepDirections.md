Leetcode Question : https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/
```java
class Solution {
    private TreeNode LCA(TreeNode root, int node1, int node2) {
        if (root == null || root.val == node1 || root.val == node2) {
            return root;
        }
        TreeNode left = LCA(root.left, node1, node2);
        TreeNode right = LCA(root.right, node1, node2);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    private boolean getPath(TreeNode lca, int value, StringBuilder path) {
        if (lca == null) {
            return false;
        }
        if (lca.val == value) {
            return true;
        }

        path.append('L');
        if (getPath(lca.left, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // delete the last character

        path.append('R');
        if (getPath(lca.right, value, path)){
            return true;
        }
        path.setLength(path.length() - 1); // delete the last character
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // First find the lowest common ancestor 
        TreeNode lca = LCA(root, startValue, destValue);

        // Get the path from ancestor to start node
        StringBuilder pathToStart = new StringBuilder();
        getPath(lca, startValue, pathToStart);

        // Get the path from ancestor to destination
        StringBuilder pathToDestiny = new StringBuilder();
        getPath(lca, destValue, pathToDestiny);

        // Replace the inputs in the pathToStart string to 'U'
        for (int i = 0; i < pathToStart.length(); i++) {
            pathToStart.setCharAt(i, 'U');
        }

        return pathToStart.toString() + pathToDestiny.toString();
    }
}

```
