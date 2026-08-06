Leetcode Question : [Count Mentions Per User](https://leetcode.com/problems/count-mentions-per-user)

### Java

```java
class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // Sort by timestamp, and process OFFLINE before MESSAGE if timestamps are equal
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 != t2) {
                return Integer.compare(t1, t2);
            }

            if (a.get(0).equals(b.get(0))) {
                return 0;
            }

            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        int[] mentions = new int[numberOfUsers];

        final String MESSAGE = "MESSAGE";
        final String OFFLINE = "OFFLINE";
        final String ALL = "ALL";
        final String HERE = "HERE";

        // user -> timestamp when they come back online
        HashMap<Integer, Integer> offlineIds = new HashMap<>();

        for (List<String> event : events) {
            int currentTimestamp = Integer.parseInt(event.get(1));

            // Remove users whose offline duration has ended
            Iterator<Map.Entry<Integer, Integer>> it = offlineIds.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue() <= currentTimestamp) {
                    it.remove();
                }
            }

            if (MESSAGE.equals(event.get(0))) {

                if (HERE.equals(event.get(2))) {

                    for (int i = 0; i < numberOfUsers; i++) {
                        if (!offlineIds.containsKey(i)) {
                            mentions[i]++;
                        }
                    }

                } else if (ALL.equals(event.get(2))) {

                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }

                } else {

                    int[] ids = Arrays.stream(event.get(2).split(" "))
                                      .mapToInt(s -> Integer.parseInt(s.substring(2)))
                                      .toArray();

                    // Explicit id mentions count even if user is offline
                    for (int id : ids) {
                        mentions[id]++;
                    }
                }

            } else if (OFFLINE.equals(event.get(0))) {

                int id = Integer.parseInt(event.get(2));
                offlineIds.put(id, currentTimestamp + 60);
            }
        }

        return mentions;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> countMentions(int numberOfUsers, vector<vector<string>>& events) {
        // Sort by timestamp, and process OFFLINE before MESSAGE if timestamps are equal
        sort(events.begin(), events.end(), [](const vector<string>& a, const vector<string>& b) {
            int t1 = stoi(a[1]);
            int t2 = stoi(b[1]);

            if (t1 != t2) {
                return t1 < t2;
            }

            if (a[0] == b[0]) {
                return false;
            }

            return a[0] == "OFFLINE";
        });

        vector<int> mentions(numberOfUsers, 0);

        unordered_map<int, int> offlineIds;

        for (auto& event : events) {
            int currentTimestamp = stoi(event[1]);

            // Remove users whose offline duration has ended
            vector<int> toRemove;
            for (auto& [id, time] : offlineIds) {
                if (time <= currentTimestamp) {
                    toRemove.push_back(id);
                }
            }
            for (int id : toRemove) {
                offlineIds.erase(id);
            }

            if (event[0] == "MESSAGE") {

                if (event[2] == "HERE") {

                    for (int i = 0; i < numberOfUsers; i++) {
                        if (!offlineIds.count(i)) {
                            mentions[i]++;
                        }
                    }

                } else if (event[2] == "ALL") {

                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }

                } else {

                    stringstream ss(event[2]);
                    string token;

                    while (ss >> token) {
                        int id = stoi(token.substr(2));
                        mentions[id]++;
                    }
                }

            } else { // OFFLINE

                int id = stoi(event[2]);
                offlineIds[id] = currentTimestamp + 60;
            }
        }

        return mentions;
    }
}
```
