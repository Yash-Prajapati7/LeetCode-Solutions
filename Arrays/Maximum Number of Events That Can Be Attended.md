Leetcode Question : [Maximum Number of Events That Can Be Attended](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/)
- Note<br>
**Use Method - 1 when the end day is large, in 10^9's.**<br>
**Use Method - 2 for normal constraints, it's faster if paired with path compression.**

## Method - 1 (Using Priority Queue)

### Java

```java
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 0, i = 0, n = events.length, attended = 0;

        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                day = events[i][0];
            }

            while (i < n && events[i][0] <= day) {
                pq.offer(events[i][1]);
                i++;
            }

            pq.poll(); // Attend the event with the earliest end date
            attended++;
            day++;

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll(); // Remove expired events
            }
        }

        return attended;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        sort(events.begin(), events.end());

        priority_queue<int, vector<int>, greater<int>> pq;
        int day = 0, i = 0, n = events.size(), attended = 0;

        while (i < n || !pq.empty()) {
            if (pq.empty()) {
                day = events[i][0];
            }

            while (i < n && events[i][0] <= day) {
                pq.push(events[i][1]);
                i++;
            }

            pq.pop(); // Attend the event with the earliest end date
            attended++;
            day++;

            while (!pq.empty() && pq.top() < day) {
                pq.pop(); // Remove expired events
            }
        }

        return attended;
    }
};
```

## Method - 2 (Using Disjoint Set Union)

### Java

```java
class Solution {
    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    public int maxEvents(int[][] events) {
        int n = events.length;
        if(n == 0) return 0;

        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int[] parent = new int[events[n - 1][1] + 2];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int attended = 0;
        for(int[] event : events) {
            int availableSlot = find(parent, event[0]);
            if(availableSlot <= event[1]) {
                attended++;
                parent[availableSlot] = find(parent, availableSlot + 1);
            }
        }

        return attended;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int find(vector<int>& parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

public:
    int maxEvents(vector<vector<int>>& events) {
        int n = events.size();
        if (n == 0) return 0;

        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });

        int maxDay = 0;
        for (auto& event : events) {
            maxDay = max(maxDay, event[1]);
        }

        vector<int> parent(maxDay + 2);
        for (int i = 0; i <= maxDay + 1; ++i) {
            parent[i] = i;
        }

        int attended = 0;
        for (auto& event : events) {
            int availableSlot = find(parent, event[0]);
            if (availableSlot <= event[1]) {
                attended++;
                parent[availableSlot] = find(parent, availableSlot + 1);
            }
        }

        return attended;
    }
};
```
