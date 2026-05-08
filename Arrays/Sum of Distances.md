Leetcode Question : [Sum of Distances](https://leetcode.com/problems/sum-of-distances/)

## Approach - 1 (Brute Force)

### Java

```java
class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        long[] ans = new long[n];

        for(int i = 0; i < n; i++) {
            ArrayList<Integer> indices = map.get(nums[i]);
            long sum = 0;

            for(int index : indices) {
                sum += ((i > index) ? i - index : index - i);
            }

            ans[i] = sum;
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
    vector<long long> distance(vector<int>& nums) {
        unordered_map<int, vector<int>> indexGroups;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            indexGroups[nums[i]].push_back(i);
        }

        vector<long long> answer(n);

        for (int i = 0; i < n; i++) {
            vector<int>& indices = indexGroups[nums[i]];
            long long totalDistance = 0;

            for (int index : indices) {
                totalDistance += abs(i - index);
            }

            answer[i] = totalDistance;
        }

        return answer;
    }
};
```

## Approach - 2 (Optimised)

### Java

```java
class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> indexGroups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!indexGroups.containsKey(nums[i])) {
                indexGroups.put(nums[i], new ArrayList<>());
            }

            indexGroups.get(nums[i]).add(i);
        }

        long[] answer = new long[n];

        for (ArrayList<Integer> indices : indexGroups.values()) {
            long totalIndexSum = 0;

            for (int index : indices) {
                totalIndexSum += index;
            }

            long leftSideSum = 0;
            int groupSize = indices.size();

            for (int i = 0; i < groupSize; i++) {
                int currentIndex = indices.get(i);

                long currentDistance =
                        totalIndexSum
                        - (2 * leftSideSum)
                        + (long) currentIndex * ((2 * i) - groupSize);

                answer[currentIndex] = currentDistance;

                leftSideSum += currentIndex;
            }
        }

        return answer;
    }
}
```

### C++

```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<long long> distance(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, vector<int>> indexGroups;

        for (int i = 0; i < n; i++) {
            indexGroups[nums[i]].push_back(i);
        }

        vector<long long> answer(n);

        for (auto& entry : indexGroups) {
            vector<int>& indices = entry.second;

            long long totalIndexSum = 0;

            for (int index : indices) {
                totalIndexSum += index;
            }

            long long leftSideSum = 0;
            int groupSize = indices.size();

            for (int i = 0; i < groupSize; i++) {
                int currentIndex = indices[i];

                long long currentDistance =
                        totalIndexSum
                        - (2LL * leftSideSum)
                        + 1LL * currentIndex * ((2 * i) - groupSize);

                answer[currentIndex] = currentDistance;

                leftSideSum += currentIndex;
            }
        }

        return answer;
    }
};
```

## Explanation

### Idea

Instead of calculating distances one-by-one repeatedly, the optimized approach groups all indices having the same value and processes them together.

It uses:

* Prefix sums
* Mathematical simplification

to compute the distance for every index in linear time.

---

### Formula Used

Suppose the indices for a value are:

```text
[a0, a1, a2, ...]
```

For the current index `idx` at position `i` inside this group:

#### Left Contribution

Distance from all elements on the left:

```text
idx * i - prefixSum
```

Where:

* `i` = number of elements on the left
* `prefixSum` = sum of all left-side indices

---

#### Right Contribution

Distance from all elements on the right:

```text
(totalSum - prefixSum - idx) - idx * (sz - i - 1)
```

Where:

* `totalSum` = sum of all indices in the group
* `sz` = size of the group

---

### Simplified Formula

Combining both left and right contributions:

```text
totalSum - 2 * prefixSum + idx * (2 * i - sz)
```

This allows every answer to be computed in O(1) time while traversing the group once.

---

## Time Complexity

### Building Groups

```text
O(n)
```

### Processing All Groups

Each index is processed exactly once:

```text
O(n)
```

### Total Complexity

```text
O(n)
```
