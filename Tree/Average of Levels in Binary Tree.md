Leetcode Question : [Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/)

### Java

```java
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int nodes = q.size();
            double levelSum = 0;
            for(int i = 0; i < nodes; i++) {
                TreeNode current = q.poll();
                levelSum += current.val;
                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
            ans.add(levelSum / nodes);
        }
        return ans;
    }
}
```
