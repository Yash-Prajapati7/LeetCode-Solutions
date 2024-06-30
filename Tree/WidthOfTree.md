Leetcode Question :
```java
class Solution {
    private class NodeWithIndex {
        TreeNode node;
        int index;
        NodeWithIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<NodeWithIndex> q = new LinkedList<>();
        q.offer(new NodeWithIndex(root, 0));
        int ans = 0;

        while(!q.isEmpty()) {

            int size = q.size();
            int first = 0, last = 0;

            for(int i = 0; i < size; i++) {

                NodeWithIndex temp = q.poll();
                TreeNode node = temp.node;
                int currentIndex = temp.index;

                if(i == 0) {
                    first = currentIndex;
                }
                if(i == size - 1) {
                    last = currentIndex;
                }
                if(node.left != null) {
                    q.offer(new NodeWithIndex(node.left, 2 * currentIndex));
                }
                if(node.right != null) {
                    q.offer(new NodeWithIndex(node.right, 2 * currentIndex + 1));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
