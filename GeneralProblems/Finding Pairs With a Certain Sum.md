Leetcode Question : [Finding Pairs With a Certain Sum](https://leetcode.com/problems/finding-pairs-with-a-certain-sum/)

### Java

```java
class FindSumPairs {

    private int[] n1;
    private int[] n2;
    private Map<Integer, Integer> count;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.n1 = nums1;
        this.n2 = nums2;
        this.count = new HashMap<>();
        for (int num : n2) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = n2[index];
        count.put(oldVal, count.get(oldVal) - 1);
        n2[index] += val;
        count.put(n2[index], count.getOrDefault(n2[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int num : n1) {
            int rest = tot - num;
            ans += count.getOrDefault(rest, 0);
        }
        return ans;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class FindSumPairs {
private:
    vector<int> n1;
    vector<int> n2;
    unordered_map<int, int> count;

public:
    FindSumPairs(vector<int>& nums1, vector<int>& nums2) {
        n1 = nums1;
        n2 = nums2;
        for (int num : n2) {
            count[num]++;
        }
    }

    void add(int index, int val) {
        int oldVal = n2[index];
        count[oldVal]--;
        n2[index] += val;
        count[n2[index]]++;
    }

    int countSum(int tot) {
        int ans = 0;
        for (int num : n1) {
            int rest = tot - num;
            if (count.find(rest) != count.end()) {
                ans += count[rest];
            }
        }
        return ans;
    }
};
```
