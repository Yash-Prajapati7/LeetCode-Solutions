Leetcode Question : [Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/)

### Java

```java
class Solution {
    long maxProduct = 0;
    int mod = 1000000007;

    private int dfsTotal(TreeNode root) {
        if (root == null) return 0;
        return root.val + dfsTotal(root.left) + dfsTotal(root.right);
    }

    private int dfsSub(TreeNode root, int totalSum) {
        if (root == null) return 0;

        int left = dfsSub(root.left, totalSum);
        int right = dfsSub(root.right, totalSum);

        int subTreeSum = left + right + root.val;

        long product = (long) subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        int totalSum = dfsTotal(root);
        dfsSub(root, totalSum);
        return (int) (maxProduct % mod);
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long maxProduct = 0;
    int mod = 1000000007;

    int dfsTotal(TreeNode* root) {
        if (root == nullptr) return 0;
        return root->val + dfsTotal(root->left) + dfsTotal(root->right);
    }

    int dfsSub(TreeNode* root, int totalSum) {
        if (root == nullptr) return 0;

        int left = dfsSub(root->left, totalSum);
        int right = dfsSub(root->right, totalSum);

        int subTreeSum = left + right + root->val;

        long long product = (long long) subTreeSum * (totalSum - subTreeSum);
        maxProduct = max(maxProduct, product);

        return subTreeSum;
    }

    int maxProduct(TreeNode* root) {
        int totalSum = dfsTotal(root);
        dfsSub(root, totalSum);
        return (int)(maxProduct % mod);
    }
};
```
