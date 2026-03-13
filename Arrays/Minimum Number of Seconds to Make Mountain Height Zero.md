Leetcode Question : [Minimum Number of Seconds to Make Mountain Height Zero](https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero)

### Java

```java
import java.util.*;

class Solution {

    class Worker {
        long finishTime;
        int workerTime;
        int k;

        Worker(long finishTime, int workerTime, int k) {
            this.finishTime = finishTime;
            this.workerTime = workerTime;
            this.k = k;
        }
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        PriorityQueue<Worker> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.finishTime, b.finishTime)
        );

        for (int t : workerTimes) {
            pq.add(new Worker(t, t, 1));
        }

        long ans = 0;

        for (int i = 0; i < mountainHeight; i++) {
            Worker w = pq.poll();
            ans = w.finishTime;

            int nextK = w.k + 1;
            long nextFinish = w.finishTime + (long) nextK * w.workerTime;

            pq.add(new Worker(nextFinish, w.workerTime, nextK));
        }

        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    class Worker {
    public:
        long long finishTime;
        int workerTime;
        int k;

        Worker(long long finishTime, int workerTime, int k) {
            this->finishTime = finishTime;
            this->workerTime = workerTime;
            this->k = k;
        }
    };

    struct cmp {
        bool operator()(Worker* a, Worker* b) {
            return a->finishTime > b->finishTime;
        }
    };

    long long minNumberOfSeconds(int mountainHeight, vector<int>& workerTimes) {

        priority_queue<Worker*, vector<Worker*>, cmp> pq;

        for (int t : workerTimes) {
            pq.push(new Worker(t, t, 1));
        }

        long long ans = 0;

        for (int i = 0; i < mountainHeight; i++) {
            Worker* w = pq.top();
            pq.pop();

            ans = w->finishTime;

            int nextK = w->k + 1;
            long long nextFinish = w->finishTime + (long long) nextK * w->workerTime;

            pq.push(new Worker(nextFinish, w->workerTime, nextK));
        }

        return ans;
    }
};
```
