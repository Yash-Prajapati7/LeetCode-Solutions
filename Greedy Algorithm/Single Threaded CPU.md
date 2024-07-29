Leetcode Question : [Single Threaded CPU](https://leetcode.com/problems/single-threaded-cpu/)
```java
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] taskArray = new int[n][3];
        for (int i = 0; i < n; i++) {
            taskArray[i][0] = tasks[i][0];
            taskArray[i][1] = tasks[i][1];
            taskArray[i][2] = i;
        }

        // Sort taskArray based on the enqueueTime
        Arrays.sort(taskArray, Comparator.comparingInt(a -> a[0]));

        // Priority queue to store tasks based on processing time and index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            a[1] == b[1] ? Integer.compare(a[2], b[2]) : Integer.compare(a[1], b[1])
        );

        int[] result = new int[n];
        int index = 0, time = 0, i = 0;

        while (index < n) {
            // Adjust the current time if the queue is empty and the next task is in the future
            if (pq.isEmpty() && time < taskArray[i][0]) {
                time = taskArray[i][0];
            }

            // Add all tasks that can start at the current time to the priority queue
            while (i < n && taskArray[i][0] <= time) {
                pq.add(taskArray[i]);
                i++;
            }

            // Poll the next task from the priority queue
            int[] task = pq.poll();
            result[index++] = task[2];
            time += task[1];
        }

        return result;
    }
}
```
