Leetcode Question : [Find Largest Value in Each Tree Row](https://leetcode.com/problems/find-largest-value-in-each-tree-row/)

## Method - 1
```java
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int n = 0;

        while (!q.isEmpty()) {
            n = q.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                TreeNode temp = q.poll();
                max = max < temp.val ? temp.val : max;
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }

            ans.add(max);
        }

        return ans;
    }
}
```

## Method - 2
```java
class Solution {
    List<Integer> ans;
    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int ind) {
        if (node != null) {
            int v = node.val;
            if (ind == ans.size()) {
                ans.add(v);
            } else {
                ans.set(ind, Math.max(ans.get(ind), v));
            }
            dfs(node.left, ind + 1);
            dfs(node.right, ind + 1);
        }
    }
}
```
