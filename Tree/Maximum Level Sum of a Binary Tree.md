Leetcode Question : [Maximum Level Sum of a Binary Tree](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/)

```java
class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int level = 1, i = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int prev = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            int n = q.size();
            int sum = 0;
            for(int j = 0; j < n; j++) {
                TreeNode temp = q.poll();
                sum += temp.val;
                if(temp.left != null) {
                    q.offer(temp.left);
                }
                if(temp.right != null) {
                    q.offer(temp.right);
                }
            }
            if(prev < sum) {
                prev = sum;
                level = i;
            }
            i++;
        }
        return level;  
    }
}
```
