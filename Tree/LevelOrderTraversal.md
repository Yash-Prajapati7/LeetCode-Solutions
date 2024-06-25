```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result; // Return empty list if root is null
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);
            
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                
                if (temp != null) {
                    level.add(temp.val);
                    if (temp.left != null) {
                        q.offer(temp.left);
                    }
                    if (temp.right != null) {
                        q.offer(temp.right);
                    }
                }
            }
            
            result.add(level);
        }
        
        return result;
    }
}
```
