Leetcode Question : [Implement Router](https://leetcode.com/problems/implement-router)

### Java

```java
class Router {
    private int limit;
    private Queue<int[]> q;
    private Set<String> history;
    private Map<Integer, List<Integer>> destMap;

    private String generateHash(int src, int dest, int time) {
        return src + "#" + dest + "#" + time;
    }

    public Router(int memoryLimit) {
        this.limit = memoryLimit;
        this.q = new LinkedList<>();
        this.history = new HashSet<>();
        this.destMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = generateHash(source, destination, timestamp);
        if (history.contains(key)) return false; // duplicate

        // If memory full, evict oldest
        if (q.size() == limit) {
            int[] old = q.poll();
            String oldKey = generateHash(old[0], old[1], old[2]);
            history.remove(oldKey);

            // remove timestamp from destMap
            List<Integer> lst = destMap.get(old[1]);
            int idx = Collections.binarySearch(lst, old[2]);
            if (idx >= 0) lst.remove(idx);
            if (lst.isEmpty()) destMap.remove(old[1]);
        }

        // Add packet
        q.offer(new int[]{source, destination, timestamp});
        history.add(key);

        destMap.putIfAbsent(destination, new ArrayList<>());
        destMap.get(destination).add(timestamp); // always increasing
        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[]{};
        int[] packet = q.poll();
        String key = generateHash(packet[0], packet[1], packet[2]);
        history.remove(key);

        // remove timestamp from list
        List<Integer> lst = destMap.get(packet[1]);
        int idx = Collections.binarySearch(lst, packet[2]);
        if (idx >= 0) lst.remove(idx);
        if (lst.isEmpty()) destMap.remove(packet[1]);

        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;
        List<Integer> lst = destMap.get(destination);

        int left = lowerBound(lst, startTime);
        int right = upperBound(lst, endTime);
        return right - left;
    }

    private int lowerBound(List<Integer> lst, int target) {
        int l = 0, r = lst.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (lst.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int upperBound(List<Integer> lst, int target) {
        int l = 0, r = lst.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (lst.get(mid) > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Router {
private:
    int limit;
    queue<array<int,3>> q;
    unordered_set<string> history;
    unordered_map<int, vector<int>> destMap;

    string generateHash(int src, int dest, int time) {
        return to_string(src) + "#" + to_string(dest) + "#" + to_string(time);
    }

    int lowerBound(vector<int>& lst, int target) {
        int l = 0, r = lst.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (lst[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    int upperBound(vector<int>& lst, int target) {
        int l = 0, r = lst.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (lst[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

public:
    Router(int memoryLimit) {
        limit = memoryLimit;
    }

    bool addPacket(int source, int destination, int timestamp) {
        string key = generateHash(source, destination, timestamp);
        if (history.count(key)) return false; // duplicate

        if ((int)q.size() == limit) {
            auto old = q.front(); q.pop();
            string oldKey = generateHash(old[0], old[1], old[2]);
            history.erase(oldKey);

            auto &lst = destMap[old[1]];
            auto it = lower_bound(lst.begin(), lst.end(), old[2]);
            if (it != lst.end() && *it == old[2]) lst.erase(it);
            if (lst.empty()) destMap.erase(old[1]);
        }

        q.push({source, destination, timestamp});
        history.insert(key);

        destMap[destination].push_back(timestamp);
        return true;
    }

    vector<int> forwardPacket() {
        if (q.empty()) return {};
        auto packet = q.front(); q.pop();
        string key = generateHash(packet[0], packet[1], packet[2]);
        history.erase(key);

        auto &lst = destMap[packet[1]];
        auto it = lower_bound(lst.begin(), lst.end(), packet[2]);
        if (it != lst.end() && *it == packet[2]) lst.erase(it);
        if (lst.empty()) destMap.erase(packet[1]);

        return {packet[0], packet[1], packet[2]};
    }

    int getCount(int destination, int startTime, int endTime) {
        if (!destMap.count(destination)) return 0;
        auto &lst = destMap[destination];
        int left = lowerBound(lst, startTime);
        int right = upperBound(lst, endTime);
        return right - left;
    }
};
```
