### Leetcode Question : [Unique 3-Digit Even Numbers](https://leetcode.com/problems/unique-3-digit-even-numbers/)

### Java

```java
class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        boolean[] visited = new boolean[1000];
        int num = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (digits[i] != 0) {
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        for (int k = 0; k < n; k++) {
                            if ((k != j) && (k != i) && (digits[k] % 2 == 0)) {
                                num = digits[i] * 100 + digits[j] * 10 + digits[k];
                                if (!visited[num]) {
                                    visited[num] = true;
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}
```

### C++

```cpp
using namespace std;

class Solution {
public:
    int totalNumbers(vector<int>& digits) {
        int n = digits.size();
        vector<bool> visited(1000, false);
        int num = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (digits[i] != 0) {
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        for (int k = 0; k < n; k++) {
                            if ((k != j) && (k != i) && (digits[k] % 2 == 0)) {
                                num = digits[i] * 100 + digits[j] * 10 + digits[k];
                                if (!visited[num]) {
                                    visited[num] = true;
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
};
```
