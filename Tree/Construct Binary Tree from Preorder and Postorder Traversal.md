Leetcode Question : [Construct Binary Tree from Preorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)

```java
class Solution {
    HashMap<Integer, Integer> index = new HashMap<>(31);
    private TreeNode construct(int[] pre, int preStart, int preEnd, int[] post, int postStart) {
        if(preStart > preEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);

        if(preStart == preEnd) return root;

        int leftRootVal = pre[preStart + 1];
        int leftSubTreeSize = index.get(leftRootVal) - postStart + 1;
        root.left = construct(pre, preStart + 1, preStart + leftSubTreeSize, post, postStart);
        root.right = construct(pre, preStart + leftSubTreeSize + 1, preEnd,  post, postStart + leftSubTreeSize);

        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int len = postorder.length;
        for(int i = 0; i < len; i++) {
            index.put(postorder[i], i);
        }
        
        return construct(preorder, 0, len - 1, postorder, 0);
    }
}
```
