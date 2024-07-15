Leetcode Question : https://leetcode.com/problems/create-binary-tree-from-descriptions/description/
## Method - 1
```java
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] des : descriptions) {
            int parentVal = des[0];
            int childVal = des[1];
            int isLeft = des[2];

            TreeNode parent = nodes.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = nodes.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            nodes.put(parentVal, parent);
            nodes.put(childVal, child);
            children.add(childVal);
        }

        // Find out the root of the tree
        TreeNode root = null;
        for (int key : nodes.keySet()) {
            if (!children.contains(key)) {
                root = nodes.get(key);
                break;
            }
        }

        return root;
    }
}
```

## Method - 2 (Eliminating the use of Set by modifying the TreeNode class)
```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    boolean isChild;

    TreeNode(int x) {
        val = x;
        this.isChild = false;
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();

        for (int[] des : descriptions) {
            int parentVal = des[0];
            int childVal = des[1];
            int isLeft = des[2];

            TreeNode parent = nodes.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = nodes.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            nodes.put(parentVal, parent);
            nodes.put(childVal, child);
            child.isChild = true;
        }

        // Find out the root of the tree
        TreeNode root = null;
        for (TreeNode node : nodes.values()) {
            if (!node.isChild) {
                root = node;
                break;
            }
        }

        return root;
    }
}
```
