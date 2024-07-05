Leetcode Question : https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
```java
class Solution {
    // Case 1: Collect all nodes at distance k in the subtree rooted at the target node
    private void subtreeNodes(TreeNode target, int k, ArrayList<Integer> result) {
        if (target == null || k < 0) return;
        if (k == 0) {
            result.add(target.val);
            return;
        }
        subtreeNodes(target.left, k - 1, result);
        subtreeNodes(target.right, k - 1, result);
    }

    // Case 2: Collect nodes at distance k that are in the ancestor tree of the target node
    private int nodesAtK(TreeNode root, TreeNode target, int k, ArrayList<Integer> result) {
        if (root == null) return -1;

        if (root == target) {
            subtreeNodes(target, k, result);
            return 0;
        }

        // Distance in the left subtree
        int dl = nodesAtK(root.left, target, k, result);
        if (dl != -1) {
            if (dl + 1 == k) {
                result.add(root.val);
            } else {
                subtreeNodes(root.right, k - dl - 2, result);
            }
            return 1 + dl;
        }

        // Distance in the right subtree
        int dr = nodesAtK(root.right, target, k, result);
        if (dr != -1) {
            if (dr + 1 == k) {
                result.add(root.val);
            } else {
                subtreeNodes(root.left, k - dr - 2, result);
            }
            return 1 + dr;
        }
        
        return -1; // Target not found in either subtree
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        nodesAtK(root, target, k, result);
        return result;
    }
}

```

## Dry run for the input
```java
       3
      / \
     5   1
    / \   \
   6   2   0
      / \
     7   4
```

### Parameters

- **Target Node**: `5`
- **Distance `k`**: `2`

### Expected Result

- Nodes at distance `2` from node `5` are `7`, `4`, and `1`.

### Dry Run

#### Initial Setup

- **Call**: `distanceK(root, target, k)`
- **Variables**:
  - `root`: Node with value `3`
  - `target`: Node with value `5`
  - `k`: `2`
  - `result`: Empty list (`[]`)

#### Execution Steps

1. **Call**: `nodesAtK(root, target, k, result)` with `root` as node `3`.

   - **Parameters**: `root = 3`, `target = 5`, `k = 2`, `result = []`
   - **Action**: `root` is not `null` and not the `target`.

2. **Left Subtree Check**:

   - **Call**: `nodesAtK(root.left, target, k, result)` with `root.left` as node `5`.

     - **Parameters**: `root = 5`, `target = 5`, `k = 2`, `result = []`
     - **Action**: `root` equals `target`.

     - **Call**: `subtreeNodes(target, k, result)` with `target` as node `5`.

       - **Parameters**: `target = 5`, `k = 2`, `result = []`
       - **Action**: `target` is not `null` and `k` is greater than `0`.

       - **Recursive Call**: `subtreeNodes(target.left, k - 1, result)` with `target.left` as node `6`.

         - **Parameters**: `target = 6`, `k = 1`, `result = []`
         - **Action**: `target` is not `null` and `k` is greater than `0`.

         - **Recursive Call**: `subtreeNodes(target.left, k - 1, result)` with `target.left` as `null`.

           - **Parameters**: `target = null`, `k = 0`, `result = []`
           - **Action**: Return `null`.

         - **Recursive Call**: `subtreeNodes(target.right, k - 1, result)` with `target.right` as `null`.

           - **Parameters**: `target = null`, `k = 0`, `result = []`
           - **Action**: Return `null`.

         - **Return**: From the call `subtreeNodes(6, 1, result)`.

       - **Recursive Call**: `subtreeNodes(target.right, k - 1, result)` with `target.right` as node `2`.

         - **Parameters**: `target = 2`, `k = 1`, `result = []`
         - **Action**: `target` is not `null` and `k` is greater than `0`.

         - **Recursive Call**: `subtreeNodes(target.left, k - 1, result)` with `target.left` as node `7`.

           - **Parameters**: `target = 7`, `k = 0`, `result = []`
           - **Action**: `k` is `0`.
           - **Result**: Add `7` to `result`.

           - **Update**: `result = [7]`

         - **Recursive Call**: `subtreeNodes(target.right, k - 1, result)` with `target.right` as node `4`.

           - **Parameters**: `target = 4`, `k = 0`, `result = [7]`
           - **Action**: `k` is `0`.
           - **Result**: Add `4` to `result`.

           - **Update**: `result = [7, 4]`

         - **Return**: From the call `subtreeNodes(2, 1, result)`.

       - **Return**: From the call `subtreeNodes(5, 2, result)`.

     - **Return**: `0` (distance to target is `0`).

     - **Update**: `dl = 0`

   - **Checking Right Subtree**:

     - **Distance Calculation**: `dl + 1 == k`?
     - **Check**: `0 + 1 == 2`? No.

     - **Call**: `subtreeNodes(root.right, k - dl - 2, result)` with `root.right` as node `1`.

       - **Parameters**: `root.right = 1`, `k - 0 - 2 = 0`, `result = [7, 4]`
       - **Action**: `k` is `0`.
       - **Result**: Add `1` to `result`.

       - **Update**: `result = [7, 4, 1]`

   - **Return**: `1 + dl = 1`.

3. **Right Subtree Check**:

   - **Call**: `nodesAtK(root.right, target, k, result)` with `root.right` as node `1`.

     - **Parameters**: `root = 1`, `target = 5`, `k = 2`, `result = [7, 4, 1]`
     - **Action**: `root` is not `null` and not `target`.

     - **Distance Calculation**: `dr = nodesAtK(root.right, target, k, result)`?

     - **Return**: `-1` (target not in the right subtree).

     - **Update**: `dr = -1`

   - **Check**: `dr + 1 == k`? No.

4. **Adding Ancestor Node**:

   - **Check**: `dr + 1 == k`? No.

   - **Return**: `-1`.

### Summary

- **Result List**: `[7, 4, 1]`

**Explanation**:
- Nodes at distance `2` from node `5` include:
  - **7** (Left child of node `2`, which is `2` levels below `5`).
  - **4** (Right child of node `2`, which is `2` levels below `5`).
  - **1** (Right child of the root node `3`, which is `2` levels above node `5`).

**Final Output**:
```java
[7, 4, 1]
```
