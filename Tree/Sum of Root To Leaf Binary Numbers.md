Leetcode Question : [Sum of Root To Leaf Binary Numbers](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/)

### Java

```java
class Solution {

    private int dfs(TreeNode node, int curr) {
        if (node == null) return 0;

        // Build the binary number
        curr = (curr << 1) | node.val;

        // If leaf node, return the number formed
        if (node.left == null && node.right == null) {
            return curr;
        }

        // Sum from left and right
        return dfs(node.left, curr) + dfs(node.right, curr);
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int dfs(TreeNode* node, int curr) {
        if (node == nullptr) return 0;

        // Build the binary number
        curr = (curr << 1) | node->val;

        // If leaf node, return the number formed
        if (node->left == nullptr && node->right == nullptr) {
            return curr;
        }

        // Sum from left and right
        return dfs(node->left, curr) + dfs(node->right, curr);
    }

public:
    int sumRootToLeaf(TreeNode* root) {
        return dfs(root, 0);
    }
};
```
