Leetcode Question : [Balance a Binary Search Tree](https://leetcode.com/problems/balance-a-binary-search-tree/)

### Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void traverse(TreeNode root, ArrayList<Integer> values) {
        if (root == null)
            return;
        traverse(root.left, values);
        values.add(root.val);
        traverse(root.right, values);
    }

    public TreeNode buildBST(ArrayList<Integer> values, int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) >> 1;

        TreeNode node = new TreeNode(values.get(mid));
        node.left = buildBST(values, left, mid - 1);
        node.right = buildBST(values, mid + 1, right);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>(1000);
        traverse(root, values);
        return buildBST(values, 0, values.size() - 1);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void traverse(TreeNode* root, vector<int>& values) {
        if (root == nullptr)
            return;
        traverse(root->left, values);
        values.push_back(root->val);
        traverse(root->right, values);
    }

    TreeNode* buildBST(vector<int>& values, int left, int right) {
        if (left > right)
            return nullptr;

        int mid = (left + right) >> 1;

        TreeNode* node = new TreeNode(values[mid]);
        node->left = buildBST(values, left, mid - 1);
        node->right = buildBST(values, mid + 1, right);

        return node;
    }

    TreeNode* balanceBST(TreeNode* root) {
        vector<int> values;
        values.reserve(1000);
        traverse(root, values);
        return buildBST(values, 0, values.size() - 1);
    }
};
```
