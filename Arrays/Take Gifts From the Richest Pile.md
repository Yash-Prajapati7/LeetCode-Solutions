Leetcode Question : [Take Gifts From the Richest Pile](https://leetcode.com/problems/take-gifts-from-the-richest-pile/)

### Java
```java
class Solution {
    private int sqrt(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int ans = 0, left = 0, right = num, mid = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (mid <= num / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max-heap
        long total = 0;

        for (int gift : gifts) {
            total += gift;
            pq.offer(gift);
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int temp = pq.poll(); // Get the pile with maximum gifts
            int sqrtFloor = sqrt(temp); // Calculate the floor of the square root
            pq.offer(sqrtFloor);
            total = total - temp + sqrtFloor;
        }

        return total;
    }
}
```

### C++
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int sqrt(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int ans = 0, left = 0, right = num, mid = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (mid <= num / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

public:
    long long pickGifts(vector<int>& gifts, int k) {
        priority_queue<int> pq; // Max-heap
        long long total = 0;

        for (int gift : gifts) {
            total += gift;
            pq.push(gift);
        }

        while (k-- > 0 && !pq.empty()) {
            int temp = pq.top(); // Get the pile with maximum gifts
            pq.pop();
            int sqrtFloor = sqrt(temp); // Calculate the floor of the square root
            pq.push(sqrtFloor);
            total = total - temp + sqrtFloor;
        }

        return total;
    }
};
```
