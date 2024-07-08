Leetcode Question : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
```java
class Solution {
    private TreeNode buildTree(int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> indexMap) {
        // Base case: no elements to construct the tree
        if (postStart > postEnd || inStart > inEnd) return null;

        // Root value from postorder
        TreeNode root = new TreeNode(postorder[postEnd]);

        // Root index in inorder
        int inorderRootIndex = indexMap.get(root.val);
        int nodesOnLeft = inorderRootIndex - inStart;

        // Recursively build left and right subtrees
        root.left = buildTree(inStart, inorderRootIndex - 1, postorder, postStart, postStart + nodesOnLeft - 1, indexMap);
        root.right = buildTree(inorderRootIndex + 1, inEnd, postorder, postStart + nodesOnLeft, postEnd - 1, indexMap);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Map from value to its index in inorder
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, postorder, 0, postorder.length - 1, indexMap);
    }
}
```
## Explaination for root.left and root.right
<img src="https://github.com/Yash-Prajapati7/LeetCode-Solutions/assets/157267869/2343d0b5-2e81-4608-a1a8-649cfa31962d" alt="root.left explaination Diagram" width="700" />
<br><br/>
--------------------------------------------------------------------------------------------------------------
<img src="https://github.com/Yash-Prajapati7/LeetCode-Solutions/assets/157267869/4ac34b89-e6bb-4117-ad63-bf91379272f4" alt="root.right explaination Diagram" width="700" />

