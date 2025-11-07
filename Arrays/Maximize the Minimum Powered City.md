Leetcode Question : [Maximize the Minimum Powered City](https://leetcode.com/problems/maximize-the-minimum-powered-city/)

### Java

```java
class Solution {
    private boolean check(long[] sweep, long mid, int r, int k) {
        int n = sweep.length - 1;
        long[] diff = sweep.clone();
        long sum = 0;

        for(int i = 0; i < n; i++) {
            sum += diff[i];
            if(sum < mid) {
                long stationsToAdd = mid - sum;
                if(stationsToAdd > k) {
                    return false;
                }

                k -= stationsToAdd;
                int end = (i + (r << 1) + 1) > n ? n : (i + (r << 1) + 1);
                diff[end] -= stationsToAdd;
                sum += stationsToAdd;
            }
        }

        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] sweep = new long[n + 1];
        int start = 0, end = n;

        long low = Integer.MAX_VALUE, high = 0;

        for(int i = 0; i < n; i++) {
            start = (i - r) < 0 ? 0 : (i - r);
            end = (i + r + 1) > n ? n : (i + r + 1);
            sweep[start] += stations[i];
            sweep[end] -= stations[i];

            low = stations[i] < low ? stations[i] : low;
            high += stations[i];
        }

        high += k;
        long mid = 0;
        long result = 0;

        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(check(sweep, mid, r, k)) {
                result = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
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
    bool check(vector<long long>& sweep, long long mid, int r, long long k) {
        int n = sweep.size() - 1;
        vector<long long> diff = sweep;
        long long sum = 0;

        for(int i = 0; i < n; i++) {
            sum += diff[i];
            if(sum < mid) {
                long long stationsToAdd = mid - sum;
                if(stationsToAdd > k) {
                    return false;
                }

                k -= stationsToAdd;
                int end = (i + (r << 1) + 1) > n ? n : (i + (r << 1) + 1);
                diff[end] -= stationsToAdd;
                sum += stationsToAdd;
            }
        }

        return true;
    }

public:
    long long maxPower(vector<int>& stations, int r, int k) {
        int n = stations.size();
        vector<long long> sweep(n + 1, 0);
        int start = 0, end = n;

        long long low = LLONG_MAX, high = 0;

        for(int i = 0; i < n; i++) {
            start = (i - r) < 0 ? 0 : (i - r);
            end = (i + r + 1) > n ? n : (i + r + 1);
            sweep[start] += stations[i];
            sweep[end] -= stations[i];

            low = min<long long>(low, stations[i]);
            high += stations[i];
        }

        high += k;
        long long mid = 0;
        long long result = 0;

        while(low <= high) {
            mid = low + ((high - low) >> 1);
            if(check(sweep, mid, r, k)) {
                result = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return result;
    }
};
```
