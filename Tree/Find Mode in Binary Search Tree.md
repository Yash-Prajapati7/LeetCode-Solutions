Leetcode Question : [Find Mode in Binary Search Tree](https://leetcode.com/problems/find-mode-in-binary-search-tree/)

```java
class Solution {
    private void preorder(TreeNode root, HashMap<Integer, Integer> freq, int[] max, int[] maxCount) {
        if (root == null) return;

        int node = root.val;
        freq.put(node, freq.getOrDefault(node, 0) + 1);
        int frequency = freq.get(node);

        if (frequency > max[0]) {
            max[0] = frequency;
            maxCount[0] = 1; // Reset count
        } else if (frequency == max[0]) {
            maxCount[0]++;
        }

        preorder(root.left, freq, max, maxCount);
        preorder(root.right, freq, max, maxCount);
    }

    public int[] findMode(TreeNode root) {
        int[] max = new int[1];         // Array to store max frequency
        int[] maxCount = new int[1];    // Count of numbers having max frequency
        max[0] = -1;
        maxCount[0] = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        preorder(root, freq, max, maxCount);

        int[] result = new int[maxCount[0]];
        int i = 0;

        for (int key : freq.keySet()) {
            if (freq.get(key) == max[0]) {
                result[i++] = key;
            }
        }

        return result;
    }
}
```
