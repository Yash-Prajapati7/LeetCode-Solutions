Leetcode Question: [Longest Happy String](https://leetcode.com/problems/longest-happy-string/)

### Java
```java
class Solution {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) ->
            (y.count - x.count)
        );
        // Add the counts of a, b and c in priority queue.
        if (a > 0) {
            pq.add(new Pair(a, 'a'));
        }

        if (b > 0) {
            pq.add(new Pair(b, 'b'));
        }

        if (c > 0) {
            pq.add(new Pair(c, 'c'));
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int count = p.count;
            char character = p.character;
            // If three consecutive characters exist, pick the second most
            // frequent character.
            if (
                ans.length() >= 2 &&
                ans.charAt(ans.length() - 1) == p.character &&
                ans.charAt(ans.length() - 2) == p.character
            ) {
                if (pq.isEmpty()) break;

                Pair temp = pq.poll();
                ans.append(temp.character);
                if (temp.count - 1 > 0) {
                    pq.add(new Pair(temp.count - 1, temp.character));
                }
            } else {
                count--;
                ans.append(character);
            }

            // If count is greater than zero, add it to priority queue.
            if (count > 0) {
                pq.add(new Pair(count, character));
            }
        }
        return ans.toString();
    }

    class Pair {

        int count;
        char character;

        Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
    }
}
```

### C++
```cpp
class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        priority_queue<pair<int, char>> pq;
        if (a > 0) pq.push({a, 'a'});
        if (b > 0) pq.push({b, 'b'});
        if (c > 0) pq.push({c, 'c'});

        string ans;
        while (!pq.empty()) {
            auto p = pq.top();
            pq.pop();
            int count = p.first;
            char character = p.second;

            if (ans.size() >= 2 && ans.back() == character && ans[ans.size() - 2] == character) {
                if (pq.empty()) break;

                auto temp = pq.top();
                pq.pop();
                ans += temp.second;
                if (temp.first - 1 > 0) pq.push({temp.first - 1, temp.second});
            } else {
                count--;
                ans += character;
            }

            if (count > 0) pq.push({count, character});
        }
        return ans;
    }
};
```
