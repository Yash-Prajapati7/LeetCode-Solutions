Leetcode Question : [Total Waviness of Numbers in Range I](https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/)

## Approach - 1 (Brute Force)

### Java

```java
class Solution {
    public int totalWaviness(int num1, int num2) {
        if(num1 <= 100 && num2 <= 100) {
            return 0;
        }

        String s;
        int count = 0;
        for(int num = num1; num <= num2; num++) {
            s = String.valueOf(num);

            for(int i = 1; i < s.length() - 1; i++) {
                if((s.charAt(i) > s.charAt(i - 1) && s.charAt(i) > s.charAt(i + 1)) || (s.charAt(i) < s.charAt(i - 1) && s.charAt(i) < s.charAt(i + 1))) {
                    count++;
                }
            }
        }

        return count;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int totalWaviness(int num1, int num2) {
        if (num1 <= 100 && num2 <= 100) {
            return 0;
        }

        string s;
        int count = 0;

        for (int num = num1; num <= num2; num++) {
            s = to_string(num);

            for (int i = 1; i < s.length() - 1; i++) {
                if ((s[i] > s[i - 1] && s[i] > s[i + 1]) ||
                    (s[i] < s[i - 1] && s[i] < s[i + 1])) {
                    count++;
                }
            }
        }

        return count;
    }
};
```

## Approach - 2 (Digit DP)

### Java

```java
class Solution {

    private String s;
    private int n;
    private long[][][] memo_cnt;
    private long[][][] memo_sum;

    public int totalWaviness(int num1, int num2) {
        return (int) (solve(num2) - solve(num1 - 1));
    }

    private long solve(long num) {
        if (num < 100) {
            return 0L;
        }

        s = Long.toString(num);
        n = s.length();

        memo_cnt = new long[16][10][10];
        memo_sum = new long[16][10][10];

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(memo_cnt[i][j], -1);
                Arrays.fill(memo_sum[i][j], -1);
            }
        }

        long[] result = dfs(0, -1, -1, true, true);
        return result[1];
    }

    private long[] dfs(
        int pos,
        int prev,
        int curr,
        boolean isLimit,
        boolean isLeading
    ) {
        if (pos == n) {
            return new long[] { 1L, 0L };
        }

        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            if (memo_cnt[pos][prev][curr] != -1) {
                return new long[] {
                    memo_cnt[pos][prev][curr],
                    memo_sum[pos][prev][curr],
                };
            }
        }

        long cnt = 0;
        long sum = 0;
        int up = isLimit ? (s.charAt(pos) - '0') : 9;

        for (int digit = 0; digit <= up; ++digit) {
            boolean newLeading = isLeading && (digit == 0);

            int newPrev = curr;
            int newCurr = newLeading ? -1 : digit;

            long[] sub = dfs(
                pos + 1,
                newPrev,
                newCurr,
                isLimit && (digit == up),
                newLeading
            );

            long subCnt = sub[0];
            long subSum = sub[1];

            if (!newLeading && prev >= 0 && curr >= 0) {
                if (
                    (prev < curr && curr > digit) ||
                    (prev > curr && curr < digit)
                ) {
                    sum += subCnt;
                }
            }

            cnt += subCnt;
            sum += subSum;
        }

        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            memo_cnt[pos][prev][curr] = cnt;
            memo_sum[pos][prev][curr] = sum;
        }

        return new long[] { cnt, sum };
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    string s;
    int n;
    long long memoCnt[16][10][10];
    long long memoSum[16][10][10];

public:
    int totalWaviness(int num1, int num2) {
        return (int)(solve(num2) - solve((long long)num1 - 1));
    }

    long long solve(long long num) {
        if (num < 100) {
            return 0LL;
        }

        s = to_string(num);
        n = s.length();

        memset(memoCnt, -1, sizeof(memoCnt));
        memset(memoSum, -1, sizeof(memoSum));

        vector<long long> result = dfs(0, -1, -1, true, true);

        return result[1];
    }

    vector<long long> dfs(
        int pos,
        int prev,
        int curr,
        bool isLimit,
        bool isLeading
    ) {
        if (pos == n) {
            return {1LL, 0LL};
        }

        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            if (memoCnt[pos][prev][curr] != -1) {
                return {
                    memoCnt[pos][prev][curr],
                    memoSum[pos][prev][curr]
                };
            }
        }

        long long cnt = 0;
        long long sum = 0;

        int up = isLimit ? (s[pos] - '0') : 9;

        for (int digit = 0; digit <= up; digit++) {
            bool newLeading = isLeading && (digit == 0);

            int newPrev = curr;
            int newCurr = newLeading ? -1 : digit;

            vector<long long> sub = dfs(
                pos + 1,
                newPrev,
                newCurr,
                isLimit && (digit == up),
                newLeading
            );

            long long subCnt = sub[0];
            long long subSum = sub[1];

            if (!newLeading && prev >= 0 && curr >= 0) {
                if (
                    (prev < curr && curr > digit) ||
                    (prev > curr && curr < digit)
                ) {
                    sum += subCnt;
                }
            }

            cnt += subCnt;
            sum += subSum;
        }

        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            memoCnt[pos][prev][curr] = cnt;
            memoSum[pos][prev][curr] = sum;
        }

        return {cnt, sum};
    }
};
```
