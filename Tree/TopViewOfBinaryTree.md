Not on Leetcode yet, GeeksForGeeks Link : https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
```java
import java.util.*;

public class TopViewOfBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Pair {
        TreeNode node;
        int hd; // Horizontal distance

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(TreeNode root) {
        if (root == null) return;

        TreeMap<Integer, Integer> topView = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair current = q.poll();
            TreeNode temp = current.node;
            int hd = current.hd;

            if (!topView.containsKey(hd)) {
                topView.put(hd, temp.val);
            }

            if (temp.left != null) {
                q.offer(new Pair(temp.left, hd - 1));
            }

            if (temp.right != null) {
                q.offer(new Pair(temp.right, hd + 1));
            }
        }

        for (int values : topView.values()) {
            result.add(values);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Creating the binary tree
        TreeNode root = new TreeNode(1); // Root node
        root.left = new TreeNode(2); // Left child of root
        root.right = new TreeNode(3); // Right child of root
        root.left.right = new TreeNode(4); // Right child of node 2
        root.left.right.right = new TreeNode(5); // Right child of node 4
        root.left.right.right.right = new TreeNode(6); // Right child of node 5

        // Tree visualization:
        //      1
        //     / \
        //    2   3
        //     \
        //      4
        //       \
        //        5
        //         \
        //          6

        topView(root); // Expected output: [2, 1, 3, 6]
    }
}

```
# Top View of Binary Tree

This Java code implements an algorithm to find the top view of a binary tree. The top view consists of nodes visible when the tree is viewed from the top.

## Key Components:

1. `Pair` Class: Stores a tree node and its horizontal distance from the root node (which is considered 0).

2. `topView` Method:
   - Uses a TreeMap to store the top view nodes.
   - Employs a Queue for level-order traversal.
   - Processes nodes level by level, keeping track of horizontal distances.

3. **Algorithm Steps**:
   - Start with the root node at horizontal distance 0.
   - For each node:
     - If its horizontal distance is not in the TreeMap, add it.
     - Enqueue left child with horizontal distance - 1.
     - Enqueue right child with horizontal distance + 1.
   - Continue until the queue is empty.

4. **Result**:
   - Values in the TreeMap represent the top view.
   - Printed as an ArrayList.

This approach ensures that only the first node at each horizontal distance is considered, effectively giving the top view of the tree.
