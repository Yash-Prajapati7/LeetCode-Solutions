Leetcode Question : [Detonate the Maximum Bombs](https://leetcode.com/problems/detonate-the-maximum-bombs/)  
### Java
```java
class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        if (n == 1) return 1;

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    long dx = bombs[i][0] - bombs[j][0];
                    long dy = bombs[i][1] - bombs[j][1];
                    long r = bombs[i][2];
                    if (dx * dx + dy * dy <= r * r) {
                        adj.get(i).add(j);
                    }
                }
            }
        }

        // BFS for each starting bomb
        int maxDetonated = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            int detonated = 1;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : adj.get(current)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                        detonated++;
                    }
                }
            }
            maxDetonated = maxDetonated < detonated ? detonated : maxDetonated;
        }

        return maxDetonated;
    }
}
```
