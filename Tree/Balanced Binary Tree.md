Leetcode Question : [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

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
    private int check(TreeNode root) {
        if(root == null) return 0;

        int left = check(root.left);
        if(left == -1) return -1;

        int right = check(root.right);
        if(right == -1) return -1;

        // check the height difference
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return (check(root) == -1) ? false : true;
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
private:
    int check(TreeNode* root) {
        if(root == nullptr) return 0;

        int left = check(root->left);
        if(left == -1) return -1;

        int right = check(root->right);
        if(right == -1) return -1;

        // check the height difference
        if(abs(left - right) > 1) return -1;
        return max(left, right) + 1;
    }

public:
    bool isBalanced(TreeNode* root) {
        return (check(root) == -1) ? false : true;
    }
};
```
