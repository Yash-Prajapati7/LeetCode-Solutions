Leetcode Question : [Relative Ranks](https://leetcode.com/problems/relative-ranks/)  

### Java  
```java
class Solution {
    class Ranks {
        int rank, index;
        Ranks(int rank, int idx) {
            this.rank = rank;
            this.index = idx;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Ranks> pq = new PriorityQueue<>((a, b) -> b.rank - a.rank);
        int n = score.length;

        for (int i = 0; i < n; i++) {
            pq.offer(new Ranks(score[i], i));
        }

        String[] ranks = new String[n];
        String[] tops = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        int position = 0;
        while (!pq.isEmpty() && position < 3) {
            Ranks r = pq.poll();
            ranks[r.index] = tops[position++];
        }

        while (!pq.isEmpty()) {
            Ranks r = pq.poll();
            ranks[r.index] = to_string(position + 1);
            position++;
        }

        return ranks;
    }
}
```  

### C++  
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
    struct Ranks {
        int rank, index;
        Ranks(int r, int i) : rank(r), index(i) {}
    };

public:
    vector<string> findRelativeRanks(vector<int>& score) {
        priority_queue<Ranks, vector<Ranks>, function<bool(Ranks, Ranks)>> pq(
            [](Ranks a, Ranks b) { return a.rank < b.rank; });

        int n = score.size();
        for (int i = 0; i < n; i++) {
            pq.push(Ranks(score[i], i));
        }

        vector<string> ranks(n);
        vector<string> tops = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        int position = 0;
        while (!pq.empty() && position < 3) {
            Ranks r = pq.top();
            pq.pop();
            ranks[r.index] = tops[position++];
        }

        while (!pq.empty()) {
            Ranks r = pq.top();
            pq.pop();
            ranks[r.index] = to_string(position + 1);
            position++;
        }

        return ranks;
    }
};
```
