Leetcode Question: [Minimum Number of Operations to Sort a Binary Tree by Level](https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/)

```java
class Solution {
    public int minimumOperations(TreeNode root) {
        int mask = 1048575; // mask eq. to 0xFFFFF
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode temp = null;
        int n = 0, originalPos = 0, swaps = 0;

        while(!q.isEmpty()) {
            n = q.size();
            long[] values = new long[n];
            
            for(int i = 0; i < n; i++) {
                temp = q.poll();
                values[i] = ((long) temp.val << 20) + i;

                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }

            Arrays.sort(values);

            for(int i = 0; i < n; i++) {
                originalPos = (int)(values[i] & mask);
                if(originalPos != i) {
                    long current = values[i];
                    values[i--] = values[originalPos];
                    values[originalPos] = current;
                    swaps++;
                }
            }
        }
        return swaps;
    }
}
```
