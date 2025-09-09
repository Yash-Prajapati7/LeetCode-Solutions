Leetcode Question : [Number of People Aware of a Secret](https://leetcode.com/problems/number-of-people-aware-of-a-secret)

### Java

```java
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        Deque<int[]> knows = new LinkedList<>();
        Deque<int[]> share = new LinkedList<>();
        int knowCount = 1, shareCount = 0;
        int[] first;

        knows.offer(new int[] {1, 1}); // Add the first person that knows the secret
        for(int i = 2; i <= n; i++) {
            // if any people are allowed to share the secret, add them to share deque
            if(!knows.isEmpty() && knows.peekFirst()[0] == i - delay) {
                first = knows.pollFirst();
                knowCount = (knowCount - first[1] + mod) % mod;
                shareCount = (shareCount + first[1]) % mod;
                share.offer(first);
            }

            // if its day of forget
            if(!share.isEmpty() && share.peekFirst()[0] == i - forget) {
                first = share.pollFirst();
                shareCount = (shareCount - first[1] + mod) % mod;
            }

            // people who can share today spread the secret to new people
            if(!share.isEmpty()) {
                knowCount = (knowCount + shareCount) % mod;
                knows.offer(new int[]{ i, shareCount });
            }
        }

        return (knowCount + shareCount) % mod;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        deque<pair<int,int>> knows;
        deque<pair<int,int>> share;
        int knowCount = 1, shareCount = 0;
        pair<int,int> first;

        knows.push_back({1, 1}); // Add the first person that knows the secret
        for(int i = 2; i <= n; i++) {
            // if any people are allowed to share the secret, add them to share deque
            if(!knows.empty() && knows.front().first == i - delay) {
                first = knows.front();
                knows.pop_front();
                knowCount = (knowCount - first.second + mod) % mod;
                shareCount = (shareCount + first.second) % mod;
                share.push_back(first);
            }

            // if its day of forget
            if(!share.empty() && share.front().first == i - forget) {
                first = share.front();
                share.pop_front();
                shareCount = (shareCount - first.second + mod) % mod;
            }

            // people who can share today spread the secret to new people
            if(!share.empty()) {
                knowCount = (knowCount + shareCount) % mod;
                knows.push_back({ i, shareCount });
            }
        }

        return (knowCount + shareCount) % mod;
    }
};
```
