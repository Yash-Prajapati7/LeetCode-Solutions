Leetcode Question : [Jumps Game III](https://leetcode.com/problems/jump-game-iii/)
## Brute Force Approach
```java
class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length;
        int[] visited = new int[n];  // array to keep track of visited indices
        q.offer(start);

        while(!q.isEmpty()) {
            int index = q.poll();
            if(visited[index] == 1) {
                continue;
            }
            visited[index] = 1;
            if(arr[index] == 0) {
                return true;
            }
            if(index + arr[index] < n) {
                q.offer(index + arr[index]);
            }
            if(index - arr[index] >= 0) {
                q.offer(index - arr[index]);
            }
        }

        return false;
    }
}
```
## Optimised Approach
```java
class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length;
        q.offer(start);
        
        while (!q.isEmpty()) {
            int index = q.poll();
            if (arr[index] < 0) {
                continue;
            }
            if (arr[index] == 0) {
                return true;
            }
            if (index + arr[index] < n) {
                q.offer(index + arr[index]);
            }
            if (index - arr[index] >= 0) {
                q.offer(index - arr[index]);
            }
            // Mark the index as visited by setting it to a negative value
            arr[index] = -arr[index];
        }
        return false;
    }
}
```
