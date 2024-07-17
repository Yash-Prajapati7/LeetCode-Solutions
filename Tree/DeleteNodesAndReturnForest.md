Leetcode Question : https://leetcode.com/problems/delete-nodes-and-return-forest/
```java
class Solution {
    private TreeNode deleteNodes(TreeNode root, HashSet<Integer> set, List<TreeNode> ans) {
        if(root == null) {
            return null;
        }

        root.left = deleteNodes(root.left, set, ans);
        root.right = deleteNodes(root.right, set, ans);

        if(set.contains(root.val)) {
            if(root.left != null) {
                ans.add(root.left);
            }
            if(root.right != null) {
                ans.add(root.right);
            }
            return null;
        }

        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i : to_delete) {
            set.add(i);
        }

        // Check whether the set contains the root
        if(!set.contains(root.val)) {
            ans.add(root);
        }

        deleteNodes(root, set, ans);
        return ans;
    }
}
```
