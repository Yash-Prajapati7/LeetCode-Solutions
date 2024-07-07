Leetcode Question : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
## Method - 1 
```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store indices of elements in the inorder traversal
        HashMap<Integer, Integer> indexValues = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexValues.put(inorder[i], i);
        }
        // Call the private helper function to recursively build the tree
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexValues);

        return root;
    }

    // The prefix 'pre' refers to preorder & 'in' refers to inorder
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> indexValues) {
        // Base case: If the start indices exceed the end indices, return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // Create a new TreeNode with value at the current preorder index
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find the index of the current root value in the inorder traversal
        int inorderRootIndex = indexValues.get(root.val);

        // Calculate the number of elements in the left subtree
        int nodesOnLeft = inorderRootIndex - inStart;

        // Recursively build the left subtree
        root.left = buildTree(preorder, preStart + 1, preStart + nodesOnLeft, inorder, inStart, inorderRootIndex - 1, indexValues);

        // Recursively build the right subtree
        root.right = buildTree(preorder, preStart + nodesOnLeft + 1, preEnd, inorder, inorderRootIndex + 1, inEnd, indexValues);

        return root;
    }
}
```

## Method - 2 (Eliminating the use of HashMap)
```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int inIndex = inStart;
        while (inIndex <= inEnd && inorder[inIndex] != node.val) {
            inIndex++;
        }

        node.left = build(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        node.right = build(preorder, inorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd);
        return node;
    }
}
```

## Method - 3 (Using Global variables)
```java
class Solution {
    private int inorderIndex = 0;
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stopValue) {
        if (preorderIndex >= preorder.length) {
            return null;
        }
        if (inorder[inorderIndex] == stopValue) {
            ++inorderIndex;
            return null;
        }

        TreeNode node = new TreeNode(preorder[preorderIndex++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stopValue);
        return node;
    }
}

```
