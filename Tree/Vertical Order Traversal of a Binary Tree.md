Leetcode Question: [Vertical Order Traversal of a Binary Tree](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)

```java
class Solution {
    List<int[]> nodeList = new ArrayList<>();
    private void dfs(int vertical, int level, TreeNode root) {
        if(root == null) {
            return;
        }
        nodeList.add(new int[] {vertical, level, root.val});
        dfs(vertical - 1, level + 1, root.left);
        dfs(vertical + 1, level + 1, root.right);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        // Populate the nodeList
        dfs(0, 0, root);

        // Sort nodeList based on the vertical
        Collections.sort(nodeList, (a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // Gather the nodes by their vertical level
        List<Integer> current = new ArrayList<>();
        int currentVertical = nodeList.get(0)[0];
        for(int[] node : nodeList) {
            if(node[0] != currentVertical) {
                result.add(current);
                current = new ArrayList<>();
                currentVertical = node[0];
            }
            current.add(node[2]);
        }
        result.add(current);
        return result;
    }
}
```
