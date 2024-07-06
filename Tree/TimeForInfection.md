Leetcode Question : https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
## Approach - 1
```java
class Solution {
    private int getTime(Map<TreeNode, TreeNode> parentMap, TreeNode startNode) {
        int time = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        queue.offer(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spread = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null && !visited.contains(node.left)) {
                    spread = true;
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                
                if (node.right != null && !visited.contains(node.right)) {
                    spread = true;
                    visited.add(node.right);
                    queue.offer(node.right);
                }

                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    spread = true;
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
            
            if (spread) {
                time++;
            }
        }

        return time;
    }

    private TreeNode getStartNode(TreeNode root, Map<TreeNode, TreeNode> parentMap, int start) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode startNode = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == start) {
                startNode = node;
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        return startNode;
    }

    public int amountOfTime(TreeNode root, int start) {
        // Create a hashmap to keep track of nodes and their parent
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        // Call the getStartNode method to get the starting node, as we are provided with its value rather than the node itself
        TreeNode startNode = getStartNode(root, parentMap, start);
        // Call the getTime method which will return the time and return whatever the method returns
        return getTime(parentMap, startNode);
    }
}
```

## Approach - 2
```java
class Solution {
    private int maxTime = 0;

    public int amountOfTime(TreeNode root, int start) {
        traverse(root, start);
        return maxTime;
    }

    public int traverse(TreeNode root, int start) {
        int distance = 0;
        if (root == null) {
            return distance;
        }

        int leftTime = traverse(root.left, start);
        int rightTime = traverse(root.right, start);

        if (root.val == start) {
            maxTime = Math.max(leftTime, rightTime);
            distance = -1;
        } else if (leftTime >= 0 && rightTime >= 0) {
            distance = Math.max(leftTime, rightTime) + 1;
        } else {
            int depth = Math.abs(leftTime) + Math.abs(rightTime);
            maxTime = Math.max(maxTime, depth);
            distance = Math.min(leftTime, rightTime) - 1;
        }

        return distance;
    }
}
```
