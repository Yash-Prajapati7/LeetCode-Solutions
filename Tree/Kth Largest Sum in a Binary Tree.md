Leetcode Question: [Kth Largest Sum in a Binary Tree](https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/)

```java
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1; // Return -1 if the tree is empty
        }

        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(k);

        q.offer(root);

        // Level order traversal to compute sums
        while (!q.isEmpty()) {
            int n = q.size();
            long sum = 0;
            for (int j = 0; j < n; j++) {
                TreeNode temp = q.poll();
                sum += temp.val;
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }

            // Maintain the smallest k sums using a min-heap
            if (pq.size() < k) {
                pq.offer(sum);
            } else if (sum > pq.peek()) {
                pq.poll();
                pq.offer(sum);
            }
        }

        // If we have fewer than k levels, return -1
        return pq.size() < k ? -1 : pq.poll();
    }
}
```
