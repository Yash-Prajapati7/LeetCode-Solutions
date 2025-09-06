Leetcode Question : [Minimum Operations to Make Array Elements Zero](https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero)

## Approach - 1 (Brute Force)

### Java

```java
class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int[] query : queries) {
            for(int i = query[0]; i <= query[1]; i++) {
                pq.offer(i);
            }

            while(pq.peek() != 0) {
                int num1 = pq.poll();
                int num2 = pq.poll();
                pq.offer(num1 / 4);
                pq.offer(num2 / 4);
                ans++;
            }
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
    long long minOperations(vector<vector<int>>& queries) {
        long long ans = 0;
        priority_queue<int> pq;
        for(auto& query : queries) {
            for(int i = query[0]; i <= query[1]; i++) {
                pq.push(i);
            }

            while(pq.top() != 0) {
                int num1 = pq.top(); pq.pop();
                int num2 = pq.top(); pq.pop();
                pq.push(num1 / 4);
                pq.push(num2 / 4);
                ans++;
            }
        }
        return ans;
    }
};
```

## Approach - 2 (Math Optimised)

### Java

```java
class Solution {
    private long getCount(int num) {
        long count = 0;
        int i = 1, base = 1, end = 0;

        while(base <= num) {
            end = Math.min((base << 1) - 1, num);
            count += (long)(((i + 1) >> 1)) * (end - base + 1);
            i++;
            base <<= 1;
        }

        return count;
    }
    public long minOperations(int[][] queries) {
        long result = 0;
        for(int[] q : queries) {
            long count1 = getCount(q[0] - 1);    // calculate [1, l - 1]
            long count2 = getCount(q[1]);    // calculate [1, r]
            result += ((count2 - count1 + 1) >> 1);
        }
        return result;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    long long getCount(int num) {
        long long count = 0;
        int i = 1, base = 1, end = 0;

        while(base <= num) {
            end = min((base << 1) - 1, num);
            count += (long long)(((i + 1) >> 1)) * (end - base + 1);
            i++;
            base <<= 1;
        }
        return count;
    }
public:
    long long minOperations(vector<vector<int>>& queries) {
        long long result = 0;
        for(auto& q : queries) {
            long long count1 = getCount(q[0] - 1);    // calculate [1, l - 1]
            long long count2 = getCount(q[1]);        // calculate [1, r]
            result += ((count2 - count1 + 1) >> 1);
        }
        return result;
    }
};
```
