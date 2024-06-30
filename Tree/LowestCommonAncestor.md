Leetcode Question : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
### Base Case:

- If the current node (`root`) is `null`, return `root`.
- If the current node is equal to `p` or `q`, return the current node. This means that we have found one of the nodes we are looking for.

### Recursive Search:

- Recursively search the left subtree by calling `lowestCommonAncestor(root.left, p, q)`.
- Recursively search the right subtree by calling `lowestCommonAncestor(root.right, p, q)`.

### Combining Results:

- If both left and right subtree calls return non-null values, it means `p` and `q` are found in different subtrees. Hence, the current node (`root`) is their LCA.
- If only one of the subtree calls returns a non-null value, return the non-null result. This means both `p` and `q` are located in the same subtree.
- If both subtree calls return null, return null, indicating neither `p` nor `q` are in this subtree.

### Time Complexity

- **O(N)**, where `N` is the number of nodes in the tree. This is because, in the worst case, the algorithm may need to visit all the nodes.

### Space Complexity

- **O(H)**, where `H` is the height of the tree, due to the recursion stack. In the worst case, this could be **O(N)** for a skewed tree, but it is typically **O(log N)** for a balanced tree.

## Java solution
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else {
            return root;
        }
    }
}
